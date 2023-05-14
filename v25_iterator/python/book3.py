from collections.abc import Iterator

class Book:
    def __init__(self, title):
        self.title = title

    def get_title(self):
        return self.title

class Bookshelf:
    def __init__(self):
        self.books = []

    def add_book(self, book):
        self.books.append(book)

    def iterator(self):
        return BookIterator(self.books)

    def sorted_iterator(self):
        return SortedBookIterator(self.books)

class BookIterator(Iterator):
    def __init__(self, books):
        self.index = 0
        self.books = books

    def __next__(self):
        try:
            book = self.books[self.index]
        except IndexError:
            raise StopIteration()
        self.index += 1
        return book

class SortedBookIterator(Iterator):
    def __init__(self, books):
        self.index = 0
        self.sorted_books = sorted(books, key=lambda book: book.get_title())

    def __next__(self):
        try:
            book = self.sorted_books[self.index]
        except IndexError:
            raise StopIteration()
        self.index += 1
        return book

def main():
    bookshelf = Bookshelf()
    bookshelf.add_book(Book("Book 1"))
    bookshelf.add_book(Book("Book 2"))
    bookshelf.add_book(Book("Book 3"))

    iterator = bookshelf.sorted_iterator()
    for book in iterator:
        print(book.get_title())

if __name__ == "__main__":
    main()

