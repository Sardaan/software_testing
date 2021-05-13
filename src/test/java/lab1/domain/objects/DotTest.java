package lab1.domain.objects;
import lab1.domain.actions.Event;
import lab1.domain.actions.EventType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DotTest {

    private Dot dot;
    private Event appearEvent;

    @BeforeEach
    private void init(){
        dot = new Dot(1);
        appearEvent = dot.appear();
    }

    @Test
    void constructorTest(){
        assertEquals(1, dot.getId());
    }
    @Test
    void getObjectTypeNameTest() {
        assertEquals("Dot", dot.getObjectTypeName());
    }

    @Test
    void appearTest() {

        assertAll(
                () -> assertTrue(appearEvent.getPhysicalObject().isPresent()),
                () -> assertEquals(dot, appearEvent.getPhysicalObject().get()),
                () -> assertEquals(EventType.APPEAR, appearEvent.getEventType()),
                () -> assertNotNull(appearEvent.getDescription()));
    }

}
