package com.green;

import com.promotion.MainProgram;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

public class UseCaseTests {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private final PrintStream originalErr = System.err;

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }

    @After
    public void restoreStreams() {
        System.setOut(originalOut);
        System.setErr(originalErr);
    }

    @Test
    public void testScenarioA(){
        String[] args = new String[]{"1", "1", "1", "0"};
        MainProgram.main(args);
        assertEquals("Final cart amount is: 100", outContent.toString());
    }

    @Test
    public void testScenarioB(){
        String[] args = new String[]{"5", "5", "1", "0"};
        MainProgram.main(args);
        assertEquals("Final cart amount is: 370", outContent.toString());
    }

    @Test
    public void testScenarioC(){
        String[] args = new String[]{"3", "5", "1", "1"};
        MainProgram.main(args);
        assertEquals("Final cart amount is: 280", outContent.toString());
    }

    @Test
    public void testScenarioD(){
        String[] args = new String[]{"3", "5", "2", "1"};
        MainProgram.main(args);
        assertEquals("Final cart amount is: 300", outContent.toString());
    }

    @Test
    public void testScenarioE(){
        String[] args = new String[]{"3", "5", "2", "3"};
        MainProgram.main(args);
        assertEquals("Final cart amount is: 325", outContent.toString());
    }

    @Rule
    public final ExpectedException exception = ExpectedException.none();

    @Test
    public void negativeCase(){
        String[] args = new String[]{};
        exception.expect(ArrayIndexOutOfBoundsException.class);
        MainProgram.main(args);
    }
}
