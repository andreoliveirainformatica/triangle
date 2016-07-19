package br.com.b2w.challenge.test;

import br.com.b2w.challenge.entity.Triangle;
import br.com.b2w.challenge.exception.InvalidFormatTriangleException;
import org.junit.Test;

/**
 * Created by andre.oliveira on 19/07/2016.
 */
import java.security.InvalidAlgorithmParameterException;

import static org.junit.Assert.*;

public class TriangleTest {


    @Test
    public void triangule_of_challenge() {
        assertEquals(26, new Triangle(new int[][]{{6}, {3, 5}, {9, 7, 1}, {4, 6, 8, 4}}).getMaximumTotal());
    }

    @Test
    public void triangule_of_minimum_size() {
        assertEquals(6, new Triangle(new int[][]{{6}}).getMaximumTotal());
    }

    @Test
    public void triangule_of_negative_numbers() {
        assertEquals(3, new Triangle(new int[][]{{6}, {-3, -5}}).getMaximumTotal());
    }

    @Test(expected = RuntimeException.class)
    public void triangle_with_null_array() {
        new Triangle(null).getMaximumTotal();
    }

    @Test(expected = RuntimeException.class)
    public void triangle_with_empty_array() {
        new Triangle(new int[][]{}).getMaximumTotal();
    }

    @Test(expected = InvalidFormatTriangleException.class)
    public void triangle_with_invalid_format_array() {
        new Triangle(new int[][]{{0}, {0}}).getMaximumTotal();
    }
}
