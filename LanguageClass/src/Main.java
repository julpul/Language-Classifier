import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Collectors;

public class Main {
    public static String getDataFromFiles(Path filePath) throws IOException {
        StringBuilder data = new StringBuilder();
        Files.lines(filePath).forEach(e->{
            data.append(e).append(" ");
        }
        );
        return data.toString();
    }

    public static void main(String[] args) throws IOException {
        System.out.println(getDataFromFiles(Paths.get("C:\\Users\\julia\\OneDrive\\Pulpit\\ML\\Language-Classifier\\LanguageClass\\src\\Languages\\data_en\\data1")));
        /*String x = "abcdefghijk";
        for (int i = 0; i < x.length(); i++) {
            System.out.println(x.charAt(i)-97);

        }*/
    }
}
