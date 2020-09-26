import java.util.stream.IntStream;

public class JavaLambda {

    public static void main(String[] args) {

        // API DE STREAM

        // stream -> fluxo de dados

        Runnable runnable = () -> System.out.println("string aqui");

        IntStream.range(0, 5)
                .filter(n -> n % 2 == 0)
                .forEach(System.out::println);

        IntStream.range(0, 5)
                .filter((int n) -> n % 2 == 0)
                .reduce((n1, n2) -> n1 + n2)
                .ifPresent(System.out::println);

        // chaves
        IntStream.range(0, 5)
                .filter((int n) -> {
                    System.out.println("String aqui");
                    return n % 2 == 0;
                })
                .forEach(System.out::println);

    }
}
