package assignment;

import org.junit.Test;

import java.time.LocalDate;
import static org.junit.Assert.*;
import static org.junit.Assert.assertNotEquals;

public class SingleCustomerTest {
    SingleCustomer s1 = new SingleCustomer(
            "8808120000",
            "Patrik",
            "Ellboj",
            LocalDate.now().minusMonths(4));
    SingleCustomer s2 = new SingleCustomer(
            "7909010000",
            "Göran",
            "Göransson",
            LocalDate.now().minusYears(2));
    SingleCustomer s3 = new SingleCustomer(
            "9004050000",
            "Göran",
            "Göransson",
            LocalDate.now().minusDays(2));

    @Test
    public void testValidMembership() {
        assertTrue(s1.getValidMembership());
        assertFalse(s2.getValidMembership());
        assertTrue(s3.getValidMembership());

    }

    @Test
    public void testPersonNumberLength() {
        assertNotEquals(9, s1.getPersonNumber().length());
        assertNotEquals(11, s1.getPersonNumber().length());
        assertEquals(10, s1.getPersonNumber().length());
    }

    @Test
    public void isPersonNumberCorrect() {
        assertEquals("8808120000", s1.getPersonNumber());
        assertNotEquals("8808120000 ", s1.getPersonNumber());
        assertNotEquals(" 8808120000", s1.getPersonNumber());
        assertNotEquals("7909010000", s1.getPersonNumber());
        assertNotEquals("8808120000", s2.getPersonNumber());
    }
}
