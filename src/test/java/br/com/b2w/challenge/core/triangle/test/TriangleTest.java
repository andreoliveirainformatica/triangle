package br.com.b2w.challenge.core.triangle.test;

import br.com.b2w.challenge.core.triangle.entity.Triangle;
import br.com.b2w.challenge.core.triangle.exception.InvalidFormatTriangleException;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by andre.oliveira on 19/07/2016.
 */

import static org.junit.Assert.*;

public class TriangleTest {

    @Test
    public void triangule_of_challenge() {
        Assert.assertEquals(26, new Triangle(new int[][]{{6}, {3, 5}, {9, 7, 1}, {4, 6, 8, 4}}).getMaximumTotalTopBottom());
        Assert.assertEquals(26, new Triangle(new int[][]{{6}, {3, 5}, {9, 7, 1}, {4, 6, 8, 4}}).getMaximumTotalBottomTopRecursive());
    }

    @Test
    public void triangule_of_challengeA() {
        Assert.assertEquals(26, new Triangle(new int[][]{{6}, {3, 5}, {9, 7, 1}, {4, 6, 8, 4}}).getMaximumTotalTopBottom());
        Assert.assertEquals(26, new Triangle(new int[][]{{6}, {3, 5}, {9, 7, 1}, {4, 6, 8, 4}}).getMaximumTotalBottomTopRecursive());
    }

    @Test
    public void triangule_of_minimum_size() {
        assertEquals(6, new Triangle(new int[][]{{6}}).getMaximumTotalTopBottom());
        assertEquals(6, new Triangle(new int[][]{{6}}).getMaximumTotalBottomTopRecursive());
    }

    @Test
    public void triangule_of_negative_numbers() {
        assertEquals(3, new Triangle(new int[][]{{6}, {-3, -5}}).getMaximumTotalTopBottom());
        assertEquals(3, new Triangle(new int[][]{{6}, {-3, -5}}).getMaximumTotalBottomTopRecursive());
    }

    @Test
    public void triangule_of_all_numbers_equals() {
        assertEquals(3, new Triangle(new int[][]{{1}, {1, 1}, {1, 1,1}}).getMaximumTotalTopBottom());
        assertEquals(3, new Triangle(new int[][]{{1}, {1, 1}, {1, 1,1}}).getMaximumTotalBottomTopRecursive());
    }

    @Test
    public void triangule_of_all_numbers_zero() {
        assertEquals(0, new Triangle(new int[][]{{0}, {0, 0}, {0, 0, 0}}).getMaximumTotalTopBottom());
        assertEquals(0, new Triangle(new int[][]{{0}, {0, 0}, {0, 0, 0}}).getMaximumTotalBottomTopRecursive());
    }

    @Test(expected = RuntimeException.class)
    public void triangle_with_null_array() {
        new Triangle(null).getMaximumTotalTopBottom();
        new Triangle(null).getMaximumTotalBottomTopRecursive();
    }

    @Test(expected = RuntimeException.class)
    public void triangle_with_empty_array() {
        new Triangle(new int[][]{}).getMaximumTotalTopBottom();
        new Triangle(new int[][]{}).getMaximumTotalBottomTopRecursive();
    }

    @Test(expected = InvalidFormatTriangleException.class)
    public void triangle_with_invalid_format_array() {
        new Triangle(new int[][]{{0}, {0}}).getMaximumTotalTopBottom();
        new Triangle(new int[][]{{0}, {0}}).getMaximumTotalBottomTopRecursive();
    }
}
