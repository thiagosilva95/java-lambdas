import java.util.*;
import java.util.stream.Collectors;

public class JavaStreamCollect {

    public static void main(String[] args) {

        List<Integer> list = Arrays.asList(1, 2, 3, 4 ,5, 6);

        // fornecedor - acumulação - combinação
        List<Integer> collect = list.stream()
                .collect(
                        () -> new ArrayList<>(), // função lambda que vai fornecer o objeto que vai se acumular para fornecer resultado
                        (l, e) -> l.add(e), //
                        (l1, l2) -> l1.addAll(l2)
                );

        System.out.println(collect);

        // toList
        List<Integer> collect1 = list.stream()
                .filter(integer -> integer % 2 == 0)
                .collect(Collectors.toList());

        System.out.println(collect1);

        String join = list.stream()
                .map(Object::toString)
                .collect(Collectors.joining());
        System.out.println(join);

        // averaging
        Double media = list.stream()
                .collect(Collectors.averagingInt(n -> n.intValue()));
        System.out.println(media);

        Integer soma = list.stream()
                .collect(Collectors.summingInt(n -> n.intValue()));
        System.out.println(soma);

        IntSummaryStatistics stats = list.stream()
                .collect(Collectors.summarizingInt(n -> n.intValue()));
        System.out.println(stats);

        Long count = list.stream()
                .filter(integer -> integer % 2 == 0)
                .collect(Collectors.counting());

        System.out.println(count);

        list.stream()
                .filter(integer -> integer % 2 == 0)
                .collect(Collectors.minBy(Comparator.naturalOrder()))
                .ifPresent(System.out::println);

        list.stream()
                .filter(integer -> integer % 2 == 0)
                .collect(Collectors.maxBy(Comparator.naturalOrder()))
                .ifPresent(System.out::println);

        Map<Integer, List<Integer>> groupingBy = list.stream()
                .filter(integer -> integer % 2 == 0)
                .collect(Collectors.groupingBy(n -> n % 3));
        System.out.println(groupingBy);

        Map<Boolean, List<Integer>> partitionBy = list.stream()
                .filter(integer -> integer % 2 == 0)
                .collect(Collectors.partitioningBy(n -> n % 3 == 0));
        System.out.println(partitionBy);

        // toMap
        Map<Integer, Integer> map = list.stream()
                .filter(integer -> integer % 2 == 0)
                .collect(Collectors.toMap(
                        n -> n,// definir chave
                        n -> n * 2// definir valor
                ));
        System.out.println(map);
    }
}
