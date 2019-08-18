import java.util.Scanner;
import java.util.ArrayList;
public class Duke {
    public static void printLine() {
        String line = "\t____________________________________________________";
        System.out.println(line);
    }
    public static void main(String[] args) {
        String logo = " \t____ _ \n"
                + "\t| _ \\ _ _| | _____ \n"
                + "\t| | | | | | | |/ / _ \\\n"
                + "\t| |_| | |_| | < __/\n"
                + "\t|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("\tHello from\n" + logo);
        printLine();
        System.out.println("\tHello! I'm Duke");
        System.out.println("\tWhat can I do for you?");
        printLine();
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> list = new ArrayList<>();
        String input = scanner.nextLine();
        /*while (!input.equals("bye")) {
            printLine();
            System.out.println(input);
            printLine();
            input = scanner.nextLine();
          }
            printLine();
            System.out.println("Bye. Hope to see you again soon!");
            printLine();
         */
        while (!input.equals("bye")) {
            if (!input.equals("list")) {
                list.add(input);
                printLine();
                System.out.println("\tadded: " + input);
                printLine();
            } else {
                printLine();
                for (int i = 1; i <= list.size(); i++) {
                    System.out.println("\t" + i + ". " + list.get(i-1));
                }
                printLine();
            }
            input = scanner.nextLine();
        }
        printLine();
        System.out.println("\tBye. Hope to see you again soon!");
        printLine();
    }
}