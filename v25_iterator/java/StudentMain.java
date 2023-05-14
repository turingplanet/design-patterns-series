package v25_iterator.java;

import java.util.ArrayList;
import java.util.List;

interface Iterator {
    boolean hasNext();
    Object next();
}

class Student {
    private String name;
    private int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}

class ClassroomIterator implements Iterator {
    private Classroom classroom;
    private int index;

    public ClassroomIterator(Classroom classroom) {
        this.classroom = classroom;
        this.index = 0;
    }

    @Override
    public boolean hasNext() {
        return index < classroom.getSize();
    }

    @Override
    public Object next() {
        Student student = classroom.getStudentAt(index);
        index++;
        return student;
    }
}


interface Aggregate {
    Iterator createIterator();
}

class Classroom implements Aggregate {
    private List<Student> students;

    public Classroom() {
        students = new ArrayList<>();
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public Student getStudentAt(int index) {
        return students.get(index);
    }

    public int getSize() {
        return students.size();
    }

    @Override
    public Iterator createIterator() {
        return new ClassroomIterator(this);
    }
}



public class StudentMain {

    public static void main(String[] args) {
        Classroom classroom = new Classroom();
        classroom.addStudent(new Student("Alice", 20));
        classroom.addStudent(new Student("Bob", 21));
        classroom.addStudent(new Student("Charlie", 22));

        Iterator iterator = classroom.createIterator();
        while (iterator.hasNext()) {
            Student student = (Student) iterator.next();
            System.out.println(student.getName() + ": " + student.getAge());
        }
    }
}

