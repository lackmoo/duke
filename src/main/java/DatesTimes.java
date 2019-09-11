import java.util.List;
import java.util.Arrays;

/**
 * Class to make sense of the date and time details specified by the user.
 */
public class DatesTimes {
    /**
     * The day, month and year details as specified by the user.
     */
    private int day;
    private int month;
    private int year;

    /**
     * The hour and minute details as specified by the user.
     */
    private int hour;
    private int min;

    /**
     * Class constructor. To split the overall datetime information into the respective date and time information.
     *
     * @param dateTime The String that consists of both the date and time details of the task.
     * @throws DukeException if the datetime values are invalid or the datetime format is invalid.
     */
    public DatesTimes (String dateTime) throws DukeException {
        String[] initialSplit = dateTime.split(" ");
        List<String> splitDateTime = Arrays.asList(initialSplit);
        String sadFace = "\u2639";
        try {
            String date = splitDateTime.get(0);
            String time = splitDateTime.get(1);

            String[] dateSplit = date.split("/");
            List<String> dateSection = Arrays.asList(dateSplit);
            this.day = Integer.parseInt(dateSection.get(0));
            this.month = Integer.parseInt(dateSection.get(1));
            this.year = Integer.parseInt(dateSection.get(2));

            String[] timeSplit = time.split(":");
            List<String> timeSection = Arrays.asList(timeSplit);
            this.hour = Integer.parseInt(timeSection.get(0));
            this.min = Integer.parseInt(timeSection.get(1));

            if (this.day < 0 || this.day > 31 || this.month < 0 || this.month > 12
                    || this.year < 0 || this.hour < 0 || this.hour > 24 || this.min < 0 || this.min > 59) {
                throw new DukeException("\t " + sadFace + "  OOPS!!! The datetime values are invalid. Please insert valid datetime values.");
            }
        } catch (IndexOutOfBoundsException | NumberFormatException e) {
            throw new DukeException("\t " + sadFace + "  OOPS!!! The datetime format is invalid. Valid Deadline datetime format is: dd/mm/yy hh:mm and Event datetime format is: dd/mm/yy hh:mm - dd/mm/yy hh:mm.");
        }
    }

    /**
     * Formats the output of the date and time information to be printed on the command line when Duke is run.
     *
     * @return the date and time information of the deadline/event in the required format for the output on the command line.
     */
    @Override
    public String toString() {
        return String.format("%02d/%02d/%04d %02d:%02d", this.day, this.month, this.year, this.hour, this.min);
    }
}