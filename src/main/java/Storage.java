import java.io.File;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Storage {
    private String filename;

    public Storage(String filename) {
        this.filename = filename;
    }

    public ArrayList<Task> loadFile() {
        String sadFace = "\u2639";
        try {
            File fileLocation = new File(System.getProperty("user.dir") + "/data");
            File dataFile = new File(fileLocation, this.filename);
            if (!fileLocation.exists()) {
                fileLocation.mkdir();
                //throw new DukeException("Database Directory not found. Creating Directory...");
            }
            BufferedReader scanData = new BufferedReader(new FileReader(dataFile));
            String userInput;
            ArrayList<Task> overallList = new ArrayList<>();
            while ((userInput = scanData.readLine()) != null) {
                String[] details = userInput.split("\\|");
                switch (details[0]) {
                    case "T":
                        overallList.add(new Todo(details[2].trim()));
                        break;
                    case "D":
                        overallList.add(new Deadline(details[2].trim(), details[3].trim()));
                        break;
                    case "E":
                        overallList.add(new Event(details[2].trim(), details[3].trim()));
                        break;
                }
                if (details[1].equals("1")) {
                    overallList.get(overallList.size() - 1).setDone();
                }
            }
            return overallList;
        } catch (IOException e) {
            System.out.println("\t " + sadFace + "  OOPS! IOException: " + e.getMessage());
            return new ArrayList<>();
        } catch (IndexOutOfBoundsException e) {
            System.out.println("\t " + sadFace + "  OOPS! IndexOutOfBoundsException: " + e.getMessage());
            return new ArrayList<>();
        } catch (DukeException e) {
            System.out.println(e.getMessage());
            return new ArrayList<>();
        }
    }

    public void editFile(ArrayList<Task> list) {
        try {
            File fileLocation = new File(System.getProperty("user.dir") + "/data");
            File dataFile = new File(fileLocation, this.filename);
            BufferedWriter editData = new BufferedWriter(new FileWriter(dataFile));
            for (Task scanning : list) {
                editData.write(scanning.fileFormat());
                editData.newLine();
            }
            editData.flush();
            editData.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}