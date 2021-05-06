import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Scanner;

public class Training {

    private static ArrayList<Object> activity;
    private static ArrayList<Object> log;

    private static Scanner input;
    private final static String trainingfile = "Activity.dat";
    private final static String sessionfile = "Log.dat";

    public void start() throws FileNotFoundException, ClassNotFoundException, IOException {

        input = new Scanner(System.in);
        if (Lib_File.isExistentAndReadibleBoolean(trainingfile)) {
            activity = Lib_File.deserializeObjects(trainingfile);
        } else {
            activity = new ArrayList<Object>();
        }
        if (Lib_File.isExistentAndReadibleBoolean(sessionfile)) {
            log = Lib_File.deserializeObjects(sessionfile);
        } else {
            log = new ArrayList<Object>();
        }

    }

    public static void main(String[] args) throws Exception {

        new Training().start();

        String className = "Training";
        ArrayList<String> menue = new ArrayList<String>();

        menue.add("Add Activity");
        menue.add("Log Activity");
        menue.add("Show Activity Log");
        menue.add("Edit Activity");
        menue.add("Exit");

        new Lib_Dialog().start(menue, className);

    }

    public void AddActivity() throws ClassNotFoundException, IOException {

        System.out.print("\nName of Activity: ");
        String name = input.nextLine();

        Session session = new Session(name);
        activity.add(session);

        Lib_File.serializeArrayList(activity, trainingfile);
    }

    public void LogActivity() throws IOException {

        Lib_Dialog.printMenue(activity);
        int option = Lib_Dialog.chooseOption();

        Session session = new Session(activity.get(option - 1).toString());
        session.setDate(LocalDate.now().toString());
        session.setTime(LocalTime.now().toString());

        System.out.print("Unit:");
        session.setUnit(input.nextLine());

        System.out.print("Duration: ");
        session.setDuration(input.nextDouble());

        log.add(session);

        Lib_File.serializeArrayList(log, sessionfile);
    }

    public void ShowActivityLog() {
        Lib_Dialog.printMenue(activity);
    }

    public void EditActivity() {
        Lib_Dialog.printMenue(activity);

        System.out.print("Wich one you desire to edit? :");
        int option = input.nextInt();

        System.out.print("\nEnter new Name:");
        // TODO: find a idea to rename or replace the object
    }

    public void Exit() {
        System.out.println("End");
        System.exit(0);
    }

}