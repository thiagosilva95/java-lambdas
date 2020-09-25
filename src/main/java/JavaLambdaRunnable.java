public class JavaLambdaRunnable {

    public static void main(String[] args) {

        // JAVA 7
        new Thread(new Runnable() {
            public void run() {
                System.out.println("Olá, mundo!");
            }
        }).run();

        // JAVA 8
        new Thread(() -> System.out.println("Olá, mundo!")).run();
    }
}
