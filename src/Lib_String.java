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

        String[] replacement = string.split("\\s");
        StringBuilder sb = new StringBuilder();

        sb.append(replacement[0].toLowerCase());

        for (int i = 1; i < replacement.length; i++) {

            sb.append(replacement[i].substring(0, 1).toUpperCase());
            sb.append(replacement[i].substring(1, replacement[i].length()).toLowerCase());

        }
        return sb.toString();
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
