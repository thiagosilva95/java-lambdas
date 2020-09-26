import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

public class JavaMethodReference {

    public static void main(String[] args) {

        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        list.stream()
                .forEach(System.out::println); // method reference

        list.stream()
                .forEach(n -> System.out.println(n)); // sem method reference

        list.stream()
                .map(JavaMethodReference::multipliquePorDois) // métodos estáticos
                .forEach(n -> System.out.println(n));

        // construtores
        list.stream()
                .map(n -> new BigDecimal(n))
                .forEach(n -> System.out.println(n));

        list.stream()
                .map(BigDecimal::new)
                .forEach(n -> System.out.println(n));

        // várias instancias
        list.stream()
                .map(n -> n.doubleValue())
                .forEach(n -> System.out.println(n));

        list.stream()
                .map(Integer::doubleValue)
                .forEach(n -> System.out.println(n));

        // única instância
       BigDecimal dois = new BigDecimal(2);
        list.stream()
                .map(BigDecimal::new)
                .map(b -> dois.multiply(b))
                .forEach(n -> System.out.println(n));

        list.stream()
                .map(BigDecimal::new)
                .map(dois::multiply)
                .forEach(n -> System.out.println(n));

    }

    private static  Integer multipliquePorDois(Integer i) {
        return i * 2;
    }
}
