import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Lib_File {

    public static ArrayList<Object> deserializeObjects(File file) throws IOException, ClassNotFoundException {

        ArrayList<Object> objects = new ArrayList<Object>();

        FileInputStream fis = new FileInputStream(file);
        ObjectInputStream ois = new ObjectInputStream(fis);

        objects.add(ois.readObject());

        ois.close();
        fis.close();

        return objects;

    }

    public static File serializeToObject(ArrayList<Object> objects) throws IOException {

        File file = File.createTempFile("temp", ".tmp");

        FileOutputStream fos = new FileOutputStream(file);
        ObjectOutputStream oos = new ObjectOutputStream(fos);

        oos.writeObject(objects);

        oos.close();
        fos.close();

        return file;
    }

}
