import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

    public static String menueToMethod(String string) {

        String patternstring = "regex";
        Pattern pattern = Pattern.compile(patternstring);
        Matcher matcher = pattern.matcher(string);
        String stringbuffer = string.replace(matcher.toString(), matcher.toString().toLowerCase());

        String patternstring1 = "regex1";
        Pattern pattern1 = Pattern.compile(patternstring1);
        Matcher matcher1 = pattern1.matcher(string);
        String stringformethod = stringbuffer.replace(matcher1.toString(), matcher1.toString().toUpperCase());

        return stringformethod;

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
