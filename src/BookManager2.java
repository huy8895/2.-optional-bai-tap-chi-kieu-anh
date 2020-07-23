import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class BookManager2 {
    Scanner scanner = new Scanner(System.in);
    ArrayList<Book> booksList = new ArrayList<>();

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
        while (true) {
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
                    sort();
                    break;
                case SIX:
                    getPriceByBookNameVerBinarySearch();
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


    private void setDefaultData() {
        booksList.clear();
        booksList.add(new ProgrammingBook("pgb1", "java book", 30, "Leigh", "Java", "none"));
        booksList.add(new ProgrammingBook("pgb2", "php book", 20, "Casey", "php", "none"));
        booksList.add(new ProgrammingBook("pgb3", "C# book", 50, "McQuiston", "C#", "none"));
        booksList.add(new ProgrammingBook("pgb4", "C++ book", 40, "Griffin", "C++", "none"));

        booksList.add(new FictionBook("fcb1", "harry porter ", 55, "Bardugo", "khoa hoc vien tuong"));
        booksList.add(new FictionBook("fcb2", "the hobbit", 35, "Taylor", "khoa hoc vien tuong"));
        booksList.add(new FictionBook("fcb3", "the silent patient", 35, "alex", "khoa hoc vien tuong"));
        booksList.add(new FictionBook("fcb4", "the testaments", 28.95, "Margret Atwood", "khoa hoc vien tuong"));
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
        booksList.add(programmingBook);
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

        booksList.add(fictionBook);
    }

    public void getTotalPrice() {
        double totalPrice = 0;
        for (Book book : booksList)
            totalPrice += book.getPrice();
        System.out.println("tong tien: " + totalPrice);

    }

    public void getNumberJavaBooks() {
        int countJavaBook = 0;
        for (Book book : booksList) {
            if (book instanceof ProgrammingBook) {
                if (((ProgrammingBook) book).getLanguage().equals("Java"))
                    countJavaBook++;
            }

        }
        System.out.println("so luong sach Java : " + countJavaBook);
    }

    public void display() {
        for (Book book : booksList)
            System.out.println(book);
        System.out.println();
    }

    public void getPriceByBookNameVerLinearSearch() {
        System.out.println("nhap ten sach can tim: ");
        String bookName = scanner.nextLine().trim();
        boolean isExit = false;
        for (Book book : booksList) {
            if (book.getName().equals(bookName)) {
                System.out.println("cuon sach ten: " + bookName + " co gia la: " + book.getPrice());
                isExit = true;
            }
        }
        if (!isExit)
            System.out.println("khong tim thay cuon sach co ten la: " + bookName);
    }

    public void getPriceByBookNameVerBinarySearch() {
        Collections.sort(booksList, new Comparator<Book>() {
            @Override
            public int compare(Book b1, Book b2) {
                return b1.getName().compareTo(b2.getName());
            }
        });
        System.out.println("nhap ten sach can tim: ");
        String bookName = scanner.nextLine().trim();
        boolean isExit = false;
        int low = 0;
        int high = booksList.size() - 1;
        while (high > low) {
            int mid = (high + low) / 2;
            if (booksList.get(low).getName().compareTo(booksList.get(mid).getName()) < 0) {
                high = mid - 1;
            } else if (booksList.get(low).getName().compareTo(booksList.get(mid).getName()) > 0) {
                low = mid + 1;
            } else if (bookName.equals(booksList.get(mid).getName())) {
                System.out.println("cuon sach ten: " + bookName + " co gia la: " + booksList.get(mid).getPrice());
                isExit = true;
            }
        }
        if (!isExit)
            System.out.println("khong tim thay cuon sach co ten la: " + bookName);
    }

    public void sort() {
        System.out.println("chon kieu sap xep: ");
        System.out.println("1. Bubble sort.");
        System.out.println("2. Insertion sort.");
        System.out.println("3. Selection sort.");
        System.out.println("4. Set Default");
        choice = scanner.nextLine();
        switch (choice) {
            case ONE:
                bubbleSortPrice();
                break;
            case TWO:
                insertionSortPrice();
                break;
            case THREE:
                selectionSortPrice();
                break;
            case FOUR:
                setDefaultData();
                break;
            case ZERO:
                startMenu();
                break;
            default:
                sort();
        }
    }

    public void bubbleSortPrice() {
        int n = booksList.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (booksList.get(j).getPrice() > booksList.get(j + 1).getPrice()) {
                    Book temp = booksList.get(j);
                    booksList.set(j, booksList.get(j + 1));
                    booksList.set(j + 1, temp);
                }
            }
        }

    }

    public void insertionSortPrice() {
        int n = booksList.size();
        for (int i = 0; i < n; i++) {
            Book key = booksList.get(i);
            int j = i - 1;

            while (j >= 0 && booksList.get(j).getPrice() > key.getPrice()) {
                booksList.set(j + 1, booksList.get(j));
                j--;
            }
            booksList.set(j + 1, key);
        }
    }

    public void selectionSortPrice() {
        int n = booksList.size();
        for (int i = 0; i < n; i++) {
            Book min = booksList.get(i);
            for (int j = i + 1; j < n; j++) {
                if (min.getPrice() > booksList.get(j).getPrice()) {
                    Book temp = booksList.get(i);
                    booksList.set(i, booksList.get(j));
                    booksList.set(j, temp);
                }
            }
        }
    }

}
