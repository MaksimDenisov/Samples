package com.github.maksimdenisov.datastructures.lists;


class SampleSimpleArrayListTest extends SampleSimpleListTest {

    @Override
    protected SampleSimpleList<String> getTestObject() {
        return new SampleSimpleArrayList<>();
    }
}