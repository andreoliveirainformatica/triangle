package br.com.b2w.challenge.entity;

import br.com.b2w.challenge.validator.TriangleValidator;

import java.util.function.BiFunction;

/**
 * Created by andre.oliveira on 19/07/2016.
 */
public class Triangle {

    private int [][] array;

    public Triangle(int [][] array) {
        new TriangleValidator().validate(array);
        this.array = array;
    }

    public int getMaximumTotal() {
        int arraySum[][] = array.clone();
        for (int index = array.length-1; index > 0 ; index--)
        {
            arraySum[index-1] = sumWithNearestNextRow.apply(arraySum[index], arraySum[index-1]);
        }
        return  arraySum[0][0];
    }

    private BiFunction<int[], int[], int[]> sumWithNearestNextRow = (row, nextRow) -> {
        for (int index = 0; index < nextRow.length; index++) {
            nextRow[index] += Math.max(row[index],row[index + 1]);
        }
        return nextRow;
    };
}
