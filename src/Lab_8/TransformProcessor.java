package Lab_8;
import java.util.stream.Stream;

public class TransformProcessor {

    @DataProcessor
    public Stream<String> toUpperCase(Stream<String> input) {
        return input.map(String::toUpperCase);
    }

    @DataProcessor
    public Stream<String> addPrefix(Stream<String> input) {
        return input.map(s -> "LANGUAGE: " + s);
    }
}



