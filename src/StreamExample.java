import java.util.Comparator;
import java.util.List;

class StreamExample {
    public static void main(String[] args) {

        List<Student> students = List.of(
                new Student("John", Student.generateBooks(10)),
                new Student("Jack", Student.generateBooks(20)),
                new Student("Jim", Student.generateBooks(50))
        );

        students.stream()
                .peek(System.out::println)
                .flatMap(student -> student.getBooks().stream())
                .sorted(Comparator.comparingInt(Book::getPages))
                .distinct()
                .filter(book -> book.getPublishedYear() > 2000)
                .limit(3)
                .map(Book::getPublishedYear)
                .findFirst()
                .ifPresentOrElse(System.out::println, () -> System.out.println("No books found")
                );
    }
}