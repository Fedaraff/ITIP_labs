package Lab_8;
import java.util.stream.Stream;

public class AggregateProcessor {

    @DataProcessor
    public Stream<String> removeDuplicates(Stream<String> input) {
        return input.distinct();
    }

    @DataProcessor
    public Stream<String> sortAlphabetically(Stream<String> input) {
        return input.sorted();
    }
}



