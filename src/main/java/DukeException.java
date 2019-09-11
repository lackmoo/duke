/**
 * The customised exception class that extends from the Exception class.
 */
public class DukeException extends Exception {
    /**
     * Class constructor.
     *
     * @param errorMessage The error message that is specified that is to be printed as output to notify the user of the error.
     */
    public DukeException(String errorMessage) {
        super(errorMessage);
    }
}
