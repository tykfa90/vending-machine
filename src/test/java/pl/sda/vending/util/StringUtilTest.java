package pl.sda.vending.util;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

@RunWith(JUnitParamsRunner.class)
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

    @Test
    @Parameters
    public void shouldProperlyFormatMoney(Long amountToFormat, String expectedResult) {
        // Given in parameters
        // When
        String formattedMoney = StringUtil.formatMoney(amountToFormat);
        // Then
        assertEquals(expectedResult, formattedMoney);
    }

    public Object[] parametersForShouldProperlyFormat() {
        return new Object[]{
                new Object[]{123L, "1,23"},
                new Object[]{0, "0,00"},
                new Object[]{5, "0,05"},
                new Object[]{12, "0,12"},
                new Object[]{1234L, "12,34"},
                new Object[]{12345L, "123,45"},
                new Object[]{123456L, "1 234,56"},
                new Object[]{1234567L, "12 345,67"},
                new Object[]{12345678L, "123 456,78"},
                new Object[]{123456789L, "1 234 567,89"},
                new Object[]{1234567890123456789L, "12 345 678 901 234 567,89"}
        };
    }
}