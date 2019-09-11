import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EventTest {

    @Test
    void fileFormat() throws DukeException {
        Task t = new Event("project meeting", "04/10/2019 17:00 - 04/10/2019 19:00");
        assertEquals("E|0|project meeting|04/10/2019 17:00 - 04/10/2019 19:00", t.fileFormat());
        t.setStatus();
        assertEquals("E|1|project meeting|04/10/2019 17:00 - 04/10/2019 19:00", t.fileFormat());
    }

    @Test
    void testToString() throws DukeException {
        Task t = new Event("project meeting", "04/10/2019 17:00 - 04/10/2019 19:00");
        assertEquals("[E][✘] project meeting (at: 04/10/2019 17:00 - 04/10/2019 19:00)", t.toString());
        t.setStatus();
        assertEquals("[E][✓] project meeting (at: 04/10/2019 17:00 - 04/10/2019 19:00)", t.toString());
    }
}