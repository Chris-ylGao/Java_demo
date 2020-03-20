package interview;

public class FindDuplicate2 {
    /**
     * Create a new array
     *
     * @param number
     * @return
     */
    public static int duplicate(int[] number) {
        int[] newNumber = new int[number.length];
        for (int i : number) {
            if (i > newNumber.length || i == 0) return -1;
            if (newNumber[i] != 0) {
                return i;
            } else {
                newNumber[i] = i;
            }
        }
        return -1;
    }

    /**
     * don't use array
     *
     * @param number
     * @return the one of duplicate, if there is no duplicate,then return -1
     */
    public static int duplicate2(int[] number) {
        if (number == null) return -1;
        int start = 0;
        int end = number.length - 1;
        int middle;
        while (start <= end) {
            middle = (end - start) / 2 + start;
            int count = count(number, start, middle);
            if (start == end) {
                if (count > 1) {
                    return start;
                } else {
                    break;
                }
            }
            if (count > (middle - start) + 1) {
                // there is duplicate in the range of [start, middle]
                end = middle;
            } else {
                start = middle + 1;
            }
        }
        return -1;
    }

    public static int count(int[] number, int start, int end) {
        int count = 0;
        for (int i : number) {
            // count the number of appearance of number in  the range of [start, end]
            if (i >= start && i <= end) count++;
        }
        return count;
    }

    public static void main(String[] args) {
        int[] number1 = {2, 3, 1, 4, 5, 3};//3
        System.out.println(duplicate(number1)); // 2
        int[] number2 = {1, 2, 4, 5, 3, 0};
        System.out.println(duplicate(number2)); // -1
        int[] number3 = {3, 1, 3, 4, 2, 1};
        System.out.println(duplicate(number3)); // 3
        int[] number4 = {20, 1, 3, 4, 2, 1};
        System.out.println(duplicate(number4)); // -1

        System.out.println("----------------------");
        System.out.println(duplicate2(number1)); // 2
        System.out.println(duplicate2(number2)); // -1
        System.out.println(duplicate2(number3)); // 3
        System.out.println(duplicate2(number4)); // -1
    }
}
