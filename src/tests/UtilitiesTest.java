package tests;

import app.Utilities;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class UtilitiesTest {
    @Test
    public void testParseIntValid() {
        var a = Utilities.parseInt("32");
        Assertions.assertFalse(a.isEmpty());
        Assertions.assertEquals(32, a.get());
    }

    @Test
    public void testParseIntInvalid() {
        var a = Utilities.parseInt("fdsfds");
        Assertions.assertTrue(a.isEmpty());
    }
}
