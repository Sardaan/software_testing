package lab1.domain.objects;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PhysicalObjectTest {

    private PhysicalObject physicalObject1;
    private PhysicalObject physicalObject2;
    private PhysicalObject physicalObject3;


    @BeforeEach
    private void init(){
        physicalObject1 = new PhysicalObject(1);
        physicalObject2 = new PhysicalObject(1);
        physicalObject3 = new PhysicalObject(3);


    }
    @Test
    void equalsCheckTest() {
        assertEquals(physicalObject1, physicalObject2);
    }

    @Test
    void defaultPhysicalObjectTypeTest() {
        assertEquals("Physical object", physicalObject1.getObjectTypeName());
    }

    @Test
    void defaultAppearEventTest() {
        assertNotNull(physicalObject1.appear());
    }

    @Test
    void equalsHashcodeContractTest() {

        assertAll(() -> assertEquals(physicalObject1, physicalObject2),
                () -> assertEquals(physicalObject1.hashCode(), physicalObject2.hashCode()),
                () -> assertNotEquals(physicalObject1, physicalObject3));
    }

}
