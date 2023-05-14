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

    def get_books(self):
        return self.books


if __name__ == "__main__":
    bookshelf = Bookshelf()
    bookshelf.add_book(Book("Book 1"))
    bookshelf.add_book(Book("Book 2"))
    bookshelf.add_book(Book("Book 3"))

    books = bookshelf.get_books()
    for book in books:
        print(book.get_title())


