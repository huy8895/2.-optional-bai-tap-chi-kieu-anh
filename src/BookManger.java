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
        for (Book book: programmingBooks)
            System.out.println(book);
        System.out.println("ProgrammingBook.getCountJavaBook() = " + ProgrammingBook.getCountJavaBook());
        System.out.println("ProgrammingBook.getTotalPrice() = " + ProgrammingBook.getTotalPrice());



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
        books[1] = new ProgrammingBook("pgb1","java book1",10.5,"tony Dung","Java","none");
        books[2] = new ProgrammingBook("pgb1","java book1",10.5,"tony Dung","Java","none");
        books[3] = new ProgrammingBook("pgb1","java book1",10.5,"tony Dung","Java","none");
        books[4] = new ProgrammingBook("pgb1","java book1",10.5,"tony Dung","Java","none");
    }

    public static void setFictionBookData(Book[] books){
        books[0] = new FictionBook("fcb1","fictionbook1",10,"adam quan","honor");
        books[1] = new FictionBook("fcb1","fictionbook1",10,"adam quan","honor");
        books[2] = new FictionBook("fcb1","fictionbook1",10,"adam quan","honor");
        books[3] = new FictionBook("fcb1","fictionbook1",10,"adam quan","honor");
        books[4] = new FictionBook("fcb1","fictionbook1",10,"adam quan","honor");
    }
}
