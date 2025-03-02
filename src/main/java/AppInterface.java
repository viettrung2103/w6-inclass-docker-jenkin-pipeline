import java.util.Scanner;

public class AppInterface {
    private User user;
    private Scanner scanner;

//    public AppInterface(User user) {
//    public AppInterface(user) {
    public AppInterface() {
        scanner = new Scanner(System.in);
        this.user = new User();
    }

    public void start() {
        while (true) {
            displayMainMenu();
            String option = scanner.nextLine();
            switch (option) {
                case "1": {
                    displayFirstOption();
                    break;
                }
                case "2": {
                    displaySecondOption();
                    break;
                }
                case "3": {
                    displayThirdOption();
                    break;
                }
                case "4": {
                    System.out.println("Thank you for using our application");
                    return;
                }
                default:
                    System.out.println("Please enter from 1 to 4");
            }


        }
    }

    public void displayMainMenu() {
        System.out.println("===== Aikido Practice Tracker =====");
        System.out.println("1. Add Practice Session");
        System.out.println("2. View Total Practice Time");
        System.out.println("3. Check Graduation Eligility");
        System.out.println("4. Exit");
        System.out.println("Choose an option");
    }

    public void displayFirstOption() {
        System.out.println("Type date (YYYY-MM-DD):");
        String dateString = scanner.nextLine();
        System.out.println("Type duration:");
        int duration = Integer.parseInt(scanner.nextLine());
        user.addSession(dateString, duration);


    }

    public void displaySecondOption() {
        int duration = user.findTotalTime();
        System.out.println("Total Practice Time: " + duration + " " + (duration > 1 ? "minutes" : "minute"));
    }

    public void displayThirdOption() {
        System.out.println("Are you ready for the Kya graduation: " + user.checkEligibility());
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

}

