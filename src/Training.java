import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Scanner;

public class Training {

    private static Scanner input;
    ArrayList<Session> training;

    public void start() {

        input = new Scanner(System.in);

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

    public void Trainingspunkthinzufuegen() throws ClassNotFoundException {

        ArrayList<Session> training = new ArrayList<Session>();

        System.out.print("\nName des Trainings: ");
        String name = input.nextLine();
        System.out.print("\nEinheit angeben:");
        String einheit = input.nextLine();

        Session session = new Session(name, einheit);
        training.add(session);
    }

    public void Trainingspunkteeinsehen() {

    }

    public void Sessionhinzufuegen(ArrayList<Session> training) {

        Lib_Dialog.printMenue(training);
        int option = Lib_Dialog.chooseOption();

        Session session = new Session(training.get(option - 1).getName(), training.get(option - 1).getEinheit());
        session.setDate(LocalDate.now().toString());
        session.setTime(LocalTime.now().toString());

        System.out.print("Dauer: ");
        double dauer = input.nextDouble();

    }

    public void Programmbeenden() {
        System.out.println("Programm beendet");
        System.exit(0);
    }

}