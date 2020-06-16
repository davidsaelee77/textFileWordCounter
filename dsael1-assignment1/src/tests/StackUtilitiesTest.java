/*
 * TCSS 342 - WINTER
 */

package tests;

import static org.junit.Assert.*;

import org.junit.Test;
import program.StackUtilities;

/**
 * StackUtilities class JUnit testing.
 * 
 * @author David Saelee
 * @version 01/16/2019
 *
 */
public final class StackUtilitiesTest {

    /**
     * Test method for {@link program.StackUtilities#StackUtilities()}.
     */
    @Test
    public void testDecimalToBinary() {

        assertEquals("Binary Number: 10", StackUtilities.decimalToBinary(2));
        assertEquals("Binary Number: 110111", StackUtilities.decimalToBinary(55));
        assertEquals("Binary Number: 0", StackUtilities.decimalToBinary(0));

    }

}
