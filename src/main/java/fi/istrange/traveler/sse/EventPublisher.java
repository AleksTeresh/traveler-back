package fi.istrange.traveler.sse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.*;

/**
 * Created by aleksandr on 7.5.2017.
 */
public class EventPublisher {
    private static final Logger LOG = LoggerFactory.getLogger(EventPublisher.class);
    private static final Map<Long, List<SseEventSource>> rooms = Collections.synchronizedMap(new HashMap<>());
    // private static List<SseEventSource> listeners = Collections.synchronizedList(new ArrayList<SseEventSource>());

    public static void pub(String message, Long roomIdx) {
        LOG.info("pushing: " + message);
        synchronized(rooms) {
            if (!rooms.containsKey(roomIdx)) {
                rooms.put(roomIdx, Collections.synchronizedList(new ArrayList<SseEventSource>()));
            }

            Iterator<SseEventSource> iterator = rooms.get(roomIdx).iterator();
            while(iterator.hasNext()) {
                SseEventSource sseEventSource = (SseEventSource)iterator.next();
                try {
                    sseEventSource.emitEvent(message);
                }
                catch(IOException e) {
                    LOG.error(e.getMessage());
                }
            }
        }
    }

    public static void addListener(SseEventSource l, Long roomIdx) {
            if (!rooms.containsKey(roomIdx)) {
                rooms.put(roomIdx, Collections.synchronizedList(new ArrayList<SseEventSource>()));
            }

            rooms.get(roomIdx).add(l);
    }

    public static void removeListener(SseEventSource l) {
        rooms.values().stream().forEach(p -> {
            if (p.contains(l)) {
                p.remove(l);
            }
        });
    }
}
