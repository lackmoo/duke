public class DatesTimes {
    private int day;
    private int month;
    private int year;

    private int hour;
    private int min;

    public DatesTimes (String dateTime) throws DukeException {
        try {
            String[] splitDateTime;
            splitDateTime = dateTime.split(" ");
            String Date = splitDateTime[0];
            String Time = splitDateTime[1];

            String[] splitDate;
            splitDate = Date.split("/");
            this.day = Integer.parseInt(splitDate[0]);
            this.month = Integer.parseInt(splitDate[1]);
            this.year = Integer.parseInt(splitDate[2]);

            int finalTime = Integer.parseInt(Time);
            int finalHour = finalTime / 100;
            int[] finalMin = new int[2];
            finalMin[0] = finalTime % 10;
            finalTime /= 10;
            finalMin[1] = finalTime % 10;
            int finalFinalMin = (finalMin[1] * 10) + finalMin[0];
            this.hour = finalHour;
            this.min = finalFinalMin;

            if (this.day < 0 || this.day > 31 || this.month < 0 || this.month > 12
                    || this.year < 0 || this.hour < 0 || this.hour > 24 || this.min < 0 || this.min > 59) {
                throw new DukeException("\t \u2639  OOPS!!! The datetime format is invalid, please provide a valid input.");
            }
        } catch (DukeException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public String toString() {
        return String.format("%02d/%02d/%04d %02d:%02d",
                this.day, this.month, this.year, this.hour, this.min);
    }
}
