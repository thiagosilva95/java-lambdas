import java.util.Optional;
import java.util.stream.Stream;

public class JavaOptional {

    public static void main(String[] args) {

        //String s = "Nome";
        String s = "1";
        Optional<Integer> numero = converterEmNumero(s);
        System.out.println(numero.isPresent());
        //System.out.println(numero.get());

        numero.ifPresent(System.out::println);
        System.out.println(numero.orElse(2));
        System.out.println(numero.orElseGet(() -> 1));
       // numero.orElseThrow(() -> new NullPointerException());

        Optional<Integer> first = Stream.of(1, 2, 3)
                .findFirst();
        System.out.println(first);

        Stream.of(1, 2, 3)
                .findFirst()
                .ifPresent(System.out::println);

    }

    public static Optional<Integer> converterEmNumero(String numeroStr) {
        Integer integer = Integer.valueOf(numeroStr);
        //return Optional.ofNullable(integer);
        return Optional.empty();
    }
}
