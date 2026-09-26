import java.math.BigInteger;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] cost = new int[n];
        for (int i = 0; i < n; i++)
            cost[i] = sc.nextInt();

        int[][] m = new int[n + 1][n + 1];
        for (int i = 0; i < m.length; i++)
            for (int j = 0; j < m[i].length; j++)
                m[i][j] = 999999;

        m[0][0] = 0;

        for (int j = 0; j < m[0].length - 1; j++)
            for (int i = 0; i < m.length - 1; i++) {
                // платим
                m[i + (cost[j] > 100 ? 1 : 0)][j + 1] = Math.min(m[i + (cost[j] > 100 ? 1 : 0)][j + 1], m[i][j] + cost[j]);

                // купон
                if (i > 0)
                    m[i - 1][j + 1] = Math.min(m[i - 1][j + 1], m[i][j]);
            }

        int k1 = -1; // Неиспользованные
        int min = 999999;

        for (int i = 0; i < m.length; i++) {
            if (m[i][m[i].length-1] <= min) {
                min = m[i][m[i].length-1];
                k1 = i;
            }
        }

        int curentC = k1;
        boolean[] cu = new boolean[n];


        for (int j = n; j > 0; j--) {
            if (m[curentC][j] == m[curentC + 1][j - 1]) {
                cu[j - 1] = true;
                curentC++;
            } else
                curentC -= (cost[j - 1] > 100 ? 1 : 0);
        }

        // cu
//        for (boolean i : cu)
//            System.out.print(i + " ");
//        System.out.println();
//
//        // table
//        for (int i = 0; i < m.length; i++) {
//            for (int j = 0; j < m[i].length; j++) {
//                System.out.printf("%-7s", (m[i][j] == 999999 ? "x" : m[i][j]));
//            }
//            System.out.println("\n");
//        }

        int totalC=0;
        for(int i=0;i<n;i++){
            if(cost[i]>100 && !cu[i])
            {
                totalC++;
            }
        }






        System.out.println(min);
        System.out.println(k1+" "+(totalC-k1));
        for(int i=0;i<n;i++){
            if(cu[i])
                System.out.println(i+1);
        }
    }
}
