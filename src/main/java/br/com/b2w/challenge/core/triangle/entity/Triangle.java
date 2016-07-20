package br.com.b2w.challenge.core.triangle.entity;

import br.com.b2w.challenge.core.triangle.validator.TriangleValidator;

import java.util.Arrays;
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


    public int getMaximumTotalTopBottom() {
        int arraySum[][] = array.clone();
        for (int index = 1; index < arraySum.length; index++)
        {
            arraySum[index] = sumWithNearestPreviewRow.apply(arraySum[index], arraySum[index-1]);
        }
        return Arrays.stream(arraySum[arraySum.length-1]).max().getAsInt();
    }

    private BiFunction<int[], int[], int[]> sumWithNearestPreviewRow = (row, previewRow) -> {
        for (int index = 0; index < row.length; index++) {
            if (index ==0 ) {
                row[index] += previewRow[index];
            } else
            if (index == row.length-1) {
                row[index] += previewRow[index-1];
            } else {
                row[index] += Math.max( previewRow[index-1], previewRow[index]);
            }
        }
        return row;
    };



    public int getMaximumTotalBottomTopRecursive() {
        return  sumElemementsWithNextRow(this.array.clone(), this.array.length-1);
    }

    private int sumElemementsWithNextRow(int[][] arraySum, Integer index) {
        if (index == 0) {
            return arraySum[0][0];
        }

        int[] row = arraySum[index];
        int[] nextRow = arraySum[index-1];

        for (int i = 0; i < nextRow.length; i++) {
            nextRow[i] += Math.max(row[i], row[i + 1]);
        }
        return sumElemementsWithNextRow(arraySum, index-1);

    }
}
