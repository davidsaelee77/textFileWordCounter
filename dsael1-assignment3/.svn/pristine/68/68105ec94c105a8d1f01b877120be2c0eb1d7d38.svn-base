
package tests;

import static org.junit.Assert.*;

import exceptions.EmptyCollectionException;
import org.junit.Test;
import structures.LinkedBinaryTree;


public class LinkedBinaryTreeTest {

    @Test
    public void testContainsMethod() {

        final LinkedBinaryTree<Integer> left = new LinkedBinaryTree<>(1);
        final LinkedBinaryTree<Integer> right = new LinkedBinaryTree<>(5);
        final LinkedBinaryTree<Integer> root = new LinkedBinaryTree<>(3, left, right);

        assertEquals(true, root.contains(1));
        assertTrue(root.contains(1));

    }

    @Test
    public void testContainsMethodEmptyTree() {

        final LinkedBinaryTree<Integer> root = new LinkedBinaryTree<>();

        assertEquals(false, root.contains(null));
        assertFalse(root.contains(null));
    }

    @Test
    public void testGetRootElement() {

        final LinkedBinaryTree<Integer> root = new LinkedBinaryTree<>(3);

        assertEquals((Integer) 3, root.getRootElement());

    }

    @Test(expected = EmptyCollectionException.class)
    public void testGetRootElementException() {

        final LinkedBinaryTree<Integer> root = new LinkedBinaryTree<>();

        root.getRootElement();

    }

    @Test
    public void testToString() {

        final LinkedBinaryTree<Integer> left = new LinkedBinaryTree<>(1);
        final LinkedBinaryTree<Integer> right = new LinkedBinaryTree<>(5);
        final LinkedBinaryTree<Integer> root = new LinkedBinaryTree<>(3, left, right);

        assertEquals("1 3 5 ", root.toString());
    }

    @Test
    public void testSize() {

        final LinkedBinaryTree<Integer> left = new LinkedBinaryTree<>(1);
        final LinkedBinaryTree<Integer> right = new LinkedBinaryTree<>(5);
        final LinkedBinaryTree<Integer> root = new LinkedBinaryTree<>(3, left, right);

        assertEquals(3, root.size());
    }

    @Test
    public void testSizeEmptyTree() {

        final LinkedBinaryTree<Integer> root = new LinkedBinaryTree<>();

        assertEquals(0, root.size());
    }

    @Test
    public void testGetHeight() {

        final LinkedBinaryTree<Integer> left = new LinkedBinaryTree<>(1);
        final LinkedBinaryTree<Integer> right = new LinkedBinaryTree<>(5);
        final LinkedBinaryTree<Integer> root = new LinkedBinaryTree<>(3, left, right);

        assertEquals(1, root.getHeight());

    }

    @Test
    public void testGetHeightEmptyTree() {

        final LinkedBinaryTree<Integer> root = new LinkedBinaryTree<>();

        assertEquals(-1, root.getHeight());

    }

    @Test
    public void testCountLeafNodes() {

        final LinkedBinaryTree<Integer> left = new LinkedBinaryTree<>(1);
        final LinkedBinaryTree<Integer> right = new LinkedBinaryTree<>(5);
        final LinkedBinaryTree<Integer> root = new LinkedBinaryTree<>(3, left, right);

        assertEquals(2, root.countLeafNodes());

    }

}
