import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class Tests {

    @Test
    public void testInsert() {
        BinaryTree<Association<String, String>> dictionary = new BinaryTree<>(new Association<>("headphones", "audifonos"));
        dictionary.insert(new Association<>("fish", "pez"));
        Association<String, String> result = dictionary.search(new Association<>("fish", ""));
        assertNotNull(result);
        assertEquals("pez", result.value);
    }

    @Test
    public void testSearch() {
        BinaryTree<Association<String, String>> dictionary = new BinaryTree<>(new Association<>("headphones", "audifonos"));
        dictionary.insert(new Association<>("fish", "pez"));
        Association<String, String> result = dictionary.search(new Association<>("cat", ""));
        assertNull(result);
    }
}