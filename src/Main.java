import java.util.Comparator;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        List <Integer> ist = List.of(1, 2, 3, 4 ,5, 7);
        searchForEvenNumbers(ist);
    }

    //Task1
    public static <T> void  findMinMax(Stream<? extends T> stream,
                                       Comparator<? super T> order,
                                       BiConsumer <? super T, ? super T> minMaxConsumer) {
        List <T> list = stream
                .collect(Collectors.toList());
        if (list.isEmpty()) {
            minMaxConsumer.accept (null, null);
        } else {
            list.sort(order);
            minMaxConsumer.accept(list.get(0), list.get(list.size()-1));
        }
    }

    public static void searchForEvenNumbers (List <Integer> numbers) {
        List <Number> list = numbers.stream()
                .filter(n -> n % 2 == 0)
                .collect(Collectors.toList());
        System.out.println(list.size());
    }
}