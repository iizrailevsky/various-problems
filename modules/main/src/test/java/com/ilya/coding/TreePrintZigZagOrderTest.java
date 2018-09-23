package com.ilya.coding;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class TreePrintZigZagOrderTest {

    @Test
    public void testErrors() {
        assertThat(Collections.EMPTY_LIST, is(TreePrintZigZagOrder.getTreeZigZagOrder(null)));
    }

    @Test
    public void testBasic() {
        Node five = new Node(5);
        Node four = new Node(4);
        Node seventeen = new Node(17);
        Node three = new Node(3);
        Node nine = new Node(9);
        Node eleven = new Node(11);
        Node twentySeven = new Node(27);
        Node one = new Node(1);
        Node two = new Node(2);
        Node seven = new Node(7);
        Node ten = new Node(10);
        Node thirteen = new Node(13);
        Node twentyFour = new Node(24);

        five.setLeftChild(four);
        five.setRightChild(seventeen);
        four.setLeftChild(three);
        four.setRightChild(nine);
        three.setLeftChild(one);
        three.setRightChild(two);
        nine.setLeftChild(seven);
        seventeen.setLeftChild(eleven);
        seventeen.setRightChild(twentySeven);
        eleven.setLeftChild(ten);
        eleven.setRightChild(thirteen);
        twentySeven.setLeftChild(twentyFour);

        List<Integer> expected = Arrays.asList(5, 17, 4, 3, 9, 11, 27, 24, 13, 10, 7, 2, 1);
        assertThat(TreePrintZigZagOrder.getTreeZigZagOrder(five), is(expected));
    }

}
