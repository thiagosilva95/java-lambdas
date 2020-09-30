import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

public class JavaBuiltinFunctionalInterfaces {

    public static void main(String[] args) {
        Stream.generate(() -> new Random().nextInt());// Supplier representa uma funcao que vai entregar algo

        List<Integer> list = Arrays.asList(1, 2, 3, 5, 4 , 6, 9 , 5 , 4,8 , 4,9 ,9, 5, 9,4);

        // Consumer = oposto do supplier (foreach)
        // BiConsumer = recebe dois parametros

        // Predicate = funcao recebe um valor e retorna um boolean (filter)
        // BiPredicate = recebe dois parametros
        list.stream()
                .filter(x -> x % 2 == 0)
                .forEach(System.out::println);

        // Function = recebe um valor e retorna um valor (map)
        // BiFunction = função que recebe dois valores e retorna um valor
        list.stream()
                .filter(x -> x % 2 == 0)
                .map(n -> n.doubleValue())
                .forEach(System.out::println);

        // UnaryOperator extende Function tipo de entrada e tipo de saída são o mesmo (reduce)
        // BinaryOperator
        list.stream()
                .filter(x -> x % 2 == 0)
                .map(n -> n.doubleValue())
                .reduce((e1, e2) -> e1 + e2)
                .ifPresent(System.out::println);

    }
}
