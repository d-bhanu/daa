import java.util.Scanner;

class DataObject {
    int profit;
    int weight;
    double pw;
}

public class KnapsackDemo {

    DataObject d[];
    int max;
    int n, sum = 0;
    Scanner sc;

    public KnapsackDemo() {

        sc = new Scanner(System.in);
        System.out.println("Enter the number of objects");
        n = sc.nextInt();
        d = new DataObject[n];

        for (int i = 0; i < n; i++) {
            d[i] = new DataObject();
            System.out.println("Enter profit");
            d[i].profit = sc.nextInt();
            System.out.println("Enter weight");
            d[i].weight = sc.nextInt();
        }

        System.out.println("Enter the size of Knapsack");
        max = sc.nextInt();
    }

    public void Calculate() {
        for (int i = 0; i < n; i++) {
            d[i].pw = d[i].profit / (double) d[i].weight;
        }

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (d[i].pw < d[j].pw) {
                    DataObject temp = d[i];
                    d[i] = d[j];
                    d[j] = temp;
                }
            }
        }

        int k = 0;
        while (max > 0) {
            if (d[k].weight < max) {
                max = max - d[k].weight;
                sum = sum + d[k].profit;
            } else {
                sum = sum + max * (d[k].profit / d[k].weight);
                max = 0;
            }
            k++;
        }

        System.out.println("Maximum profit = " + sum);
    }

    public static void main(String args[]) {

        KnapsackDemo p = new KnapsackDemo();
        p.Calculate();
    }
}
