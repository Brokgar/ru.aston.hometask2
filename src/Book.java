import java.util.Objects;

public class Book implements Comparable<Book> {

    private String title;
    private int pages;
    private int publishedYear;

    public Book(String title, int pages, int publishedYear) {
        if (pages > 0 && publishedYear > 0) {
            this.title = title;
            this.pages = pages;
            this.publishedYear = publishedYear;
        } else {
            System.out.println("Invalid data");
        }
    }

    @Override
    public String toString() {
        if (pages > 0 && publishedYear > 0) {
            return "Book{" +
                    "title='" + title + '\'' +
                    ", pages=" + pages +
                    ", publishedYear=" + publishedYear +
                    '}';
        }
        return "";
    }


    @Override
    public int compareTo(Book o) {

        if (this.pages > o.pages) {
            return 1;
        } else if (this.pages < o.pages) {
            return -1;
        }
        return 0;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Book book = (Book) obj;
        return pages == book.pages && publishedYear == book.publishedYear && title.equals(book.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, pages, publishedYear);
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public void setPublishedYear(int publishedYear) {
        this.publishedYear = publishedYear;
    }

    public String getTitle() {
        return title;
    }

    public int getPages() {
        return pages;
    }

    public int getPublishedYear() {
        return publishedYear;
    }
}
