import java.util.Arrays;
import java.util.List;

public class JavaDebugLambda {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 5, 9, 4, 1);

        list.stream()
                .map(n -> new StringBuilder().append(n).append("s").append("a"))
                .forEach(System.out::println);

    }
}
