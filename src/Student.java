import java.util.*;

public class Student {

    private String name;
    private List<Book> books;

    public Student(String name, List<Book> books) {
        this.name = name;
        this.books = books;
    }

    public static List<Book> generateBooks(int count) {
        List<Book> books = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            books.add(new Book("Book " + (i + 1), 100 + i * 50, 1990 + i * 2));
        }
        return books;
    }

    @Override
    public String toString() {
        if (books != null) {
            return "Student{" +
                    "name='" + name + '\'' +
                    ", books=" + books +
                    '}';
        } else {
            return "Student{" +
                    "name='" + name + '\'' +
                    '}';
        }
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
