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

    public static ArrayList<Object> deserializeObjects(String filename) throws IOException, ClassNotFoundException {

        ArrayList<Object> objects = new ArrayList<Object>();

        File file = new File(filename);

        FileInputStream fis = new FileInputStream(file);
        ObjectInputStream ois = new ObjectInputStream(fis);

        objects.add(ois.readObject());

        ois.close();
        fis.close();

        return objects;
    }

    public static File serializeArrayList(ArrayList<Object> objects, String filename) throws IOException {

        File file = new File(filename);

        FileOutputStream fos = new FileOutputStream(file);
        ObjectOutputStream oos = new ObjectOutputStream(fos);

        oos.writeObject(objects);

        oos.close();
        fos.close();

        return file;
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
