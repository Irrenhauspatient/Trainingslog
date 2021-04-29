
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
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

        menue.add("Trainingspunkt hinzufuegen");
        menue.add("Trainingspunkte einsehen");
        menue.add("Programm beenden");

        new Lib_Dialog().start(menue, className);

    }

    public void Trainingspunkthinzufuegen() throws ClassNotFoundException {

        try {

            System.out.print("\nName des Trainings: ");
            String name = input.nextLine();
            System.out.print("\nEinheit angeben:");
            String einheit = input.nextLine();

            ArrayList<Object> training = new ArrayList<Object>();

            Session session = new Session(name, einheit);

            training.add(session);

            FileOutputStream fos = new FileOutputStream("Trainings.txt");
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            for (Object object : training) {
                oos.writeObject(object);
            }

            oos.close();
        } catch (IOException e) {

        }

    }

    public ArrayList<Object> Trainingspunkteeinsehen() throws IOException, ClassNotFoundException {
        try {
            FileInputStream fis = new FileInputStream("Trainings.txt");
            ObjectInputStream ois = new ObjectInputStream(fis);

            ArrayList<Object> training = new ArrayList<Object>();

            Object object;

            while ((object = (Object) ois.readObject()) != null) {
                training.add(object);

            }
            ois.close();
            return training;
        } catch (EOFException e) {
            System.out.println("");
        }
        return null;
    }

    public void Programmbeenden() {
        System.out.println("Programm beendet");
        System.exit(0);
    }

}