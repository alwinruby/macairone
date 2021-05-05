
class FirstCloseable implements AutoCloseable {
    public void close() {  // Line 1
        throw new IllegalStateException("First could not close");
    }

    public void run() {
        System.out.println("Running First");
    }
}

class SecondCloseable implements AutoCloseable {
    public void close() throws Exception {  // Line 2
        throw new IllegalStateException("Second could not close");
    }

    public void run() {
        throw new IllegalStateException("Second could not run");
    }
}

public class Test {

    public static void main(String[] args) {

        FirstCloseable first = new FirstCloseable();
        try (first; SecondCloseable second = new SecondCloseable()) {  // Line 3
            first.run();
            second.run();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}