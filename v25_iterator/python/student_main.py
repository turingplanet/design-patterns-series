from collections.abc import Iterator

class Student:
    def __init__(self, name, age):
        self.name = name
        self.age = age

    def get_name(self):
        return self.name

    def get_age(self):
        return self.age

class ClassroomIterator(Iterator):
    def __init__(self, classroom):
        self.classroom = classroom
        self.index = 0

    def __next__(self):
        try:
            student = self.classroom.get_student_at(self.index)
        except IndexError:
            raise StopIteration()
        self.index += 1
        return student

class Classroom:
    def __init__(self):
        self.students = []

    def add_student(self, student):
        self.students.append(student)

    def get_student_at(self, index):
        return self.students[index]

    def get_size(self):
        return len(self.students)

    def create_iterator(self):
        return ClassroomIterator(self)

def main():
    classroom = Classroom()
    classroom.add_student(Student("Alice", 20))
    classroom.add_student(Student("Bob", 21))
    classroom.add_student(Student("Charlie", 22))

    iterator = classroom.create_iterator()
    while True:
        try:
            student = next(iterator)
            print(student.get_name() + ": " + str(student.get_age()))
        except StopIteration:
            break

if __name__ == "__main__":
    main()


