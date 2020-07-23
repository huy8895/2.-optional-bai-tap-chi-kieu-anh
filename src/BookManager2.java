import java.util.ArrayList;
import java.util.Collections;
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
                case THREE:
                    getNumberJavaBooks();
                    break;
                case FOUR:
                    getPriceByBookNameVerLinearSearch();
                    break;
                case FIVE:
                case SIX:
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
        listProgrammingBook.add(new ProgrammingBook("pgb1", "java book", 30, "Leigh", "Java", "none"));
        listProgrammingBook.add(new ProgrammingBook("pgb2", "php book", 20, "Casey", "php", "none"));
        listProgrammingBook.add(new ProgrammingBook("pgb3", "C# book", 50, "McQuiston", "C#", "none"));
        listProgrammingBook.add(new ProgrammingBook("pgb4", "C++ book", 40, "Griffin", "C++", "none"));

        listFictionBook.add(new FictionBook("fcb1", "harry porter ", 55, "Bardugo", "khoa hoc vien tuong"));
        listFictionBook.add(new FictionBook("fcb2", "the hobbit", 35, "Taylor", "khoa hoc vien tuong"));
        listFictionBook.add(new FictionBook("fcb3", "the silent patient", 35, "alex", "khoa hoc vien tuong"));
        listFictionBook.add(new FictionBook("fcb4", "the testaments", 28.95, "Margret Atwood", "khoa hoc vien tuong"));
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

    public void getNumberJavaBooks(){
        int countJavaBook = 0;
        for (ProgrammingBook programmingBook: listProgrammingBook){
            if (programmingBook.getLanguage().equals("Java"))
                countJavaBook++;
        }
        System.out.println("so luong sach Java : " + countJavaBook );
    }

    public void display() {
        for (ProgrammingBook programmingBook: listProgrammingBook)
            System.out.println(programmingBook);
        for (FictionBook fictionBook: listFictionBook)
            System.out.println(fictionBook);
    }

    public void getPriceByBookNameVerLinearSearch(){
        System.out.println("nhap ten sach can tim: ");
        String bookName = scanner.nextLine().trim();
        boolean isExit = false;
        ArrayList<Book> booksList = new ArrayList<>();
        booksList.addAll(listProgrammingBook);
        booksList.addAll(listFictionBook);
        for (Book book:booksList){
            if (book.getName().equals(bookName)){
                System.out.println("cuon sach ten: " + bookName + " co gia la: " + book.getPrice());
                isExit = true;
            }
        }
        if (!isExit)
        System.out.println("khong tim thay cuon sach co ten la: " + bookName);
    }
}
