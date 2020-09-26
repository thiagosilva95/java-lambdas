import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class JavaStreamReduce {

    public static void main(String[] args) {
        String s = "Imagine aqui um texto";
        String[] split = s.split(" ");
        List<String> listSplit = Arrays.asList(split);
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6);

        Optional<Integer> reduceSoma = list.stream()
                .reduce((n1, n2) -> n1 + n2);
        System.out.println(reduceSoma);

        Optional<Integer> reduceMultiplicacao = list.stream()
                .reduce((n1, n2) -> n1 * n2);
        System.out.println(reduceMultiplicacao);

        Optional<String> concatenaceo = listSplit.stream()
                .reduce(((s1, s2) -> s1.concat(s2)));
        System.out.println(concatenaceo);

        Optional<Integer> reduceSubtracao = list.stream()
                .reduce((n1, n2) -> n1 - n2);
        System.out.println(reduceSubtracao);

    }
}
