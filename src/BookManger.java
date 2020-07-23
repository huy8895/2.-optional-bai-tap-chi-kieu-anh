import Book.Book;
import Book.ProgrammingBook;
import Book.FictionBook;
import java.util.Scanner;

public class BookManger {
    public static void main(String[] args) {
        Book[] programmingBooks = new ProgrammingBook[5];
        Book[] fictionBooks = new FictionBook[5];
//        BookManger.setBookData(programmingBooks);
        BookManger.setProgrammingBookData(programmingBooks);
        BookManger.setFictionBookData(fictionBooks);

        for (Book book: programmingBooks)
            System.out.println(book);
        System.out.println("ProgrammingBook.getCountJavaBook() = " + ProgrammingBook.getCountJavaBook());
        System.out.println("ProgrammingBook.getTotalPrice() = " + ProgrammingBook.getTotalPrice());

        System.out.println(BookManger.findPriceByBookName(fictionBooks,"fictionbook5"));

        


    }

    public static void setBookData(Book[] books){
        Scanner scanner = new Scanner(System.in);
        if (books instanceof ProgrammingBook[]){
            for (int i = 0; i < books.length;i++){
                int no = i + 1;
                books[i] = new ProgrammingBook();
                System.out.println("Enter ProgrammingBook" + no + " code: ");
                books[i].setBookCode(scanner.nextLine());

                System.out.println("Enter ProgrammingBook" + no + " name: ");
                books[i].setName(scanner.nextLine());

                System.out.println("Enter ProgrammingBook" + no + " author: ");
                books[i].setAuthor(scanner.nextLine());

                System.out.println("Enter ProgrammingBook" + no + " language: ");
                ((ProgrammingBook)books[i]).setLanguage(scanner.nextLine());

                System.out.println("Enter ProgrammingBook" + no + " frameWork: ");
                ((ProgrammingBook)books[i]).setFrameWork(scanner.nextLine());

                System.out.println("Enter ProgrammingBook" + no + " price: ");
                books[i].setPrice(scanner.nextDouble());
                scanner.nextLine();

            }
        }
        if (books instanceof FictionBook[]){
            for (Book book: books){
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
                ((FictionBook)book).setCategory(scanner.nextLine());
            }
        }
    }

    public static void setProgrammingBookData(Book[] books){
        books[0] = new ProgrammingBook("pgb1","java book1",10.5,"tony Dung","Java","none");
        books[1] = new ProgrammingBook("pgb2","java book2",20.5,"tony Dung","Java","none");
        books[2] = new ProgrammingBook("pgb3","java book3",10.5,"tony Dung","Java","none");
        books[3] = new ProgrammingBook("pgb4","java book4",10.5,"tony Dung","Java","none");
        books[4] = new ProgrammingBook("pgb5","java book5",10.5,"tony Dung","Java","none");
    }

    public static void setFictionBookData(Book[] books){
        books[0] = new FictionBook("fcb1","fictionbook1",10.6,"vo ba quan","khoa hoc vien tuong");
        books[1] = new FictionBook("fcb2","my life story",20.7,"quoc tung","tam ly");
        books[2] = new FictionBook("fcb3","fictionbook3",30.9,"chi thuy","gia dinh");
        books[3] = new FictionBook("fcb4","my style",40.1,"van dung","fashion");
        books[4] = new FictionBook("fcb5","fictionbook5",50.5,"adam quan","honor");
    }
    
    public static double findPriceByBookName(Book[] books,String bookName){
        for (Book book: books){
            if (bookName.equals(book.getName())){
                return book.getPrice();
            }
        }
        return 0;
    }
}
