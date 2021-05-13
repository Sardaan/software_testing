package lab1.domain.actions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class EventTest {

    private String description;
    private EventType eventType;
    private Event event;

    @BeforeEach
    private void init(){
        description = "Test event";
        eventType = EventType.BURN;
        event = Event.of(description, eventType);
    }

    @Test
    void eventOfDescriptionTest() {
        assertEquals(description, event.getDescription());
    }

    @Test
    void eventOfEventTypeTest() {
        assertEquals(eventType, event.getEventType());
    }
}
