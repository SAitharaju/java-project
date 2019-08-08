// Calculate maximum product of a triplet in an array.
// Each element should be used only once.
// Assuming element range is from -5000 to 5000

import java.util.*;

class ProductOfTriplet {
    public int getMaxProduct(int[] array) {
        int firstPosMax = -5001;
        int secondPosMax = firstPosMax;
        int thirdPosMax = secondPosMax;

        int firstNegMax = 5001;
        int secondNegMax = firstNegMax;

        for (int i = 0; i < array.length; i++) {
            if (array[i] >= firstPosMax) {
                thirdPosMax = secondPosMax;
                secondPosMax = firstPosMax;
                firstPosMax = array[i];
            } else if (array[i] >= secondPosMax) {
                thirdPosMax = secondPosMax;
                secondPosMax = array[i];
            } else if (array[i] > thirdPosMax) {
                thirdPosMax = array[i];
            }
            if (array[i] <= 0) {
                if (array[i] <= firstNegMax) {
                    secondNegMax = firstNegMax;
                    firstNegMax = array[i];
                } else if (array[i] < secondNegMax) {
                    secondNegMax = array[i];
                }
            }
        }
        if (firstNegMax == 5001) firstNegMax = 0;

        int posResult = firstPosMax * secondPosMax * thirdPosMax;
        int negResult = firstNegMax * secondNegMax * firstPosMax;

        if (secondNegMax == 5001) return posResult;

        if (posResult > negResult) {
            return posResult;
        } else {
            return negResult;
        }
    }
}