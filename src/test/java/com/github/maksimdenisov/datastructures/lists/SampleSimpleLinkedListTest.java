package com.github.maksimdenisov.datastructures.lists;

class SampleSimpleLinkedListTest extends SampleSimpleListTest {

    @Override
    protected SampleSimpleList<String> getTestObject() {
        return new SampleSimpleLinkedList<>();
    }
}