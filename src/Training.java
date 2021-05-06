import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Scanner;

public class Training {

    private static ArrayList<Session> activity;
    private static ArrayList<Session> log;

    private static Scanner input;
    private final static String activityfile = "Activity.dat";
    private final static String sessionfile = "Log.dat";

    public void start() throws FileNotFoundException, ClassNotFoundException, IOException {

        input = new Scanner(System.in);
        if (Lib_File.isExistentAndReadibleBoolean(activityfile)) {
            activity = (ArrayList<Session>) Lib_File.deserialize(activityfile);
        } else {
            activity = new ArrayList<Session>();
        }
        if (Lib_File.isExistentAndReadibleBoolean(sessionfile)) {
            log = (ArrayList<Session>) Lib_File.deserialize(sessionfile);
        } else {
            log = new ArrayList<Session>();
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

        Lib_File.serialize(activity, activityfile);
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

        Lib_File.serialize(log, sessionfile);
    }

    public void ShowActivityLog() {
        Lib_Dialog.printMenue(activity);
    }

    public void EditActivity() throws IOException {
        Lib_Dialog.printMenue(activity);

        System.out.println("Wich one you desire to edit? :");

        int menuepunkt = Lib_Dialog.chooseOption();

        System.out.println("Enter new Name:");

        String names = input.nextLine();

        activity.get(menuepunkt - 1).setName(names);

        log.forEach((p) -> p.setName(names));

    }

    public void Exit() throws IOException {

        Lib_File.serialize(activity, activityfile);
        Lib_File.serialize(log, sessionfile);

        System.out.println("End");
        System.exit(0);
    }

}