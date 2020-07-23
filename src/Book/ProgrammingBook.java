package Book;

public class ProgrammingBook extends Book {
    private String language;
    private String frameWork;
    private final String JAVA_LANGUAGE = "Java";
    private static int countJavaBook = 0;
    public ProgrammingBook() {
    }

    public ProgrammingBook(String bookCode, String name, double price, String author, String language, String frameWork) {
        super(bookCode, name, price, author);
        this.language = language;
        this.frameWork = frameWork;
        if (language.equals(JAVA_LANGUAGE)){
            countJavaBook ++;
        }
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
        if (language.equals(JAVA_LANGUAGE)){
            countJavaBook ++;
        }
    }

    public String getFrameWork() {
        return frameWork;
    }

    public void setFrameWork(String frameWork) {
        this.frameWork = frameWork;
    }

    public static int getCountJavaBook() {
        return countJavaBook;
    }

    @Override
    public String toString() {
        return "ProgrammingBook{" +
                "bookCode='" + bookCode + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", author='" + author + '\'' +
                ", language='" + language + '\'' +
                ", frameWork='" + frameWork + '\'' +
                '}';
    }
}
