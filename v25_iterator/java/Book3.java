package v25_iterator.java;

import java.util.ArrayList;
import java.util.Comparator;

interface Iterator {
    boolean hasNext();
    Object next();
}

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

    public Iterator iterator() {
        return new BookIterator();
    }

    public Iterator sortedIterator() {
        return new SortedBookIterator();
    }

    private class BookIterator implements Iterator {
        int index;

        public boolean hasNext() {
            return index < books.size();
        }

        public Object next() {
            if (this.hasNext()) {
                return books.get(index++);
            }
            return null;
        }
    }

    private class SortedBookIterator implements Iterator {
        int index;
        ArrayList<Book> sortedBooks;

        public SortedBookIterator() {
            sortedBooks = new ArrayList<>(books);
            sortedBooks.sort(Comparator.comparing(Book::getTitle));
        }

        public boolean hasNext() {
            return index < sortedBooks.size();
        }

        public Object next() {
            if (this.hasNext()) {
                return sortedBooks.get(index++);
            }
            return null;
        }
    }
}

public class Book3 {
    public static void main(String[] args) {
        Bookshelf bookshelf = new Bookshelf();
        bookshelf.addBook(new Book("Book 1"));
        bookshelf.addBook(new Book("Book 2"));
        bookshelf.addBook(new Book("Book 3"));

        Iterator iterator = bookshelf.sortedIterator(); 
        while (iterator.hasNext()) {
            Book book = (Book) iterator.next();
            System.out.println(book.getTitle());
        }
    }
}
