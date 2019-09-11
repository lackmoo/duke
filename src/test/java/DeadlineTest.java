import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DeadlineTest {

    @Test
    void fileFormat() throws DukeException {
        Task t = new Deadline("return book", "04/10/2019 17:00");
        assertEquals("D|0|return book|04/10/2019 17:00", t.fileFormat());
        t.setDone();
        assertEquals("D|1|return book|04/10/2019 17:00", t.fileFormat());
    }

    @Test
    void testToString() throws DukeException {
        Task t = new Deadline("return book", "04/10/2019 17:00");
        assertEquals("[D][✘] return book (by: 04/10/2019 17:00)", t.toString());
        t.setDone();
        assertEquals("[D][✓] return book (by: 04/10/2019 17:00)", t.toString());
    }
}