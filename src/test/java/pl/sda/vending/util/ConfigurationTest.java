package pl.sda.vending.util;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ConfigurationTest {

    private Configuration testedConfig;

    @Before
    public void init() {
        testedConfig = new Configuration();
    }

    @Test
    public void shouldReturnDefaultStringValueWhenPropertyIsUnknown() {
       // Given
       String unknownPropertyName = "weug;fkuesb;eo;ufhehlf";
       String expectedDefault = "javaIsAwesome";
       // When
        String propertyValue = testedConfig.getStringProperty(unknownPropertyName, expectedDefault);
        // Then
       assertEquals(expectedDefault, propertyValue);
    }

    @Test
    public void shouldReturnDefaultLongValueWhenPropertyIsUnknown() {
       // Given
       String unknownPropertyValue = "xqwzs";
       Long expectedDefault = 16L;
       // When
       Long propertyValue = testedConfig.getLongProperty(unknownPropertyValue, expectedDefault);
       // Then
       assertEquals(expectedDefault, propertyValue);
    }

    @Test
    public void shouldReturnSetStringValueWhenPropertyIsProvided() {
       // Given
        String expectedDefault = "qwertyelse";
        String setProperty = "qwerty";
        // When
       String propertyValue = testedConfig.getStringProperty("test.property.string", expectedDefault);
       // Then
       assertEquals(setProperty, propertyValue);
    }

    @Test
    public void shouldReturnSetLongValueWhenPropertyIsProvided() {
        // Given
        Long expectedDefault = 16L;
        String propertyName = "test.property.long";
        // When
        Long propertyValue = testedConfig.getLongProperty("test.property.long", expectedDefault);
        // Then
        assertEquals((Long)123L, propertyValue);
    }
}