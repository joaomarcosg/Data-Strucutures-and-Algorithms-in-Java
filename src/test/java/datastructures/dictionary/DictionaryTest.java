package test.java.datastructures.dictionary;

import main.java.datastructures.dictionary.Dictionary;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DictionaryTest {

    private Dictionary<String, String> dictionary;

    @BeforeEach
    void setUp() {
        dictionary = new Dictionary<>();
    }

    @Test
    void put_and_get_returns_stored_value() {
        dictionary.put("Gandalf", "gandalf@email.com");
        assertEquals("gandalf@email.com", dictionary.get("Gandalf"));
    }

    @Test
    void get_returns_null_for_missing_key() {
        assertNull(dictionary.get("John"));
    }

    @Test
    void containsKey_returns_true_for_existing_key() {
        dictionary.put("Tyrion", "tyrion@email.com");
        assertTrue(dictionary.containsKey("Tyrion"));
    }

    @Test
    void remove_deletes_key_and_returns_value() {
        dictionary.put("Tyrion", "tyrion@email.com");

        String removed = dictionary.remove("Tyrion");

        assertEquals("tyrion@email.com", removed);
        assertFalse(dictionary.containsKey("Tyrion"));
    }
}