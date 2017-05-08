package fi.istrange.traveler.sse;

import org.eclipse.jetty.servlets.EventSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.Objects;
import java.util.UUID;

/**
 * Created by aleksandr on 7.5.2017.
 */
public class SseEventSource implements EventSource {

    private static final Logger LOG = LoggerFactory.getLogger(SseEventSource.class);

    private Emitter emitter;
    private String id;

    public SseEventSource() {
        this.id = UUID.randomUUID().toString();
    }
    @Override
    public void onOpen(Emitter emitter) throws IOException {
        LOG.info("onOpen");
        this.emitter = emitter;
        emitter.data("Data on open");
        emitter.event("first param", "second param");
        System.out.println(emitter.toString());
    }

    @Override
    public void onClose() {
        LOG.info("onClose");
        EventPublisher.removeListener(this);
    }

    public void emitEvent(String dataToSend) throws IOException {
        LOG.info("emitEvent", dataToSend);
        this.emitter.data(dataToSend);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(this.id);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof SseEventSource) {
            SseEventSource that = (SseEventSource)obj;
            return Objects.equals(this.id, that.id);
        }
        return false;
    }
}
