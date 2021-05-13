package lab1.domain.actions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class EventHandlerTest {

    private EventHandler eventHandler;
    @BeforeEach
    private void init(){
        eventHandler = new EventHandler();
    }

    @Test
    void nullPass() {
        assertThrows(IllegalArgumentException.class, () -> eventHandler.handleEvent(null));
    }

    @Test
    void sampleTest() {
        assertNotNull(eventHandler.handleEvent(Event.of("Test event", EventType.BURN)));
    }



}
