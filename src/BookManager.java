import java.util.*;

public class BookManager {
    public static void main(String[] args) {
        Book[] programmingBooks = new ProgrammingBook[5];
        Book[] fictionBooks = new FictionBook[5];

        //BookManager.setBookDataManual(programmingBooks);
        BookManager.setProgrammingBookDataByTemplate(programmingBooks);
        BookManager.setFictionBookDataByTemplate(fictionBooks);
        BookManager.displayAll(programmingBooks,fictionBooks);


    }
    public static Book[] combine(Book[] books1,Book[] books2){
        int lengthNew = books1.length + books2.length;
        Book[] books = new Book[lengthNew];
        for (int i = 0; i < books1.length;i++){
            books[i] = books1[i];
        }
        for (int j = books1.length -1; j < lengthNew;j++){
            books[j] = books[j];
        }
        return books;
    }

    public static void displayAll(Book[] books1,Book[] books2) {
        ArrayList<Book> books = new ArrayList<>();
        Collections.addAll(books,books1);
        Collections.addAll(books,books2);
        for (Book book : books)
            System.out.println(book);

    }
    public static void displayAll(Book[] books1) {
        ArrayList<Book> books = new ArrayList<>();
        Collections.addAll(books,books1);
        for (Book book : books)
            System.out.println(book);

    }

//    //public static void showTotalPrice() {
//        System.out.println("Total Price: " + Book.getTotalPrice());
//    }

    public static void setBookDataManual(Book[] books) {
        Scanner scanner = new Scanner(System.in);
        if (books instanceof ProgrammingBook[]) {
            for (int i = 0; i < books.length; i++) {
                int no = i + 1;
                books[i] = new ProgrammingBook();
                System.out.println("Enter ProgrammingBook" + no + " code: ");
                books[i].setBookCode(scanner.nextLine());

                System.out.println("Enter ProgrammingBook" + no + " name: ");
                books[i].setName(scanner.nextLine());

                System.out.println("Enter ProgrammingBook" + no + " author: ");
                books[i].setAuthor(scanner.nextLine());

                System.out.println("Enter ProgrammingBook" + no + " language: ");
                ((ProgrammingBook) books[i]).setLanguage(scanner.nextLine());

                System.out.println("Enter ProgrammingBook" + no + " frameWork: ");
                ((ProgrammingBook) books[i]).setFrameWork(scanner.nextLine());

                System.out.println("Enter ProgrammingBook" + no + " price: ");
                books[i].setPrice(scanner.nextDouble());
                scanner.nextLine();

            }
        }
        if (books instanceof FictionBook[]) {
            for (Book book : books) {
                book = new FictionBook();
                System.out.println("Enter FictionBook code: ");
                book.setBookCode(scanner.nextLine());

                System.out.println("Enter FictionBook name: ");
                book.setName(scanner.nextLine());

                System.out.println("Enter FictionBook price: ");
                book.setPrice(scanner.nextDouble());

                System.out.println("Enter FictionBook author: ");
                book.setAuthor(scanner.nextLine());

                System.out.println("Enter FictionBook category: ");
                ((FictionBook) book).setCategory(scanner.nextLine());
            }
        }
    }

    public static void setProgrammingBookDataByTemplate(Book[] books) {
        books[0] = new ProgrammingBook("pgb1", "java book huy", 50, "tony Dung", "Java", "none");
        books[1] = new ProgrammingBook("pgb2", "java book tuan", 10, "tony Dung", "Java", "none");
        books[2] = new ProgrammingBook("pgb3", "java book tung", 30.5, "tony Dung", "Java", "none");
        books[3] = new ProgrammingBook("pgb4", "java book quan", 6.0, "tony Dung", "Java", "none");
        books[4] = new ProgrammingBook("pgb5", "java book thuy", 70, "tony Dung", "Java", "none");
    }

    public static void setFictionBookDataByTemplate(Book[] books) {
        books[0] = new FictionBook("fcb1", "fictionbook1", 10.6, "vo ba quan", "khoa hoc vien tuong");
        books[1] = new FictionBook("fcb2", "my life story", 20.7, "quoc tung", "tam ly");
        books[2] = new FictionBook("fcb3", "fictionbook3", 30.9, "chi thuy", "gia dinh");
        books[3] = new FictionBook("fcb4", "my style", 40.1, "van dung", "fashion");
        books[4] = new FictionBook("fcb5", "fictionbook5", 10.5, "adam quan", "honor");
    }

    public static double findPriceByLinearSearch(Book[] books, String bookName) {
        for (Book book : books) {
            if (bookName.equals(book.getName())) {
                return book.getPrice();
            }
        }
        return 0;
    }

    public static int findPriceByBinarySearch(Book[] books1,Book[] books2, String bookName) {
        Book[] bookList = combine(books1,books2);
        softBooksByName(bookList);

        int low = 0;
        int high = bookList.length - 1;
        while (high > low) {
            int mid = (high + low) / 2;
            if (bookName.charAt(0) < bookList[mid].getName().charAt(0)) {
                high = mid - 1;
            } else if (bookName.charAt(0) < bookList[mid].getName().charAt(0)) {
                low = mid + 1;
            } else if (bookName.equals(bookList[mid])) {
                return mid;
            }
        }
        return -1;
    }

    public static void softBooksByName(Book[] books){
        Arrays.sort(books, new Comparator<Book>() {
            @Override
            public int compare(Book book1, Book book2) {
                return book1.getName().compareTo(book2.getName());
            }
        });
    }

    public static void sortBookName(Book[] books) {
        int n = books.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (books[j].getName().charAt(0) > books[j + 1].getName().charAt(0)) {
                    Book temp = books[j];
                    books[j] = books[j + 1];
                    books[j + 1] = temp;
                }
            }
        }
    }

    public static void bubbleSortPrice(Book[] books) {
        int n = books.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (books[j].getPrice() > books[j + 1].getPrice()) {
                    Book temp = books[j];
                    books[j] = books[j + 1];
                    books[j + 1] = temp;
                }
            }
        }

    }

    public static void insertionSortPrice(Book[] books) {
        int n = books.length;
        for (int i = 0; i < n; i++) {
            Book key = books[i];
            int j = i - 1;

            while (j >= 0 && books[j].getPrice() > key.getPrice()) {
                books[j + 1] = books[j];
                j--;
            }
            books[j + 1] = key;
        }
    }

    public static void selectionSortPrice(Book[] books) {
        int n = books.length;
        for (int i = 0; i < n; i++) {
            Book min = books[i];
            for (int j = i + 1; j < n; j++) {
                if (min.getPrice() > books[j].getPrice()) {
                    Book temp = books[i];
                    books[i] = books[j];
                    books[j] = temp;
                }
            }
        }
    }

}
