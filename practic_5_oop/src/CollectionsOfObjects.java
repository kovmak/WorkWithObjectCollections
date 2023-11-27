import java.util.*;
import java.util.stream.Collectors;

public class CollectionsOfObjects {

    public static void main(String[] args) {
        List<Integer> dataSizes = Arrays.asList(50000, 500000, 1000000);

        // Тести для різних видів колекцій
        List<Collection<Integer>> collections = Arrays.asList(
                new ArrayList<>(),
                new LinkedList<>(),
                new HashSet<>(),
                new TreeSet<>(),
                new ArrayDeque<>(),
                new PriorityQueue<>(),
                new HashSet<>(),
                new LinkedHashSet<>()
        );

        for (Collection<Integer> collection : collections) {
            System.out.println("\nTesting Collection Type: " + collection.getClass().getSimpleName());

            // Виконання тестів для різних обсягів даних
            for (int dataSize : dataSizes) {
                System.out.println("\nData Size: " + dataSize);
                Collection(collection, dataSize);
            }
        }

        int[][] matrix1 = {{1, 0}, {0, 1}};
        int[][] matrix2 = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};

        int result1 = productOfMainDiagonal(matrix1);
        int result2 = productOfMainDiagonal(matrix2);

        System.out.println("Matrix 1 result: " + result1);
        System.out.println("Matrix 2 result: " + result2);
    }

    public static void Collection(Collection<Integer> collection, int dataSize) {
        // Заповнення колекції
        Random random = new Random();
        for (int i = 0; i < dataSize; i++) {
            collection.add(random.nextInt());
        }

        // Вимірювання часу для кожної операції
        long startTime, endTime, executionTime;

        // CRUD
        startTime = System.currentTimeMillis();
        collection.add(random.nextInt()); // Create
        collection.remove(random.nextInt()); // Delete
        collection.contains(random.nextInt()); // Read
        collection.removeIf(e -> e % 2 == 0); // Update
        endTime = System.currentTimeMillis();
        executionTime = endTime - startTime;
        System.out.println("CRUD Execution Time: " + executionTime + "ms");

        // Filter
        startTime = System.currentTimeMillis();
        List<Integer> filteredList = collection.stream()
                .filter(e -> e > 0)
                .collect(Collectors.toList());
        endTime = System.currentTimeMillis();
        executionTime = endTime - startTime;
        System.out.println("Filter Execution Time: " + executionTime + "ms");

        // Sort
        startTime = System.currentTimeMillis();
        List<Integer> sortedList = collection.stream()
                .sorted()
                .collect(Collectors.toList());
        endTime = System.currentTimeMillis();
        executionTime = endTime - startTime;
        System.out.println("Sort Execution Time: " + executionTime + "ms");

        // Find
        startTime = System.currentTimeMillis();
        Optional<Integer> foundItem = collection.stream()
                .filter(e -> e > 0)
                .findAny();
        endTime = System.currentTimeMillis();
        executionTime = endTime - startTime;
        System.out.println("Find Execution Time: " + executionTime + "ms");

        // Concat
        Collection<Integer> anotherCollection = new ArrayList<>();
        anotherCollection.add(random.nextInt());
        startTime = System.currentTimeMillis();
        Collection<Integer> concatenatedCollection = new ArrayList<>(collection);
        concatenatedCollection.addAll(anotherCollection);
        endTime = System.currentTimeMillis();
        executionTime = endTime - startTime;
        System.out.println("Concat Execution Time: " + executionTime + "ms");

        // Reduce
        startTime = System.currentTimeMillis();
        int sum = collection.stream()
                .reduce(0, Integer::sum);
        endTime = System.currentTimeMillis();
        executionTime = endTime - startTime;
        System.out.println("Reduce Execution Time: " + executionTime + "ms");

        // Match
        startTime = System.currentTimeMillis();
        boolean anyMatch = collection.stream()
                .anyMatch(e -> e > 0);
        endTime = System.currentTimeMillis();
        executionTime = endTime - startTime;
        System.out.println("Match Execution Time: " + executionTime + "ms");

        // Counting
        startTime = System.currentTimeMillis();
        long count = collection.stream()
                .count();
        endTime = System.currentTimeMillis();
        executionTime = endTime - startTime;
        System.out.println("Counting Execution Time: " + executionTime + "ms");

        // Sum
        startTime = System.currentTimeMillis();
        int sumResult = collection.stream()
                .mapToInt(Integer::intValue)
                .sum();
        endTime = System.currentTimeMillis();
        executionTime = endTime - startTime;
        System.out.println("Sum Execution Time: " + executionTime + "ms");

        // Average
        startTime = System.currentTimeMillis();
        OptionalDouble average = collection.stream()
                .mapToDouble(Integer::doubleValue)
                .average();
        endTime = System.currentTimeMillis();
        executionTime = endTime - startTime;
        System.out.println("Average Execution Time: " + executionTime + "ms");
    }

    public static int productOfMainDiagonal(int[][] matrix) {
        // Робить перевірку чи матриця квадратна
        if (matrix == null || matrix.length != matrix[0].length) {
            return -1;
        }

        int product = 1;
        for (int i = 0; i < matrix.length; i++) {
            product *= matrix[i][i];
        }

        return product;
    }
}
