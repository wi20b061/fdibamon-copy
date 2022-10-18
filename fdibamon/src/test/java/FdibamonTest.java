import org.junit.Test;

import static org.junit.Assert.*;

public class FdibamonTest {

    @Test
    public void test_fdibamon_is_created_properly() {
        //3A Principle
        //Arrange
        Fdibamon fdibamon = new Fdibamon("Hans", 10, 10);
        //Act
        //Assert
        assertEquals(Fdibamon.class, fdibamon.getClass());
    }

    @Test
    public void test_get_name_function_works_properly() {
        //3A Principle
        //Arrange
        Fdibamon fdibamon = new Fdibamon("Hans", 10, 10);
        //Act
        String name = fdibamon.getName();
        //Assert
        assertEquals("Hans", fdibamon.getName());
    }
}