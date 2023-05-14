package v25_iterator.java;

import java.util.ArrayList;

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
}

public class Book2 {
    public static void main(String[] args) {
        Bookshelf bookshelf = new Bookshelf();
        bookshelf.addBook(new Book("Book 1"));
        bookshelf.addBook(new Book("Book 2"));
        bookshelf.addBook(new Book("Book 3"));

        Iterator iterator = bookshelf.iterator();
        while (iterator.hasNext()) {
            Book book = (Book) iterator.next();
            System.out.println(book.getTitle());
        }
    }
}
