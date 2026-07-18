package test.java.datastructures.sets;

import main.java.datastructures.sets.SetStructure;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.*;

public class SetStructureTest {

    private SetStructure<String> setStructure;

    @BeforeEach
    void setUp() {
        setStructure = new SetStructure<>();
    }

    @Test
    void should_add_element_successfully() {
        boolean result = setStructure.add("John");

        assertTrue(result);
        assertTrue(setStructure.has("John"));
    }

    @Test
    void should_not_add_duplicate_element() {
        setStructure.add("John");
        boolean result = setStructure.add("John");

        assertFalse(result);
        assertEquals(1, setStructure.size());
    }

    @Test
    void should_return_true_when_element_exists() {
        setStructure.add("John");

        assertTrue(setStructure.has("John"));
    }

    @Test
    void should_return_the_union_of_two_sets() {
        SetStructure<String> setA = new SetStructure<>();
        setA.add("John");
        setA.add("Jack");

        SetStructure<String> setB = new SetStructure<>();
        setB.add("Camila");
        setB.add("Jack");

        SetStructure<String> result = setA.union(setB);

        assertEquals(3, result.size());
        assertTrue(result.has("John"));
        assertTrue(result.has("Jack"));
        assertTrue(result.has("Camila"));
    }
    @Test
    void should_not_modify_original_sets() {
        SetStructure<String> setA = new SetStructure<>();
        setA.add("John");

        SetStructure<String> setB = new SetStructure<>();
        setB.add("Jack");

        setA.union(setB);

        assertEquals(1, setA.size());
        assertEquals(1, setB.size());

    }

    @Test
    void should_return_intersection_of_two_sets() {
        SetStructure<String> setA = new SetStructure<>();
        setA.add("John");
        setA.add("Jack");
        setA.add("Camila");

        SetStructure<String> setB = new SetStructure<>();
        setB.add("John");
        setB.add("Tom");
        setB.add("Camila");

        SetStructure<String> result = setA.intersection(setB);

        assertEquals(2, result.size());
        assertTrue(result.has("John"));
        assertTrue(result.has("Camila"));
    }

    @Test
    void should_return_empty_set_when_there_are_no_common_elements() {
        SetStructure<String> setA = new SetStructure<>();
        setA.add("John");

        SetStructure<String> setB = new SetStructure<>();
        setB.add("Jack");

        SetStructure<String> result = setA.intersection(setB);

        assertTrue(result.isEmpty());
    }
    
}
