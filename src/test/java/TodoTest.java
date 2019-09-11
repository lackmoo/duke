import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TodoTest {

    @Test
    void fileFormat() {
        Task t = new Todo("attend lecture");
        assertEquals("T|0|attend lecture", t.fileFormat());
        t.setDone();
        assertEquals("T|1|attend lecture", t.fileFormat());

    }

    @Test
    void testToString() {
        Task t = new Todo("attend lecture");
        assertEquals("[T][✘] attend lecture", t.toString());
        t.setStatus();
        assertEquals("[T][✓] attend lecture", t.toString());
    }
}
