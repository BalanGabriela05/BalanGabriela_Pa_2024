package org.example;

import org.w3c.dom.Node;

import java.util.Objects;

public class Stick {
    Node node1;
    Node node2;

    // Equality and Hashing
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Stick)) return false;
        Stick stick = (Stick) o;
        return Objects.equals(node1, stick.node1) && Objects.equals(node2, stick.node2);
    }

    @Override
    public int hashCode() {
        return Objects.hash(node1, node2);
    }
}
