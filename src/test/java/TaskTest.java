import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TaskTest {


    @Test
    void testToString() {
        Task t = new Task("finish assignment");
        assertEquals("[✘] finish assignment", t.toString());
        t.setStatus();
        assertEquals("[✓] finish assignment", t.toString());
    }

    @Test
    void fileFormat() {
        Task t = new Task("go shopping");
        assertEquals("0|go shopping", t.fileFormat());
        t.setStatus();
        assertEquals("1|go shopping", t.fileFormat());
    }
}