
package com.github.maksimdenisov.datastructures.lists;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

public abstract class SampleSimpleListTest {
    private static final String TEST_DATA = "0,1,2,3,4,5,6,7,8,9";

    private static final String[] TEST_DATA_ARRAY = TEST_DATA.split(",");

    protected abstract SampleSimpleList<String> getTestObject();

    @DisplayName("Add to list")
    @Test
    public void testAdd() {
        String added = "Added data";
        SampleSimpleList<String> list = getTestListWithData();

        list.add(added);

        String[] actual = getArrayFromSimpleSampleList(list);
        String[] expected = (TEST_DATA + "," + added).split(",");
        assertArrayEquals(expected, actual);

    }

    @DisplayName("Get by list")
    @ParameterizedTest
    @CsvSource({
            "0,0",
            "5,5",
            "9,9",
    })
    public void testGet(Integer index, String expectedValue) {
        SampleSimpleList<String> list = getTestListWithData();

        String actual = list.get(index);

        assertEquals(expectedValue, actual);
    }

    @DisplayName("Get not exist element")
    @ParameterizedTest
    @ValueSource(ints = {-1, 11})
    public void testGetNotExists(int index) {
        SampleSimpleList<String> list = getTestListWithData();

        assertThrows(NoSuchElementException.class, () -> list.get(index));
    }

    @DisplayName("Insert into list")
    @ParameterizedTest
    @CsvSource(value = {
            "0;  Inserted,0,1,2,3,4,5,6,7,8,9",
            "5;  0,1,2,3,4,Inserted,5,6,7,8,9",
            "10; 0,1,2,3,4,5,6,7,8,9,Inserted",
    }, delimiter = ';')
    public void testInsert(int index, String expectedData) {
        SampleSimpleList<String> list = getTestListWithData();

        list.insert(index, "Inserted");

        String[] actual = getArrayFromSimpleSampleList(list);
        String[] expected = expectedData.split(",");
        assertArrayEquals(expected, actual);
    }

    @DisplayName("Insert out of range")
    @ParameterizedTest
    @ValueSource(ints = {-1, 11})
    public void testInsertNotExists(int index) {
        SampleSimpleList<String> list = getTestListWithData();

        assertThrows(NoSuchElementException.class, () -> list.insert(index, "Something"));
    }

    @DisplayName("Replace element at index")
    @ParameterizedTest
    @CsvSource(value = {
            "0; 0;  Replaced,1,2,3,4,5,6,7,8,9",
            "5; 5;  0,1,2,3,4,Replaced,6,7,8,9",
            "9; 9; 0,1,2,3,4,5,6,7,8,Replaced",
    }, delimiter = ';')
    public void testReplace(int index, String expectedPrevious, String expectedData) {
        SampleSimpleList<String> list = getTestListWithData();

        String actualPrevious = list.replace(index, "Replaced");

        String[] actual = getArrayFromSimpleSampleList(list);
        String[] expected = expectedData.split(",");
        assertArrayEquals(expected, actual);
        assertEquals(expectedPrevious, actualPrevious);
    }

    @DisplayName("Replace not exist element")
    @ParameterizedTest
    @ValueSource(ints = {-1, 11})
    public void testReplaceNotExists(int index) {
        SampleSimpleList<String> list = getTestListWithData();

        assertThrows(NoSuchElementException.class, () -> list.insert(index, "Something"));
    }

    @DisplayName("Delete element at index")
    @ParameterizedTest
    @CsvSource(value = {
            "0;   1,2,3,4,5,6,7,8,9",
            "5;   0,1,2,3,4,6,7,8,9",
            "9;  0,1,2,3,4,5,6,7,8",
    }, delimiter = ';')
    public void testDelete(int index, String expectedData) {
        SampleSimpleList<String> list = getTestListWithData();

        boolean actualResult = list.delete(index);

        String[] actual = getArrayFromSimpleSampleList(list);
        String[] expected = expectedData.split(",");
        assertArrayEquals(expected, actual);
        assertTrue(actualResult);
    }

    @DisplayName("Delete not exist element")
    @ParameterizedTest
    @ValueSource(ints = {-1, 11})
    public void testDeleteNotExists(int index) {
        SampleSimpleList<String> list = getTestListWithData();

        assertFalse(list.delete(index));
    }


    @DisplayName("Get from empty list")
    @Test
    public void testEmptyList() {
        SampleSimpleList<String> actual = getTestObject();

        assertThrows(NoSuchElementException.class, () -> actual.get(0));
    }


    private SampleSimpleList<String> getTestListWithData() {
        SampleSimpleList<String> list = getTestObject();
        for (int i = 0; i < TEST_DATA_ARRAY.length; i++) {
            list.add(TEST_DATA_ARRAY[i]);
        }
        return list;
    }

    private String[] getArrayFromSimpleSampleList(SampleSimpleList<String> list) {
        String[] array = new String[list.size()];
        for (int i = 0; i < list.size(); i++) {
            array[i] = list.get(i);
        }
        return array;
    }

}