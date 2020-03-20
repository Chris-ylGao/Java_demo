package interview;

/**
 * FindDuplicate: check whether the number in the array contains duplicates.
 * the elements of this array are in the range of [0, n-1] (n is the length of array)
 */
public class FindDuplicate {
    public static boolean duplicate(int[] number){
        // if the array is null  or the length of array less than 1, then there is no duplicate.
        if (number == null || number.length <=1){
            return false;
        }
        /**
         * Transversing the array, if the element is equal to the index, then exchange the element with the number with index of element;
         */
        for (int i = 0 ; i< number.length; i++){
            // if the elements of array is out of range, return false;
            if (number[i] > number.length) return false;
            while(number[i] != i){
                if (number[number[i]] == number[i]) {
                    return true;
                }else{
                    int temp = number[number[i]];
                    number[number[i]] = number[i];
                    number[i] = temp;
                }
            }
        }
        return false;
    }


    public static void main(String[] args) {
        int[] number1 = {2,3,1,0,2,5,3};
        System.out.println(duplicate(number1)); // true
        int[] number2 = {1,2,4,5,3,0} ;
        System.out.println(duplicate(number2)); //false
        int[] number3 = {2,1,3,4,2,1};
        System.out.println(duplicate(number3)); // true
        int[] number4 = {20,1,3,4,2,1};
        System.out.println(duplicate(number4)); //false;
    }
}
