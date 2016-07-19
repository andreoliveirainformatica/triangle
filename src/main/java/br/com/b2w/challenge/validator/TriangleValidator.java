package br.com.b2w.challenge.validator;

import br.com.b2w.challenge.exception.InvalidFormatTriangleException;

import java.security.InvalidAlgorithmParameterException;

/**
 * Created by andre.oliveira on 19/07/2016.
 */
public class TriangleValidator {

    public void validate(final int [][] array) {
        if (array == null || array.length == 0) {
            throw new RuntimeException("Array is empty or null");
        }

        for (int index = 0; index < array.length; index++) {
            if (array[index].length != index + 1){
                throw new InvalidFormatTriangleException("Invalid format of the array, must be in increasing order of elements!");
            }
        }
    }

}
