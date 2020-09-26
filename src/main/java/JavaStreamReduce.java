import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.DoubleStream;

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

        Integer reduceSoma2 = list.stream()
                .reduce(0, (n1, n2) -> n1 + n2);
        System.out.println(reduceSoma2);

        Integer reduceMultiplicacao2 = list.stream()
                .reduce(1, (n1, n2) -> n1 * n2);
        System.out.println(reduceMultiplicacao2);

        String concatenaceo2 = listSplit.stream()
                .reduce("", (s1, s2) -> s1.concat(s2));
        System.out.println(concatenaceo2);

        // reduce do menor valor
        double menorValor = DoubleStream.of(1.5, 2.9, 6.7)
                .reduce(Double.POSITIVE_INFINITY, (d1, d2) -> Math.min(d1, d2));
        System.out.println(menorValor);

        // map + combiner
        String soma = list.stream()
                .reduce(
                    "",
                    (n1, n2) -> n1.toString().concat(n2.toString()),
                    (n1, n2) -> n1.concat(n2)
                );
        System.out.println("Função de acumulação: " + soma);
    }
}
