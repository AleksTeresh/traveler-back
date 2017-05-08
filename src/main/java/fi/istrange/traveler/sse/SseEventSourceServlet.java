package fi.istrange.traveler.sse;

import org.eclipse.jetty.servlets.EventSource;
import org.eclipse.jetty.servlets.EventSourceServlet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
/**
 * Created by aleksandr on 7.5.2017.
 */

@SuppressWarnings("serial")
public class SseEventSourceServlet extends EventSourceServlet {
    private static final Logger LOG = LoggerFactory.getLogger(SseEventSourceServlet.class);

    @Override
    protected EventSource newEventSource(HttpServletRequest request) {
        LOG.info("SseEventSourceServlet");
        SseEventSource l = new SseEventSource();
        EventPublisher.addListener(
                l,
                Long.parseLong(processPath(request.getPathInfo()))
        );
        return l;
    }

    private String processPath (String path) {
        String processed = path.substring(1);

        if (processed.charAt(processed.length() - 1) == '/') {
            processed = processed.substring(0, processed.length() - 1);
        }

        return processed;
    }
}
