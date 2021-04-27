import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Scanner;

public class Training {

    private static Scanner input;

    public void start() {

        input = new Scanner(System.in);

    }

    public static void main(String[] args) throws Exception {

        new Training().start();

        String className = "Training";
        ArrayList<String> menue = new ArrayList<String>();

        menue.add("Training hinzufuegen");
        menue.add("Programm beenden");

        new Lib_Dialog().start(menue, className);

    }

    public void Traininghinzufuegen() {

        try {

            FileWriter myWriter = new FileWriter("Training.txt", true);

            String ausgabe = "";

            ArrayList<String> training = new ArrayList<String>();

            training.add("Anzahl Push-Up: ");
            training.add("Anzahl Sit-Up ");
            training.add("Anzahl Squat: ");
            training.add("Anzahl Pull-Up: ");

            myWriter.write(
                    String.format("Datum: %s Uhrzeit: %s\n", LocalDate.now().toString(), LocalTime.now().toString()));

            for (String string : training) {

                System.out.print(string.toString());
                int zahl = input.nextInt();

                ausgabe = String.format("%s %d\n", string, zahl);

                myWriter.write(ausgabe);

            }
            myWriter.write("\n");
            myWriter.close();
        } catch (IOException e) {
        }

    }

    public void Programmbeenden() {
        System.out.println("Programm beendet");
        System.exit(0);
    }

}