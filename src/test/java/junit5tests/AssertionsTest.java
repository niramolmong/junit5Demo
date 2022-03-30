package junit5tests;

import listeners.Listener;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(Listener.class)
public class AssertionsTest {
    //simple test
    //second comment
    //third comment
    @Test
    void assertEqualsTest(){
        assertNotEquals("soda", "SODA");
    }

    @Test
    void assertEqualsListTest(){
        List<String> expectedValues = Arrays.asList("soda", "niramol", "mong");
        List<String> actualValues = Arrays.asList("soda", "niramol", "mong");
        assertEquals(expectedValues, actualValues);
    }

    @Test
    void assertArrayEqualsTest(){
        int[] expectedArray = {1, 2, 3, 4, 5};
        int[] actualArray = {1, 2, 7, 4, 5};
        assertArrayEquals(expectedArray, actualArray);
    }

    @Test
    void assertTrueTest(){
        assertFalse(false);
        assertTrue(false, "This boolean did not validate to true.");
    }

    @Test
    void assertThrowsTest(){
        //throw the exceptions that is expected to passed.
        assertThrows(NullPointerException.class,null);
    }

    @Test
    void assertAllTest(){
        assertAll(
                () -> assertEquals("soda", "SODA"),
                () -> assertThrows(NullPointerException.class,null, "This return True"),
                () -> assertTrue(false, "This boolean did not validate to true.")
        );
    }

    @Test
    void assertMapTest(){
        Map<String, Integer> theMap = new HashMap<>();
        theMap.put("first", 1);
        theMap.put("second", 2);
        theMap.put("third", 3);
        assertThat(theMap, Matchers.hasKey("second"));
        assertThat(theMap, Matchers.hasValue(3));
    }

    @Test
    void assertListTest(){
        List<String> theList = Arrays.asList("first", "second", "third");
        assertThat(theList, Matchers.hasItem("second"));
    }

    @Test
    void assertForAnyOfTest(){
        List<String> theList = Arrays.asList("first", "second", "third");
        assertThat(theList, Matchers.anyOf(Matchers.hasItem("third"), Matchers.hasItem("forth"))); //pass
        assertThat(theList, Matchers.allOf(Matchers.hasItem("third"), Matchers.hasItem("forth"))); //fail
    }

    @Test
    void assertForContainsAnyOrderTest(){
        List<String> theList = Arrays.asList("first", "second", "third");

        assertThat(theList, Matchers.containsInAnyOrder("second", "first", "third"));
    }

}
