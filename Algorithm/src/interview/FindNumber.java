package interview;

/**
 * find specified number in two-dimensional array
 */
public class FindNumber {
    public static boolean contains(int[][] numbers, int num){
        int columns = numbers.length;
        int rows = numbers[0].length ;
        if (numbers == null || columns <=0 || rows <=0 || numbers[rows-1][columns -1] < num){
            return false;
        }
        int row = 0;
        int column = columns -1;
        // get the top right number, and compare it to the given number
        // remove column if the number is greater than given number
        while(row <= rows && column >=0){
            if (numbers[row][column] == num) {
                return true;
            }else if (numbers[row][column] < num) {
                row++;
            }else{
                column--;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] nums = {{1,2,8,9},{2,4,9,12},{4,7,10,13},{6,8,11,15}};

        for (int i = 0 ; i< nums.length; i++){
            System.out.println();
            for(int j = 0; j< nums[0].length ; j++){
                System.out.print(nums[i][j] + "    ");
            }
        }
        System.out.println();
        System.out.println(contains(nums,20));//false
        System.out.println(contains(nums,9));
        System.out.println(contains(nums,15));
        System.out.println(contains(nums,5));//false
        System.out.println(contains(nums,1));
        System.out.println(contains(nums,6));
    }
}
