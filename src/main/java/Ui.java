public class Ui {
    public static void printLine() {
        String line = "\t____________________________________________________";
        System.out.println(line);
    }

    public static void initialize() {
        String logo = " \t____        _        \n"
                + "\t|  _ \\ _   _| | _____ \n"
                + "\t| | | | | | | |/ / _ \\\n"
                + "\t| |_| | |_| |   <  __/\n"
                + "\t|____/ \\__,_|_|\\_\\___|\n";

        System.out.println("\tHello from\n" + logo);
        printLine();
        System.out.println("\tHello! I'm Duke");
        System.out.println("\tWhat can I do for you? " + "\uD83D\uDE0A");
        printLine();
    }

    public static void printBye() {
        System.out.println("\tBye. Hope to see you again soon! " + "\uD83D\uDC4B");
        printLine();
    }

    /*public static void printAddedMessage(Task t) {
        System.out.println("\t Got it. I've added this task:");
        System.out.println("\t   " + t);
        System.out.println(String.format("\t Now you have %d tasks in your list.", list.size()));
        printLine();
    }*/
}
