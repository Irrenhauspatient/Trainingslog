
public class Lib_Message {

    /**
     * Fehlermeldung für Lib_Digits checkSpan()
     * 
     * @param <T>       beliebige Zahl
     * @param <K>       beliebiger String
     * 
     * @param min       Minimalwert
     * @param max       Maximalwert
     * @param fieldname Feldname des Attributes
     * @return String Fehlermeldung
     */
    public static <T, K> String errorWrongValueSpan(T min, T max, T value, K fieldname) {
        return String.format("Der eingegebene Wert bei %s ist: %s er unterschreitet %s oder überschreitet %s",
                fieldname.toString(), value.toString(), min.toString(), max.toString());
    }

    /**
     * Fehlermeldung für Lib_Digits checkMin()
     * 
     * @param <T>       beliebige Zahl
     * @param <K>       beliebiger String
     * 
     * @param min       Minimalwert
     * @param fieldname Feldname des Attributes
     * @return String Fehlermeldung
     */
    public static <T, K> String errorWrongValueMin(T min, T value, K fieldname) {
        return String.format("Der eingegebene Wert bei %s ist: %s er unterschreitet %s", fieldname.toString(),
                value.toString(), min.toString());
    }

    /**
     * Fehlermeldung für Lib_Digits checkMax()
     * 
     * @param <T>       beliebige Zahl
     * @param <K>       beliebiger String
     * 
     * @param max       Maximalwert
     * @param fieldname Feldname des Attributes
     * @return String Fehlermeldung
     */
    public static <T, K> String errorWrongValueMax(T max, T value, K fieldname) {
        return String.format("Der eingegebene Wert bei %s ist: %s überschreitet %s", fieldname.toString(),
                value.toString(), max.toString());
    }

    /**
     * Fehlermeldung für Lib_String checkIfNullOrEmpty()
     * 
     * @param <K>       beliebiger String
     * 
     * @param fieldname Feldname des Attributes
     * @return String Fehlermeldung
     */
    public static <K> String errorEmptyString(K fieldname) {
        return String.format("Das Feld %s darf nicht leer sein", fieldname.toString());
    }

    /**
     * Fehlermeldung für Lib_Arrays checkNullPointer()
     * 
     * @param <T>   beliebige Zahl
     * 
     * @param index Index der überprüft wurde
     * @return String Fehlermeldung
     */
    public static <T> String errorNullPointerArray(T index) {
        return String.format("Der angegeben Index %s ist nicht belegt", index.toString());
    }

}
