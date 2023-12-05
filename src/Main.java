import boundary.LibraryCli;
import controller.LibraryController;
import repository.BookHashmapRepository;

public class Main {
    BookHashmapRepository bookHashmapRepository = new BookHashmapRepository();
    public static void main(String[] args){
        LibraryCli cli = new LibraryCli();
    }
    // Cli를 호출해야 함.
}