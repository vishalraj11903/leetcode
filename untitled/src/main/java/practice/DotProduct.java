package practice;

public class DotProduct {
    static class ValueObject {
        int[] index;
        int[] values;
        ValueObject(int[] index, int[] values) {
            this.index = index;
            this.values = values;
        }
    }

    public static void main(String... args) {
        int[] index = new int[] {0, 1, 3};
        int[] values = new int[] { 2 , 4, 6};
        ValueObject vector1 = new ValueObject(index, values);

        index = new int[] {0, 1, 3};
        values = new int[] { 2 , 4, 6};
        ValueObject vector2 = new ValueObject(index, values);
        System.out.println(mutiply(vector1, vector2));
        System.out.println(variant(vector1, vector2));
    }

    private static int variant(ValueObject vector1, ValueObject vector2) {
        int product = 0;
        if (vector1.index.length < vector2.index.length) {
            for (int i = 0; i < vector1.index.length; ++i) {
                product += (vector1.values[i] * binarySearch(vector2, vector2.index[i]));
            }
        } else {
            for (int i = 0; i < vector2.index.length; ++i) {
                product += (vector2.values[i] * binarySearch(vector1, vector1.index[i]));
            }
        }

        return product;
    }

    static int binarySearch(ValueObject vector, int index) {
        int left = 0, right = vector.values.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (vector.index[mid] == index) {
                return vector.values[mid];
            } else if (vector.index[mid] < index) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return 0;
    }


    private static int mutiply(ValueObject vector1, ValueObject vector2) {
        int first = 0, second = 0;
        int product = 0;
        while (first < vector1.values.length && second < vector2.values.length) {
            if (vector1.index[first] == vector2.index[second]) {
                product += (vector1.values[first] * vector2.values[second]);
                first++;
                second++;
            } else if (vector1.index[first] < vector2.index[second]) {
                first++;
            } else {
                second++;
            }
        }

        return product;
    }


}
