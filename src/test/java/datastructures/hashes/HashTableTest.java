package test.java.datastructures.hashes;

import main.java.datastructures.hashes.HashTable;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HashTableTest {

    private HashTable<String, String> table;

    @BeforeEach
    void setUp() {
        table = new HashTable<>();
    }

    @Test
    void should_return_the_associated_values_after_put() {
        table.put("Gandalf", "gandalf@email.com");
        table.put("John", "john@email.com");
        table.put("Tyrion", "tyrion@email.com");

        assertEquals("gandalf@email.com", table.get("Gandalf"));
        assertEquals("john@email.com", table.get("John"));
        assertEquals("tyrion@email.com", table.get("Tyrion"));
    }

    @Test
    void should_return_null_when_key_does_not_exist() {
        table.put("Jack", "jack@email.com");

        assertNull(table.get("not-exist"));
    }

    @Test
    void should_return_the_removed_value_and_delete_the_key() {
        table.put("Gandalf", "gandalf@email.com");
        table.put("John", "john@email.com");

        String removed = table.remove("John");

        assertEquals("john@email.com", removed);
        assertNull(table.get("John"));
        assertEquals("gandalf@email.com", table.get("Gandalf"));
        assertEquals(1, table.size());
    }

}