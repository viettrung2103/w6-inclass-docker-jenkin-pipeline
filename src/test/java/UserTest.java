import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    static AppInterface appInterface;
    static User user;

    @BeforeEach
    void setup() {

//        appInterface = new AppInterface(user);
//        User user = new User();
//        appInterface = new AppInterface(user);
        appInterface = new AppInterface();
        user = appInterface.getUser();
    }

    @Test
    @DisplayName("test add session")
    void addSession() {
        user.addSession("2024-02-01", 90);
        assertEquals(90, user.findTotalTime());
    }

    @Test
    @DisplayName("Test find total user time")
    void findTotalTime() {
        user.addSession("2024-02-01", 90);

    }

    @Test
    @DisplayName("test user eligibility")
    void checkEligibility() {
        user.addSession("2024-02-01", 90);
        assertFalse(user.checkEligibility());

        user.addSession("2024-08-01", 90);
        assertTrue(user.checkEligibility());
    }

    @Test
    @DisplayName("test user eligibility after adding 100 session")
    void checkEligilityAfter100Sessions() {
        for (int i = 1; i <= 100; i++) {
//            user.addSession();
//            String day = String.format("%02d", i % 30 + 1); // Ensure day is always valid and formatted correctly
            user.addSession("2024-02-02" , 90);
        }
        assertTrue(user.checkEligibility());
    }

    @Test
    @DisplayName("test convert date String to total minutes")
    void getToTalMinutes() {
        assertEquals(2024 * 365 * 24 * 60 + 2 * 30 * 24 * 60 + 1 * 24 * 60, user.getToTalMinutes("2024-02-01"));
        assertEquals(0, user.getToTalMinutes("2024-13-01"));
        assertEquals(0, user.getToTalMinutes("2024-02-31"));
    }
}