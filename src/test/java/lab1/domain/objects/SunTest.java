package lab1.domain.objects;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SunTest {

    private Sun sun;
    @BeforeEach
    private void init(){
        sun = new Sun(1, false);
        sun.burn();
    }

    @Test
    void objectTypeTest(){
        assertEquals("Sun", sun.getObjectTypeName());
    }

    @Test
    void isBurningTest(){
        assertEquals(true, sun.isBurning());
    }
}
