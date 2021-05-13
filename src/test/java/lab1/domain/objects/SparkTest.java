package lab1.domain.objects;

import lab1.domain.actions.Event;
import lab1.domain.actions.EventType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

public class SparkTest {

    private Spark spark;
    private Event appearEvent;

    @BeforeEach
    private void init(){
        spark = new Spark(1);
        appearEvent = spark.appear();
    }

    @Test
    void constructorTest(){
        assertEquals(1, spark.getId());
    }
    @Test
    void getObjectTypeNameTest() {
        assertEquals("Spark", spark.getObjectTypeName());
    }

    @Test
    void appearTest() {

        assertAll(
                () -> assertTrue(appearEvent.getPhysicalObject().isPresent()),
                () -> assertEquals(spark, appearEvent.getPhysicalObject().get()),
                () -> assertEquals(EventType.APPEAR, appearEvent.getEventType()),
                () -> assertNotNull(appearEvent.getDescription()));
    }

}
