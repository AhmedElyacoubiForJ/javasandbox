package javalabs;

import java.util.List;

public class AverageValue {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Double average = calculateAverage(numbers);
        System.out.println("Average: " + average);

        average = calculateAverageUsingStreamApi(numbers);
        System.out.println("Average Using Stream API: " + average);
    }

        private static Double calculateAverage(List<Integer> list) {
            int sum = 0;
            for (int number : list) {
                sum += number;
            }
            return (double) sum / list.size();
        }

    private static Double calculateAverageUsingStreamApi(List<Integer> list) {
        return list.stream()
                .mapToInt(Integer::intValue)
                .average()
                .orElse(0.0);
    }
}
