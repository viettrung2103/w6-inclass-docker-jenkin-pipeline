import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import static org.mockito.Mockito.*;

import org.mockito.junit.jupiter.MockitoExtension;


@ExtendWith(MockitoExtension.class)
class AppInterfaceTest {

    @InjectMocks
    private static AppInterface appInterface;

    @Mock
    private User user;

    @Mock
    private Scanner scanner;

    private final ByteArrayOutputStream outputStringStream = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private final InputStream originalIn = System.in;

    @BeforeEach
    void setup() {
//        appInterface.setUser(user);
//        appInterface = new AppInterface(user);
        System.setOut(new PrintStream(outputStringStream));
//        appInterface.setUser(user);
//        user = appInterface.getUser();
    }

    @AfterEach
    void resetSetUp() {
        System.setOut(originalOut);
        System.setIn(originalIn);
    }

    @Test
    void start() {
        // Test implementation
    }

    @Test
    void displayMainMenu() {
        String expectedPartString = "Aikido Practice Tracker";
        appInterface.displayMainMenu();
        assertTrue(outputStringStream.toString().contains(expectedPartString), "the output print should contain " + expectedPartString);
    }

    @Test
//    @Disabled
    void displayFirstOption() {
        String dateString = "2024-02-21";
        String durationString = "90";
        when(scanner.nextLine()).thenReturn(dateString, durationString);

        when(user.findTotalTime()).thenReturn(90); // Mock the return value of findTotalTime

        appInterface.displayFirstOption();
        appInterface.setUser(user);
//        User user = appInterface.getUser();

        verify(user).addSession(dateString, 90);


        String expectDateStr = "Type date";
        String expectDuration = "Type duration";

        assertTrue(outputStringStream.toString().contains(expectDateStr), "the output print should contain " + expectDateStr);
        assertTrue(outputStringStream.toString().contains(expectDuration), "the output print should contain " + expectDuration);

        assertEquals(90, appInterface.getUser().findTotalTime(), "The total practice time should be 90 minutes");
    }

    @Test
    void displaySecondOption() {
        String expectedPartString = "Total Practice Time:";
        appInterface.displaySecondOption();
        assertTrue(outputStringStream.toString().contains(expectedPartString), "the output print should contain " + expectedPartString);
    }


    @Test
    void displayThirdOption() {
        String expectedPartString = "Are you ready for the Kya graduation";
        appInterface.displayThirdOption();
        assertTrue(outputStringStream.toString().contains(expectedPartString), "the output print should contain " + expectedPartString);
    }

}