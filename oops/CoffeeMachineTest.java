import java.io.*;

public class CoffeeMachineTest {

    private static final InputStream INPUT_STREAM = System.in;
    private static final OutputStream OUTPUT_STREAM = System.out;

    public static void main(String[] args) {
        shouldDispenseWithCorrectInput();
        shouldNotDispenseWhenQuit();
    }

    private static void shouldNotDispenseWhenQuit() {
        InputStream inputStream = new ByteArrayInputStream("1\nq".getBytes());
        OutputStream outputStream = new ByteArrayOutputStream();
        setupStreams(inputStream, outputStream);
        CoffeeMachine coffeeMachine = new CoffeeMachine();
        coffeeMachine.initialize();
        String result = outputStream.toString();
        assertFalse(result.contains("Dispensing..."));
        assertFalse(result.contains("Please pay"));
        assertTrue(result.contains("Quitting..."));
        resetStreams();
        System.out.println("Test passed...");
    }

    private static void resetStreams() {
        System.setIn(INPUT_STREAM);
        System.setOut(new PrintStream(OUTPUT_STREAM));
    }

    private static void setupStreams(InputStream inputStream, OutputStream outputStream) {
        System.setIn(inputStream);
        System.setOut(new PrintStream(outputStream));
    }

    private static void assertTrue(boolean result) {
        if (!result) {
            throw new RuntimeException("Expected : " + !result + " ; Actual : " + result);
        }
    }

    private static void assertFalse(boolean result) {
        assertTrue(!result);
    }

    private static void shouldDispenseWithCorrectInput() {
        InputStream inputStream = new ByteArrayInputStream("1\n1 1\n2 2\n3 3\nd".getBytes());
        OutputStream outputStream = new ByteArrayOutputStream();
        setupStreams(inputStream, outputStream);
        CoffeeMachine coffeeMachine = new CoffeeMachine();
        coffeeMachine.initialize();
        /*System.setOut(new PrintStream(OUTPUT_STREAM));
        System.out.println(outputStream.toString());*/
        String expected = "1. Americano (Press 1 for Americano)\r\n" +
                "2. Black Coffee (Press 2 for Black Coffee)\r\n" +
                "3. Cafe Mocha (Press 3 for Cafe Mocha)\r\n" +
                "You selected Americano\r\n" +
                "Please select ingredients.\r\n" +
                "Press Q/q to quit, D/d to dispense, R/r to restock\r\n" +
                "1. Coffee. Cost per unit: 0.75 (Press 1 for Coffee and space then the quantity you prefer)\r\n" +
                "2. Cream. Cost per unit: 0.25 (Press 2 for Cream and space then the quantity you prefer)\r\n" +
                "3. Sugar. Cost per unit: 0.25 (Press 3 for Sugar and space then the quantity you prefer)\r\n" +
                "4. Water. Cost per unit: 0.0 (Press 4 for Water and space then the quantity you prefer)\r\n" +
                "Dispensing...\r\n" +
                "Please pay 2.0$\r\n";
        assertTestResult(expected, outputStream.toString());
        resetStreams();
        System.out.println("Test passed...");
    }

    private static void assertTestResult(Object expected, Object actual) {
        if (expected == null && actual == null) {
            return;
        }
        if (expected == null || actual == null) {
            throw new RuntimeException("Expected : " + expected + " ; Actual : " + actual);
        }
        if (expected.equals(actual)) {
            return;
        }
        throw new RuntimeException("Expected : " + expected + " ; Actual : " + actual);
    }


}