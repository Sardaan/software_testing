package lab1.domain.actions;

import lab1.domain.objects.Dot;
import lab1.domain.objects.Sun;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.LinkedList;
import java.util.List;

import static com.sun.tools.javac.util.List.of;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class SceneTest {

    private Scene scene1;
    private Scene scene2;
    private Dot dot;
    private Sun sun1;
    private Sun sun2;
    private EventHandler eventHandlerMock;
    private LinkedList<Event> events;
    private List<Action> actions;

    @BeforeEach
    private void init(){
        scene1 = new Scene("Scene 1");
        dot = new Dot(1);
        sun1 = new Sun(2, true);
        sun2 = new Sun(3, true);
        eventHandlerMock = Mockito.mock(EventHandler.class);

        scene2 = new Scene("Scene 2");
        scene2.applyAction(dot::appear);
        scene2.applyAction(sun1::appear);
        scene2.applyAction(sun2::appear);
        scene2.applyAction(sun1::burn);
        scene2.applyAction(sun2::burn);

        events = scene2.getEvents();
        actions = of(
                dot::appear,
                sun1::appear,
                sun2::appear,
                sun1::burn,
                sun2::burn
        );

        scene2.setEventHandler(eventHandlerMock);
        actions.forEach(scene1::applyAction);
    }

    @Test
    public void getTitleTest(){
        assertEquals("Scene 1", scene1.getTitle());
    }

    @Test
    public void amountOfEventsTest() {
        assertEquals(5, scene2.getEvents().size());
    }

    @Test
    public void sceneDescriptionTest() {


        assertEquals("Scene : Scene 1\n"+
                "--------------------\n"+
                "[Event - APPEAR] => Subject: Dot; Description: Dot number 1 is appeared\n"+
                "[Event - APPEAR] => Subject: Sun; Description: Sun number 2 is appeared\n"+
                "[Event - APPEAR] => Subject: Sun; Description: Sun number 3 is appeared\n"+
                "[Event - BURN] => Subject: Sun; Description: Sun number 2 start burning\n"+
                "[Event - BURN] => Subject: Sun; Description: Sun number 3 start burning" , scene1.sceneDescription());

    }

    @Test
    public void sceneSequenceTest() {

        events.forEach(event -> System.out.println("[" + event.getEventType().toString() + "] " + event.getDescription()));

        assertAll(
                () -> assertEquals("Dot number 1 is appeared", events.get(0).getDescription()),
                () -> assertEquals(EventType.APPEAR, events.get(0).getEventType()),

                () -> assertEquals("Sun number 2 is appeared", events.get(1).getDescription()),
                () -> assertEquals(EventType.APPEAR, events.get(1).getEventType()),

                () -> assertEquals("Sun number 3 is appeared", events.get(2).getDescription()),
                () -> assertEquals(EventType.APPEAR, events.get(2).getEventType()),

                () -> assertEquals("Sun number 2 start burning", events.get(3).getDescription()),
                () -> assertEquals(EventType.BURN, events.get(3).getEventType()),

                () -> assertEquals("Sun number 3 start burning", events.get(4).getDescription()),
                () -> assertEquals(EventType.BURN, events.get(4).getEventType())
        );



    }

}
