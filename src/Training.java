import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Scanner;

public class Training {

    private static ArrayList<Object> training;
    private static ArrayList<Object> sessions;

    private static Scanner input;
    private final static String trainingfile = "Training.dat";
    private final static String sessionfile = "Session.dat";

    public void start() throws FileNotFoundException, ClassNotFoundException, IOException {

        input = new Scanner(System.in);
        if (Lib_File.isExistentAndReadibleBoolean(trainingfile)) {
            training = Lib_File.deserializeObjects(trainingfile);
        }
        if (Lib_File.isExistentAndReadibleBoolean(sessionfile)) {
            sessions = Lib_File.deserializeObjects(sessionfile);
        }

    }

    public static void main(String[] args) throws Exception {

        new Training().start();

        String className = "Training";
        ArrayList<String> menue = new ArrayList<String>();

        menue.add("Trainingspunkt hinzufuegen");
        menue.add("Trainingspunkte einsehen");
        menue.add("Session hinzufuegen");
        menue.add("Programm beenden");

        new Lib_Dialog().start(menue, className);

    }

    public void Trainingspunkthinzufuegen() throws ClassNotFoundException, IOException {

        System.out.print("\nName des Trainings: ");
        String name = input.nextLine();

        Session session = new Session(name);
        training.add(session);

        Lib_File.serializeArrayList(training, trainingfile);
    }

    public void Trainingspunkteeinsehen() {

    }

    public void Sessionhinzufuegen(ArrayList<Session> training) {

        Lib_Dialog.printMenue(training);
        int option = Lib_Dialog.chooseOption();

        Session session = new Session(training.get(option - 1).getName());
        session.setDate(LocalDate.now().toString());
        session.setTime(LocalTime.now().toString());

        System.out.print("Einheit:");
        session.setEinheit(input.nextLine());

        System.out.print("Dauer: ");
        session.setMenge(input.nextDouble());

    }

    public void Programmbeenden() {
        System.out.println("Programm beendet");
        System.exit(0);
    }

}