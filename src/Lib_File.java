import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class Lib_File {

    public static void serialize(Object object, String filename) throws IOException {

        File file = new File(filename);

        FileOutputStream fos = new FileOutputStream(file);
        ObjectOutputStream oos = new ObjectOutputStream(fos);

        oos.writeObject(object);

        oos.close();
        fos.close();
    }

    public static Object deserialize(String filename) throws IOException, ClassNotFoundException {

        File file = new File(filename);

        FileInputStream fis = new FileInputStream(file);
        ObjectInputStream ois = new ObjectInputStream(fis);

        Object object = (ois.readObject());

        ois.close();
        fis.close();

        return object;
    }

    public static ArrayList<String> readLinebyLine(String filename) throws IOException {

        File file = new File(filename);
        ArrayList<String> list = (ArrayList<String>) Files.readAllLines(Paths.get(file.getAbsolutePath()));

        return list;

    }

    public static boolean isExistentAndReadibleBoolean(String filename) throws FileNotFoundException {
        File file = new File(filename);
        if (file.exists() && file.canRead() && !file.isDirectory()) {
            return true;
        }
        return false;
    }

    public static <T> void writeTextToFile(ArrayList<T> lise, String filename, boolean append) throws IOException {

        FileWriter filewriter = new FileWriter(filename, append);
        for (T t : lise) {
            filewriter.write(t.toString() + "\n");
        }
        filewriter.close();
    }

}
