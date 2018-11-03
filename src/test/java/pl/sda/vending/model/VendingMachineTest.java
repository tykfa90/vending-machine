package pl.sda.vending.model;

import org.junit.Test;
import pl.sda.vending.util.Configuration;

import static org.junit.Assert.*;
import static org.mockito.Matchers.anyLong;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;

public class VendingMachineTest {

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionWhenZeroRowsConfigured() {
       // Given
        Configuration config = mock(Configuration.class);
        doReturn(0L).when(config).getLongProperty(eq("machine.size.rows"), anyLong());
        doReturn(4L).when(config).getLongProperty(eq("machine.size.cols"), anyLong());
       // When
       new VendingMachine(config);
       // Then
       fail("Exception should be raised");
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionWhenZeroColumnsConfigured() {
       // Given
        Configuration config = mock(Configuration.class);
        doReturn(6L).when(config).getLongProperty(eq("machine.size.rows"), anyLong());
        doReturn(0L).when(config).getLongProperty(eq("machine.size.cols"), anyLong());
       // When
       new VendingMachine(config);
       // Then
       fail("Exception should be raised");
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionWhenTooManyRowsConfigured() {
       // Given
        Configuration config = mock(Configuration.class);
        doReturn(27L).when(config).getLongProperty(eq("machine.size.rows"), anyLong());
        doReturn(5L).when(config).getLongProperty(eq("machine.size.cols"), anyLong());
       // When
       new VendingMachine(config);
       // Then
       fail("Exception should be raised");
    }
    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionWhenTooManyColumnsConfigured() {
       // Given
        Configuration config = mock(Configuration.class);
        doReturn(5L).when(config).getLongProperty(eq("machine.size.rows"), anyLong());
        doReturn(10L).when(config).getLongProperty(eq("machine.size.cols"), anyLong());
       // When
       new VendingMachine(config);
       // Then
       fail("Exception should be raised");
    }

    @Test
    public void shouldCreateMachineWhenProperlyConfigured() {
        // Given
        Configuration config = mock(Configuration.class);
        doReturn(6L).when(config).getLongProperty(eq("machine.size.rows"), anyLong());
        doReturn(4L).when(config).getLongProperty(eq("machine.size.cols"), anyLong());
        // When
        new VendingMachine(config);
        // Then
        System.out.println("Everything works");
    }
}