package Lab_8;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DataManager {
    private final List<Object> processors = new ArrayList<>();
    private List<String> data;

    public void registerDataProcessor(Object processor) {
        processors.add(processor);
    }

    public void loadData(String source) throws IOException {
        try (Stream<String> stream = Files.lines(Paths.get(source))) {
            this.data = stream.collect(Collectors.toList());
        }
    }

    public void processData() throws Exception {
        if (data == null) throw new IllegalStateException("Данные не загружены");

        ExecutorService executor = Executors.newFixedThreadPool(processors.size());
        List<Future<List<String>>> futures = new ArrayList<>();

        for (Object processor : processors) {
            Future<List<String>> future = executor.submit(() -> {
                Stream<String> stream = data.stream();

                for (var method : processor.getClass().getDeclaredMethods()) {
                    if (method.isAnnotationPresent(DataProcessor.class)) {
                        @SuppressWarnings("unchecked")
                        Stream<String> result = (Stream<String>) method.invoke(processor, stream);
                        stream = result;
                    }
                }

                return stream.collect(Collectors.toList());
            });
            futures.add(future);
        }

        List<String> combinedResults = new ArrayList<>();
        for (Future<List<String>> future : futures) {
            combinedResults.addAll(future.get());
        }

        executor.shutdown();
        this.data = combinedResults;
    }

    public void saveData(String destination) throws IOException {
        if (data == null) throw new IllegalStateException("Нет данных для сохранения");
        Files.write(Paths.get(destination), data);
    }
}


