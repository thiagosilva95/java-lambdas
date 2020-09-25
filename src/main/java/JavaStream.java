import java.util.Arrays;
import java.util.List;

public class JavaStream {

    public static void main(String[] args) {

        List<Integer> list = Arrays.asList(1, 2, 3, 4 , 6, 9 , 4,8 , 4,9 ,9, 9,4);
        list.stream()
                .skip(2) // ignora os 2 primeiros elementos - operação intermediária
                .limit(7) // considera apenas os 5 primeiros elementos
                .distinct() // não permite que o stream processe elementos repetidos
                .filter(e -> e % 2 == 0) // o ideal é fazer os filtros antes
                .map(e -> e * 2) // lista original não é modificada
                .forEach(System.out::println);

    }
}
