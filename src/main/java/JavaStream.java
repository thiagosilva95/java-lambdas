import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class JavaStream {

    public static void main(String[] args) {

        List<Integer> list = Arrays.asList(1, 2, 3, 5, 4 , 6, 9 , 5 , 4,8 , 4,9 ,9, 5, 9,4);
        Map<Integer, List<Integer>> collect = list.stream()
                .skip(2) // ignora os 2 primeiros elementos - operação intermediária
                .limit(7) // considera apenas os 5 primeiros elementos
                .distinct() // não permite que o stream processe elementos repetidos
                //.filter(e -> e % 2 == 0) // o ideal é fazer os filtros antes
                .map(e -> e * 2) // lista original não é modificada
                //.forEach(System.out::println);
                //.count();
                //.min(Comparator.naturalOrder())
                //.max(Comparator.naturalOrder());
                //.collect(Collectors.toList());
                //.collect(Collectors.groupingBy(e -> e % 3 == 0));
                .collect(Collectors.groupingBy(e -> e % 3));

        System.out.println(collect);

        List<Integer> list2 = Arrays.asList(1, 2, 3, 5, 4 , 6, 9 , 5 , 4,8 , 4,9 ,9, 5, 9,4);
        String collect1 = list2.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(";"));
                //.collect(Collectors.joining());

        System.out.println(collect1);

        // stream = loops implícitos
        // for - while - do..while = loops explícitos
    }
}
