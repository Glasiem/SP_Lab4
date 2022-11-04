public class Patterns {

    public static final String COMMENTARY = "//.*?[\n]|/\\*(.|\n)*?\\*/";

    public static final String STRING_LITERAL = "\"(\\\\[nrtfsb\"'\\\\]|[^\\\"])*?\"|'(\\\\[nrtfb\"'\\\\]|.?)'";

    public static final String UNRECOGNIZED1 = "'(\\\\[nrtfb\"'\\\\]|[^']?){2,}'";

    public static final String RESERVED_OR_IDENTIFIER = "\\b[a-zA-Z_\\$][0-9a-zA-Z_\\$]*\\b";

    public static final String FLOATING_POINT = "\\b(([1-9][0-9]*|[0])([.][0-9]+([eE][-+]?[0-9]+)?)|([eE][-+]?[0-9]+))\\b";

    public static final String HEXADECIMAL_LITERAL = "\\b([0][x][0-9A-F]*)\\b";

    public static final String DECIMAL_LITERAL = "\\b([1-9][0-9]*|[0])\\b";

    public static final String OPERATORS = "[%>/<!=*+-][=]?|[|&+-]{1,2}+|\\?|\\.|:";

    public static final String DELIMITER = "[(){};,]";

    public static final String UNRECOGNIZED = "['\"]|\\S+";
}