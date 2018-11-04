package pl.sda.vending.util;

public class StringUtil {
    public static String adjustText(String text, Integer expectedLength) {
        String expandedText = text;
        while (expandedText.length() < expectedLength) {
            expandedText = " " + expandedText + " ";
        }
        return expandedText.substring(0, expectedLength);
    }
}
