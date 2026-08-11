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

    @Test
    void should_return_only_elements_in_the_first_set() {
        SetStructure<String> setA = new SetStructure<>();
        setA.add("John");
        setA.add("Jack");
        setA.add("Camila");

        SetStructure<String> setB = new SetStructure<>();
        setB.add("John");
        setB.add("Tom");

        SetStructure<String> result = setA.difference(setB);

        assertEquals(2, result.size());
        assertTrue(result.has("Jack"));
        assertTrue(result.has("Camila"));
        assertFalse(result.has("John"));
    }

    @Test
    void should_return_empty_set_when_sets_are_equals() {
        SetStructure<String> setA = new SetStructure<>();
        setA.add("John");
        setA.add("Jack");

        SetStructure<String> setB = new SetStructure<>();
        setB.add("John");
        setB.add("Jack");

        SetStructure<String> result = setA.difference(setB);

        assertTrue(result.isEmpty());
    }

    @Test
    void difference_is_not_commutative() {
        SetStructure<String> setA = new SetStructure<>();
        setA.add("John");
        setA.add("Jack");

        SetStructure<String> setB = new SetStructure<>();
        setB.add("John");
        setB.add("Camila");

        SetStructure<String> resultAB = setA.difference(setB);
        SetStructure<String> resultBA = setB.difference(setA);

        assertEquals(1, resultAB.size());
        assertTrue(resultAB.has("Jack"));

        assertEquals(1, resultBA.size());
        assertTrue(resultBA.has("Camila"));

    }

    @Test
    void should_return_true_when_set_is_a_subset_of_other_set() {
        SetStructure<String> setA = new SetStructure<>();
        setA.add("Jack");
        setA.add("John");

        SetStructure<String> setB = new SetStructure<>();
        setB.add("John");
        setB.add("Jack");
        setB.add("Camila");

        assertTrue(setA.isSubsetOf(setB));
    }

    @Test
    void should_return_false_when_set_is_not_subset_of_other_set() {
        SetStructure<String> setA = new SetStructure<>();
        setA.add("Jack");
        setA.add("John");

        SetStructure<String> setB = new SetStructure<>();
        setB.add("Jack");
        setB.add("Tom");
        setB.add("Camila");

        assertFalse(setA.isSubsetOf(setB));
    }

    @Test
    void should_return_false_when_first_subset_is_bigger_then_other_set() {
        SetStructure<String> setA = new SetStructure<>();
        setA.add("Jack");
        setA.add("John");
        setA.add("Camila");

        SetStructure<String> setB = new SetStructure<>();
        setB.add("Jack");
        setB.add("Tom");

        assertFalse(setA.isSubsetOf(setB));
    }

}
