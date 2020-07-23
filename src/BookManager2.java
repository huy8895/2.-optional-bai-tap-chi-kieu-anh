import java.util.ArrayList;
import java.util.Scanner;

public class BookManager2 {
    Scanner scanner = new Scanner(System.in);
    ArrayList<ProgrammingBook> listProgrammingBook = new ArrayList<ProgrammingBook>();
    ArrayList<FictionBook> listFictionBook = new ArrayList<FictionBook>();
    private static String choice;
    private static final String JAVA_BOOK = "1";
    private static final String FICTION_BOOK = "2";
    private static final String ONE = "1";
    private static final String TWO = "2";
    private static final String THREE = "3";
    private static final String FOUR = "4";
    private static final String FIVE = "5";
    private static final String SIX = "6";
    private static final String SEVEN = "7";
    private static final String ZERO = "0";


    public BookManager2() {
        setDefaultData();

    }


    public void startMenu() {
        while (true){
            System.out.println("-----");
            System.out.println("Menu: ");
            System.out.println("1. them sach");
            System.out.println("2. hien thi tong tien ");
            System.out.println("3. dem so sach la java ");
            System.out.println("4. tim gia theo ten ");
            System.out.println("5. sap xep thu vien ");
            System.out.println("6. tim gia theo ten bang phuong phap nhi phan ");
            System.out.println("7. hien thi danh sach cua thu vien ");
            System.out.println("0. exit");
            System.out.println("-----");
            choice = scanner.nextLine();
            switch (choice) {
                case ONE:
                    addBook();
                    break;
                case TWO:
                    getTotalPrice();
                    break;
                case SEVEN:
                    display();
                    break;
                case ZERO:
                    System.exit(0);
                default:
                    startMenu();
            }
        }
    }

    private void setDefaultData(){
        listProgrammingBook.add(new ProgrammingBook("pgb1", "java book huy", 30, "tony Dung", "Java", "none"));
        listProgrammingBook.add(new ProgrammingBook("pgb1", "java book huy", 20, "tony Dung", "Java", "none"));
        listProgrammingBook.add(new ProgrammingBook("pgb1", "java book huy", 50, "tony Dung", "Java", "none"));
        listProgrammingBook.add(new ProgrammingBook("pgb1", "java book huy", 40, "tony Dung", "Java", "none"));

        listFictionBook.add(new FictionBook("fcb1", "fictionbook1", 55, "vo ba quan", "khoa hoc vien tuong"));
        listFictionBook.add(new FictionBook("fcb1", "fictionbook1", 35, "vo ba quan", "khoa hoc vien tuong"));
        listFictionBook.add(new FictionBook("fcb1", "fictionbook1", 35, "vo ba quan", "khoa hoc vien tuong"));
        listFictionBook.add(new FictionBook("fcb1", "fictionbook1", 15, "vo ba quan", "khoa hoc vien tuong"));
    }


    public void addBook() {

        System.out.println("1. them sach Programming book.");
        System.out.println("2. them sach Fiction book");
        System.out.println("0. quay tro lai");
        choice = scanner.nextLine();

        switch (choice) {
            case JAVA_BOOK:
                addProgrammingBook();
                addBook();
                break;
            case FICTION_BOOK:
                addFictionBook();
                addBook();
                break;
            case ZERO:
                startMenu();
                break;
            default:
                addBook();

        }

    }

    public void addProgrammingBook() {
        ProgrammingBook programmingBook = new ProgrammingBook();
        System.out.println("Enter ProgrammingBook code: ");
        programmingBook.setBookCode(scanner.nextLine());

        System.out.println("Enter ProgrammingBook name: ");
        programmingBook.setName(scanner.nextLine());

        System.out.println("Enter ProgrammingBook author: ");
        programmingBook.setAuthor(scanner.nextLine());

        System.out.println("Enter ProgrammingBook language: ");
        programmingBook.setLanguage(scanner.nextLine());

        System.out.println("Enter ProgrammingBook frameWork: ");
        programmingBook.setFrameWork(scanner.nextLine());

        System.out.println("Enter ProgrammingBook price: ");
        programmingBook.setPrice(scanner.nextDouble());
        listProgrammingBook.add(programmingBook);
    }

    public void addFictionBook() {
        FictionBook fictionBook = new FictionBook();
        System.out.println("Enter FictionBook code: ");
        fictionBook.setBookCode(scanner.nextLine());

        System.out.println("Enter FictionBook name: ");
        fictionBook.setName(scanner.nextLine());

        System.out.println("Enter FictionBook author: ");
        fictionBook.setAuthor(scanner.nextLine());

        System.out.println("Enter FictionBook category: ");
        fictionBook.setCategory(scanner.nextLine());

        System.out.println("Enter FictionBook price: ");
        fictionBook.setPrice(scanner.nextDouble());

        listFictionBook.add(fictionBook);
    }

    public void getTotalPrice(){
        double totalPrice = 0;
        for (ProgrammingBook programmingBook: listProgrammingBook)
            totalPrice+= programmingBook.getPrice();
        for (FictionBook fictionBook: listFictionBook)
            totalPrice+= fictionBook.getPrice();
        System.out.println("tong tien: " + totalPrice);

    }


    public void display() {
        for (ProgrammingBook programmingBook: listProgrammingBook)
            System.out.println(programmingBook);
        for (FictionBook fictionBook: listFictionBook)
            System.out.println(fictionBook);
    }
}
