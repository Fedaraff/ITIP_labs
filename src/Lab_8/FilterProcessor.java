package Lab_8;
import java.util.stream.Stream;

public class FilterProcessor {

    @DataProcessor
    public Stream<String> filterShortWords(Stream<String> input) {
        return input.filter(s -> s.length() > 3);
    }

    @DataProcessor
    public Stream<String> filterStartingWithA(Stream<String> input) {
        return input.filter(s -> s.toLowerCase().startsWith("p"));
    }
}




