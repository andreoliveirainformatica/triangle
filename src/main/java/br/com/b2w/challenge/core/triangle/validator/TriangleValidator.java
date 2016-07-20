package br.com.b2w.challenge.core.triangle.validator;

import br.com.b2w.challenge.core.triangle.exception.InvalidFormatTriangleException;

/**
 * Created by andre.oliveira on 19/07/2016.
 */
public class TriangleValidator {

    public void validate(final int [][] array) {

        if (array == null) {
            throw new RuntimeException("array is not initialized");
        } else if (array.length < 1) {
            throw new RuntimeException("array is empty");
       }

        for (int index = 0; index < array.length; index++) {
            if (array[index].length != index + 1) {
                throw new InvalidFormatTriangleException("Invalid format of the array, must be in increasing order of elements!");
            }
        }
    }

}
