import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Scanner;

public class Activity {

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

        new Activity().start();

        String className = "Activity";
        ArrayList<String> menue = new ArrayList<String>();

        menue.add("Add Activity");
        menue.add("Log Activity");
        menue.add("Show Activity Log");
        menue.add("Edit Activity");
        menue.add("Exit");

        new Lib_Dialog().start(menue, className);

    }

    public void addActivity() throws ClassNotFoundException, IOException {

        System.out.print("\nName of Activity: ");
        String name = input.nextLine();

        Session session = new Session(name);
        activity.add(session);

        Lib_File.serialize(activity, activityfile);
    }

    public void logActivity() throws IOException {

        Lib_Dialog.printMenue(activity);
        int option = Lib_Dialog.chooseOption();

        Session session = new Session(activity.get(option - 1).toString());
        session.setDate(LocalDate.now().toString());
        session.setTime(LocalTime.now().toString().replaceAll(
                "(" + Lib_Regex.LOOKBEHIND + Lib_Regex.HOURMINUTESECOND + ")" + Lib_Regex.ALLCHARACTERS, ""));

        System.out.print("Unit:");
        session.setUnit(input.nextLine());

        System.out.print("Duration: ");
        session.setDuration(input.nextDouble());

        log.add(session);

        Lib_File.serialize(log, sessionfile);
    }

    public void showActivityLog() {
        Lib_Dialog.printMenue(activity);
        int option = Lib_Dialog.chooseOption();

        log.forEach((p) -> {
            if (activity.get(option - 1).getName().equals(p.getName())) {
                System.out.println(String.format("Name: %s Date: %s Time: %s Duration: %s %s", p.getName(), p.getDate(),
                        p.getTime(), p.getDuration(), p.getUnit()));
            }
        });

    }

    public void editActivity() throws IOException {

        Lib_Dialog.printMenue(activity);
        System.out.println("Wich one you desire to edit? :");
        int menuepunkt = Lib_Dialog.chooseOption();
        System.out.println("Enter new Name:");
        String names = input.nextLine();
        activity.get(menuepunkt - 1).setName(names);
        log.forEach((p) -> p.setName(names));

    }

    public void exit() throws IOException {

        Lib_File.serialize(activity, activityfile);
        Lib_File.serialize(log, sessionfile);

        System.out.println("End");
        System.exit(0);
    }

}