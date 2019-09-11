import org.junit.jupiter.api.Test;

import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class ParserTest {

    @Test
    void testReadInputTodo() {
        Parser parser = new Parser();
        parser.in = new Scanner("todo return book");
        String[] userCommand = parser.readInput();
        assertTrue(userCommand[0].equals("todo") && userCommand[1].equals("return book"));
    }

    @Test
    void testReadInputDeadline() {
        Parser parser = new Parser();
        parser.in = new Scanner("deadline submit assignment 05/09/2019 23:59");
        String[] userCommand = parser.readInput();
        assertTrue(userCommand[0].equals("deadline") && userCommand[1].equals("submit assignment 05/09/2019 23:59"));
    }

    @Test
    void testReadInputEvent() {
        Parser parser = new Parser();
        parser.in = new Scanner("event attend birthday party 04/10/2019 19:00 - 04/10/2019 22:00");
        String[] userCommand = parser.readInput();
        assertTrue(userCommand[0].equals("event") && userCommand[1].equals("attend birthday party 04/10/2019 19:00 - 04/10/2019 22:00"));
    }
}