import org.example.Store.Menu.Appetizer;
import org.example.Store.Menu.Impl.appetizer.MushroomCreamSoup;
import org.example.Store.MenuBoard;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MenuTest {
    @Test
    void test() {
        // given
        Appetizer appetizer = new MushroomCreamSoup();
        // when

        // then
        Assertions.assertEquals("양송이크림스프", appetizer.getDescription());
    }

    @Test
    void menuTest() {
        MenuBoard menuBoard = new MenuBoard();
        System.out.println(menuBoard.showMenu());
    }
}
