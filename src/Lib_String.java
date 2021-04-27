
public class Lib_String {

    /**
     * Überprüft ob der übergebene String leer oder NULL ist
     * 
     * @param string Der zu prüfende String
     */

    public static void checkIfNullOrEmpty(String string, String fieldname) {
        if (!string.isEmpty() && !string.isBlank()) {
            return;
        }
        throw new IllegalArgumentException(Lib_Message.errorEmptyString(fieldname));
    }

    /**
     * Methode zum entfernen nicht benötigter Leerstellen
     *
     * @param replaceALL (ersetze alle Variable 1 durch Variable 2, (Variable1 ,
     *                   Variable 2))
     * @param \s+        (alle zusammenhängende Leerstellen)
     */
    public static String AllWhitespaceToOne(String string) {
        string = string.stripTrailing();
        string = string.stripLeading();
        string = string.replaceAll("\\s+", " ");
        return string;
    }

    /**
     * Methode zum entfernen aller Leerstellen
     *
     * @param replaceALL (ersetze alle Variable 1 durch Variable 2, (Variable1 ,
     *                   Variable 2))
     * @param \s+        (alle zusammenhängende Leerstellen)
     */
    public static String RemoveAllWhitespaces(String string) {
        string = string.replaceAll("\\s+", "");
        return string;
    }

    /**
     * Methode zum entfernen nicht benötigter Leerstellen sowie Zeichen die bei der
     * ausgabe eine ArrayList entstehen
     *
     * @param replaceALL (ersetze alle Variable 1 durch Variable 2, (Variable1 ,
     *                   Variable 2))
     * @param \s+        (alle zusammenhängende Leerstellen)
     */
    public static String trimArrayList(String string) {
        string = string.replaceAll(", ", "");
        string = string.replace("[", "");
        string = string.replace("]", "");
        return string;
    }

}
