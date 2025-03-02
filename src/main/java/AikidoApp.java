public class AikidoApp {
    public static void main(String[] args) {
        User user = new User();
//        AppInterface appInterface = new AppInterface(user);
        AppInterface appInterface = new AppInterface();
        appInterface.start();
    }
}
