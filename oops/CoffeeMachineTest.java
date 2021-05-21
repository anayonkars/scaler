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
        String result = outputStream.toString();
        assertTrue(result.contains("Dispensing..."));
        assertTrue(result.contains("Please pay 2.0$"));
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
