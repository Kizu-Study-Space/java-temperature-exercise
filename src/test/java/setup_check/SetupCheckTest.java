package setup_check;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SetupCheckTest {

    @Test
    public void checkApplication() {
        SetupCheck setupCheck = new SetupCheck();
        assertEquals(10, setupCheck.check());
    }
}
