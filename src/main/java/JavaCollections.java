import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class JavaCollections {

    public static void main(String[] args) throws IOException {

        // Collection
        //List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);

        list.stream()
                .forEach(System.out::println);
        System.out.println("------------");

      // removeIf
        list.removeIf(n -> n == 2);

        list.stream()
                .forEach(System.out::println);

        System.out.println("------------");
        // replaceAll
        list.replaceAll(n -> n * 2);

        list.stream()
                .forEach(System.out::println);

        System.out.println("------------");

        HashMap<Integer, String> map = new HashMap<>();
        map.put(0, "Uma");
        map.put(1, "palavra");
        map.put(2, "Bem");
        map.put(3, "Aqui");

        map.forEach((k, v) -> System.out.println(k + v));

        System.out.println("------------");

        // compute -> alteração em um elemento de chave específica. Caso a chave não exista, faz um put mas usa o null
        map.compute(0, (k, v) -> v + " agora");
        map.forEach((k, v) -> System.out.println(k + v));

        System.out.println("------------");
        // merge -> caso a chave não exista no map ele cria um registro com essa chave e o valor informado (put)
        map.merge(3, "!", (v1, v2) -> v1 + v2);
        map.forEach((k, v) -> System.out.println(k + v));

        // replaceAll
        System.out.println("------------");
        map.replaceAll((k, v) -> v + "!");
        map.forEach((k, v) -> System.out.println(k + v));

    }
}
