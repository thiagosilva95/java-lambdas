import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.regex.Pattern;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class JavaStreamCreation {

    public static void main(String[] args) throws IOException {

        // Collection
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);

        list.stream()
                .forEach(System.out::println);

        // Arrays
        Integer[] intArray = new Integer[] {1, 2, 3, 4};
        Arrays.stream(intArray)
                .forEach(System.out::println);

        // Stream.of
        Stream.of("Uma", "palavra", "aqui")
                .forEach(System.out::println);

        // IntStream.range
        IntStream.range(0, 5)
                .forEach(System.out::println);

        IntStream.rangeClosed(0, 5) // inclui o segundo parametro no rage
                .forEach(System.out::println);

        // Stream.iterate
        Stream.iterate(5, n -> n * 2) // começa no 5 e o próximo será 5 * 2
                .limit(10)
                .forEach(System.out::println);


        // BufferedReader - lines
        File file = new File("streams.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));
        br.lines().forEach(System.out::println);

        // Files - arquivos presentes num diretório
        Path p = Paths.get("");
        Files.list(p).forEach(System.out::println);

        // Random
        new Random().ints()
                .limit(10)
                .forEach(System.out::println);

        // Pattern
        String s = "uma palavra";
        Pattern pattern = Pattern.compile("\\w"); // regex que usa pra quebrar a string gerando um stream
        pattern.splitAsStream(s)
                .forEach(System.out::println);

    }
}
