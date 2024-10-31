package com.example.project.calculation_classes;

import java.util.Objects;

public class MyNode implements Comparable<MyNode> {
    private int key;
    private String value;

    public MyNode(int key, String value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MyNode node = (MyNode) o;
        return key == node.key;
    }

    @Override
    public int hashCode() {
        return Objects.hash(key);
    }

    @Override
    public int compareTo(MyNode o) {
        return Integer.compare(this.key, o.key);
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return key + " " + value;
    }
}
