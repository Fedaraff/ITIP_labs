package semester_3.tasks_6;
import java.util.*;
public class sortParams {

    public static String sortParams(String url) {
        int questionMarkIndex = url.indexOf('?');

        if (questionMarkIndex == -1) {
            return url;
        }

        String baseUrl = url.substring(0, questionMarkIndex);
        String paramsString = url.substring(questionMarkIndex + 1);

        String[] params = paramsString.split("&");
        List<Param> paramList = new ArrayList<>();

        for (String param : params) {
            int equalsIndex = param.indexOf('=');
            if (equalsIndex != -1) {
                String name = param.substring(0, equalsIndex);
                String value = param.substring(equalsIndex + 1);

                if (!value.isEmpty()) {
                    paramList.add(new Param(name, value));
                }
            }
        }

        if (paramList.isEmpty()) {
            return baseUrl;
        }

        Collections.sort(paramList, new Comparator<Param>() {
            @Override
            public int compare(Param p1, Param p2) {
                // Сначала по длине значения
                if (p1.value.length() != p2.value.length()) {
                    return Integer.compare(p1.value.length(), p2.value.length());
                }
                return p1.name.compareTo(p2.name);
            }
        });

        StringBuilder result = new StringBuilder(baseUrl);
        result.append("?");

        for (int i = 0; i < paramList.size(); i++) {
            Param p = paramList.get(i);
            result.append(p.name).append("=").append(p.value);
            if (i < paramList.size() - 1) {
                result.append("&");
            }
        }

        return result.toString();
    }

    // Вспомогательный класс для хранения параметра
    static class Param {
        String name;
        String value;

        Param(String name, String value) {
            this.name = name;
            this.value = value;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (scanner.hasNextLine()) {
            String url = scanner.nextLine();
            System.out.println(sortParams(url));
        }
        scanner.close();
    }
}
