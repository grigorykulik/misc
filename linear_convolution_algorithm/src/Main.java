/**
 * My implementation of the linear convolution algorithm
 */

public class Main {
    public static void main(String[] args) {

        // arrays to be convoluted
        double[] arr={1, 2, 3, 4};
        double[] arr2={3, 2, 1};

        // convolution result
        var convolutedArray=conv(arr, arr2);

        for (var d:convolutedArray) {
            System.out.println(d);
        }
     }

    public static double[] conv(double[] a, double[] b) {

        // the resulting array length will be arr1+arr2-1
        int newLength=a.length+b.length-1;

        // create a new array
        var newA=new double[newLength];

        // fill the new array1 with zeroes
        for (int i=0; i<newLength-a.length; i++) {
            newA[i]=0;
        }

        // transfer array1 into the new array 1
        int j=0;
        for (int i=(newLength-a.length); i<newLength; i++) {
            newA[i]=a[j];
            j++;
        }


        // create a new array where the inverse array2 will be stored
        var bInv=new double[b.length];

        // invert array2
        int k=bInv.length-1;
        for (int i=0; i<b.length; i++) {
            bInv[i]=b[k];
            k--;
        }


        // this is the new array2 with zeros
        var newB=new double[newLength];

        // transfer values from the inverse array2 to the new array2
        j=0;
        for (int i=0; i<newLength-b.length; i++) {
            newB[i]=bInv[j];
            j++;
        }

        // fill the necessary positions in the new array2 with zeros
        for (int i=newLength-b.length; i<newLength; i++) {
            newB[i]=0;

        }

        // the resulting array
        var result=new double[newLength];

        // iterate through the elements of the resulting array
        for (int i=0; i<newLength; i++) {

            // each element of the resulting array is the sum of the products of corresponding elements of the new array1
            // and the array2
            double productSum=0;
            for (int m=0; m<newLength; m++) {
                productSum=productSum+(newA[m]*newB[m]);
            }

            result[i]=productSum;

            // shift the array2 to the right by one element
            newB=shift(newB);
        }

        return result;
    }

    // this method shifts an array to the right by one position
    public static double[] shift(double[] array) {
        var newArray=new double[array.length];

        newArray[0]=array[array.length-1];

        int j=0;
        for (int i=1; i<newArray.length; i++) {
            newArray[i]=array[j];
            j++;
        }

        return newArray;
    }
}
