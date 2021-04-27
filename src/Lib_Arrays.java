import java.util.ArrayList;

public class Lib_Arrays {

    /**
     * Überprüft ob der Index in ArrayListe null ist
     * 
     * @param arraylist zu prüfende ArrayListe
     * @param index     eintrag in der ArrayListe
     */
    public static <T> void checkArrayListNullPointer(ArrayList<T> arraylist, int index) {
        if (arraylist.get(index) != null) {
            return;
        }
        throw new NullPointerException(Lib_Message.errorNullPointerArray(index));
    }

    /**
     * Zählt die einträge in der ArrayList und gibt die Anzahl zurück
     * 
     * @param arraylist zu prüfende ArrayListe
     * @return int anzahl der Einträge in der ArrayListe
     */
    public static <T> int countArrayListIndex(ArrayList<T> arraylist) {

        int counter = 0;

        for (T entry : arraylist) {

            counter++;
        }

        return counter;
    }

    /**
     * Zählt die einträge in dem Array und gibt die Anzahl zurück
     * 
     * @param array zu prüfendes Array
     * @return int anzahl der Einträge im Array
     */
    public static int countArrayIndex(Object[] array) {

        int counter = 0;

        for (Object object : array) {

            counter++;
        }
        return counter;
    }

    /**
     * Überprüft ob der Index im Array null ist
     * 
     * @param array zu prüfendes Array
     * @param index eintrag im Array
     */
    public static void checkArrayNullPointer(Object[] array, int index) {

        if (array[index] != null) {
            return;
        }
        throw new NullPointerException(Lib_Message.errorNullPointerArray(index));

    }
}
