import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class Asker {
    private final Scanner scanner;
    private final PrintStream out;

    public Asker(InputStream in, PrintStream out) {
        scanner = new Scanner(in);
        this.out = out;
    }

    public String askDate(String message) {
        out.println(message);
        return scanner.nextLine();
    }

    public int askDuration(String message) {
        out.println(message);
        return Integer.parseInt(scanner.nextLine());
    }
}
