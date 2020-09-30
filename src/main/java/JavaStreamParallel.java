import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class JavaStreamParallel {

    public static void main(String[] args) throws IOException {

        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);

        // duas formas de criar
        list.parallelStream();
        IntStream.rangeClosed(0, 5).parallel();

        /**
         * quando usa? Tem custo a mais.
         * Necessidade de ganhar performance em um algorítimo específico.
         * Lista com milhares de items
         */

        list.parallelStream()
                .forEach(System.out::println);

        System.out.println("################ FOREACH ORDERED");

        list.parallelStream()       // preserva a ordem da lista
                .forEachOrdered(System.out::println);

        System.out.println("################ FIND ANY");
        list.parallelStream()
                .findAny()  // encontra o primeiro número pronto. Threads paralelas
                .ifPresent(System.out::println);
        System.out.println("-----");
        list.stream()
                .findAny() // encontra o primeiro número pronto. 1 é o primeiro da lista
                .ifPresent(System.out::println);

        System.out.println("################ UNORDERED");
        /**
         * unordered:
         *  skip, limit
         *  distinct
         */
        list.parallelStream() // as threads precisam se comunicar para realizar o skip e limit entre elas
                .skip(1)
                .limit(2)
                .forEach(System.out::println);
        System.out.println("-----");
        list.parallelStream() // realiza o skip e o limit pode se aplicar a qualquer elemento
                .unordered()
                .skip(1)
                .limit(2)
                .forEach(System.out::println);

        System.out.println("################ REDUCE");
        /**
         * Operações associativas 1 + 2 + 3 + 4. Operações agrupadas em qualquer posição é igual ao mesmo resultado.
         *
         */
        list.stream()
                .reduce((n1, n2) -> n1 + n2)
                .ifPresent(System.out::println);
        System.out.println("-----");
        list.stream()
                .reduce((n1, n2) -> n1 - n2)
                .ifPresent(System.out::println);

        System.out.println("################ COLLECT");
        Map<Integer, Boolean> collect =
                list.parallelStream()
                .collect(
                        Collectors
                        .toConcurrentMap(n -> n, n -> n % 2 == 0) // mais performático que o toMap (thread safe, único mapa para todas as threads)
                );
        System.out.println(collect);

    }
}
