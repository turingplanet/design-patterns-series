package v25_iterator.java;

import java.util.ArrayList;

class Book {
    private String title;

    public Book(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}

class Bookshelf {
    private ArrayList<Book> books;

    public Bookshelf() {
        books = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public ArrayList<Book> getBooks() {
        return books;
    }
}

public class Book1 {
    public static void main(String[] args) {
        Bookshelf bookshelf = new Bookshelf();
        bookshelf.addBook(new Book("Book 1"));
        bookshelf.addBook(new Book("Book 2"));
        bookshelf.addBook(new Book("Book 3"));

        ArrayList<Book> books = bookshelf.getBooks();
        for (Book book : books) {
            System.out.println(book.getTitle());
        }
    }
}