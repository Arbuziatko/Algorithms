import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.Vector;

/**
 * Created with IntelliJ IDEA.
 * User: user
 * Date: 25.01.13
 * Time: 08:12
 * To change this template use File | Settings | File Templates.
 */
public class knapsackProblem {

    private int maxCapacity;
    private int[] values;
    private int[] weights;
    private int[][] solutions;
    private int numberOfItems;

    public knapsackProblem() {

    }

    public static void main(String[] args) throws IOException {
        knapsackProblem solution = new knapsackProblem();
        solution.readFromFile("//source//");
        System.out.println(solution.knapsack());
    }

    public int knapsack() {
        for (int i = 1; i<=numberOfItems;i++) {
            for (int j =0;j<=maxCapacity;j++) {
                if (j >= weights[i]) {
                    solutions[i][j] = Math.max(solutions[i-1][j],solutions[i-1][j-weights[i]] + values[i]);
                } else {
                    solutions[i][j] = solutions[i-1][j];
                }
            }
        }
        return solutions[numberOfItems][maxCapacity];
    }

    public void readFromFile(String filename) throws IOException {
        BufferedReader in = new BufferedReader(new FileReader(filename));
        Scanner scanner = new Scanner(in);
        maxCapacity = scanner.nextInt();
        numberOfItems = scanner.nextInt();
        solutions = new int[numberOfItems+1][maxCapacity+1];
        values = new int[numberOfItems+1];
        weights = new int[numberOfItems+1];
        int i = 0;

        while (scanner.hasNextInt()) {
            int value = scanner.nextInt();
            int weight = scanner.nextInt();
            values[i] = value;
            weights[i] = weight;
            i++;
        }

        in.close();

    }



}
