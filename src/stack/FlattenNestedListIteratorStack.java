package stack;

import java.util.Iterator;
import java.util.List;
import java.util.Stack;

public class FlattenNestedListIteratorStack implements Iterator<Integer> {


    Stack<Iterator<NestedInteger>> stack = new Stack<>();
    Integer current = null;

    //дан лист листов - необходимо пройтись по ним как по плоскому итератору
    //надо сделать мультиитератор
    //этот итератор будет ходить по коллекции
    //коллекция

    public FlattenNestedListIteratorStack(List<NestedInteger> nestedList) {
        if (nestedList != null) {
            stack.push(nestedList.iterator());
        }

    }

    @Override
    public boolean hasNext() {

        while (!stack.isEmpty()) {
            Iterator<NestedInteger> node = stack.peek();

            // This will clear out empty iterators.
            if (!node.hasNext()) {
                stack.pop();
                continue;
            }

            // If the value is an integer, done - load up and return.
            // Otherwise push the current list to the top of the stack and continue.
            NestedInteger value = node.next();
            if (value.isInteger()) {
                current = value.getInteger();
                return true;
            } else {
                stack.push(value.getList().iterator());
            }
        }

        return false;
    }

    @Override
    public Integer next() {
        return current;
    }

}

// This is the interface that allows for creating nested lists.
// You should not implement it, or speculate about its implementation
interface NestedInteger {

    // @return true if this stack.NestedInteger holds a single integer, rather than a nested list.
    boolean isInteger();

    // @return the single integer that this stack.NestedInteger holds, if it holds a single integer
    // Return null if this stack.NestedInteger holds a nested list
    Integer getInteger();

    // @return the nested list that this stack.NestedInteger holds, if it holds a nested list
// Return null if this stack.NestedInteger holds a single integer
    List<NestedInteger> getList();
}
