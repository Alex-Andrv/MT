package model;

import java.util.Arrays;

import java.util.Collections;
import java.util.List;

public class Tree {
    String node;
    List<Tree> children;

    public Tree(String node, Tree... children) {
        this.node = node;
        this.children = Arrays.asList(children);
    }

    public Tree(String node) {
        this.node = node;
        this.children = Collections.emptyList();
    }

    public boolean addChildren(Tree children) {
        return this.children.add(children);
    }


    public int toGraph(StringBuilder dot, int num) {
        dot.append(String.format("n%d [label=\"%s\"] ; \n", num, node));
        int next_number = num + 1;
        for (Tree child : children) {
            dot.append(String.format("n%d -> n%d ; \n", num, next_number));
            next_number = child.toGraph(dot, next_number);
        }
        return next_number;
    }

    public String toDotFormat() {
        StringBuilder dot = new StringBuilder();
        dot.append("digraph G {\n");
        toGraph(dot, 0);
        dot.append("}");
        return dot.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Tree))
            return false;
        Tree other = (Tree)o;
        if (this.children.size() != other.children.size()) {
            return false;
        }
        int len = this.children.size();
        boolean equals = this.node.equals(other.node);
        int childId = 0;
        while (equals && childId < len) {
            Tree firstChild = this.children.get(childId);
            Tree secondChild = other.children.get(childId);
            equals = firstChild.equals(secondChild);
            childId++;
        }
        return equals;
    }

    @Override
    public final int hashCode() {
        int result = node.hashCode();
        for (Tree child : children) {
            result += child.hashCode();
        }
        return result;
    }
}













