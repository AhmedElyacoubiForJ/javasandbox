package javalabs;
/*
* Write a method that returns the index of the first occurrence
* of given integer in a list.
* Assume that the index of the first element in the list is zero.
* If the number does not exist return -1.
*
* */
public class LinearSearch {
    public static void main(String[] args) {
//        int[] arr = {1, 2, 3, 4, 5};
//        int number = 3;
//        int index = linearSearch(number, arr);
//        System.out.println("Element found at index: " + index);
//        if (index == -1) {
//            System.out.println("Element not found in array");
//        }

        testSearchPassWith4GivenLists();
        testSearchFailWith4GivenLists();
    }
    public static int linearSearch(int number, int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == number) {
                return i;
            }
        }
        return -1;
    }

    public static int search(Integer number, Integer[] list) {
        for (int i = 0; i < list.length; i++) {
            if (list[i].equals(number)) {
                return i;
            }
        }
        return -1;
    }

    public static void testSearchPassWith4GivenLists() {
        Integer[] list1 = {1, 2, 3, 4, 5};
        Integer[] list2 = {5, 4, 3, 2, 1};
        Integer[] list3 = {1, 2, 3, 4, 5, 5, 5};
        Integer[] list4 = {5, 5, 5, 5, 5};

        // test with asserts
        assert search(3, list1) == 2 : "Test failed for list1";
        assert search(3, list2) == 2 : "Test failed for list2";
        assert search(3, list3) == 2 : "Test failed for list3";
        assert search(3, list4) == -1 : "Test failed for list4";

        System.out.println("All tests passed successfully");
    }

    public static void testSearchFailWith4GivenLists() {
        Integer[] list1 = {1, 2, 3, 4, 5};
        Integer[] list2 = {5, 4, 3, 2, 1};
        Integer[] list3 = {1, 2, 3, 4, 5, 5, 5};
        Integer[] list4 = {5, 5, 5, 5, 5};

        // test with asserts
        assert search(6, list1) == -1 : "Test failed for list1";
        assert search(6, list2) == -1 : "Test failed for list2";
        assert search(6, list3) == -1 : "Test failed for list3";
        assert search(6, list4) == -1 : "Test failed for list4";

        System.out.println("All tests failed successfully");
    }
}
