import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        StringBuilder text = new StringBuilder();
        File file = new File("E:\\in.txt");
        Scanner scanner = new Scanner(file);
        while (scanner.hasNextLine()){
            text.append(scanner.nextLine());
            text.append("\n");
        };


        Analyzer analyzer = new Analyzer();
        analyzer.analyze(text.toString());
    }
}