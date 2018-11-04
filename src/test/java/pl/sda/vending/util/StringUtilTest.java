package pl.sda.vending.util;

import org.junit.Test;

import static org.junit.Assert.*;

public class StringUtilTest {

    @Test
    public void shouldReturnUnmodifiedTextIfLengthMatches() {
       // Given
       String textToAdjust = "Ala ma kota";
       Integer expectedLength = 11;
       // When
        String adjustedText = StringUtil.adjustText(textToAdjust, expectedLength);
        // Then
       assertEquals("Ala ma kota", adjustedText);
    }

    @Test
    public void shouldTrimTooLongText() {
       // Given
       String textToAdjust = "Ala ma kota";
       Integer expectedLength = 6;
       // When
        String adjustedText = StringUtil.adjustText(textToAdjust, expectedLength);
        // Then
       assertEquals("Ala ma", adjustedText);
    }
    // "abcd" -> 8 -> "   abcd   "
    // "abc -> 8 -> "    abc   "
    @Test
    public void shouldCenterEvenLengthText() {
       // Given
        String textToAdjust = "abcd";
        Integer expectedLength = 8;
       // When
        String adjustedText = StringUtil.adjustText(textToAdjust, expectedLength);
       // Then
       assertEquals("  abcd  ", adjustedText);
    }

    @Test
    public void shouldCenterOddLengthText() {
       // Given
        String textToAdjust = "abc";
        Integer expectedLength = 8;
       // When
        String adjustedText = StringUtil.adjustText(textToAdjust, expectedLength);
       // Then
        assertEquals("   abc  ", adjustedText);
    }
}