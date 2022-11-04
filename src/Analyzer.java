import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Analyzer {
    public record MyPattern(Pattern pattern, String name) {
    }

    private static List<Analyzer.MyPattern> buildPatterns() {
        List<Analyzer.MyPattern> patterns = new ArrayList<>();
        patterns.add(new Analyzer.MyPattern(Pattern.compile(Patterns.COMMENTARY), "commentary"));
        patterns.add(new Analyzer.MyPattern(Pattern.compile(Patterns.STRING_LITERAL), "string literal"));
        patterns.add(new Analyzer.MyPattern(Pattern.compile(Patterns.UNRECOGNIZED1), "unrecognized"));
        patterns.add(new Analyzer.MyPattern(Pattern.compile(Patterns.RESERVED_OR_IDENTIFIER), "reserved word or identifier"));
        patterns.add(new Analyzer.MyPattern(Pattern.compile(Patterns.FLOATING_POINT), "floating point"));
        patterns.add(new Analyzer.MyPattern(Pattern.compile(Patterns.DECIMAL_LITERAL), "decimal literal"));
        patterns.add(new Analyzer.MyPattern(Pattern.compile(Patterns.HEXADECIMAL_LITERAL), "hexadecimal literal"));
        patterns.add(new Analyzer.MyPattern(Pattern.compile(Patterns.OPERATORS), "operator"));
        patterns.add(new Analyzer.MyPattern(Pattern.compile(Patterns.DELIMITER), "delimiter"));
        patterns.add(new Analyzer.MyPattern(Pattern.compile(Patterns.UNRECOGNIZED), "unrecognized"));
        return patterns;
    }

    public record Token(Integer start, String value, String name) {
    }

    public void analyze(String text) {
        List<MyPattern> patterns = buildPatterns();
        List<Token> tokens = new ArrayList<>();
        boolean[] used = new boolean[text.length()];

        for (MyPattern pattern : patterns) {
            Matcher matcher = pattern.pattern.matcher(text);
            while (matcher.find()) {
                if (isEmpty(used, matcher.start(), matcher.end() - 1)) {
                    tokens.add(new Token(matcher.start(), matcher.group(0), pattern.name));
                }
            }
        }

        tokens.sort(Comparator.comparingInt(t -> t.start));
        tokens.forEach(token -> System.out.println(token.value + " - " + token.name));
    }

    private boolean isEmpty(boolean[] used, int l, int r) {
        for (int i = l; i <= r; i++) {
            if (used[i]) {
                return false;
            }
            used[i] = true;
        }
        return true;
    }

}
