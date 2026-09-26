import java.math.BigInteger;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] cost = new int[n];
        for(int i=0;i<n;i++)
            cost[i]=sc.nextInt();

        int[][] m = new int[n+2][n+1];
        for (int i = 0;i<n+2;i++)
            for (int j = 0;j<n+1;j++)
                m[i][j]=999999;

        m[1][1]=cost[0];

        for (int j = 1;j<n;j++)
            for (int i = 1;i<n+1;i++)
            {
                if(cost[j-1]>100) {
                    if (m[i][j] != m[i + 1][j - 1]) {
                        m[i][j + 1] = Math.min(m[i][j], m[i][j + 1]);
                        m[i + 1][j + 1] = Math.min(m[i][j] + cost[j], m[i + 1][j + 1]);
                    } else {
                        if (i > 1)
                            m[i - 1][j + 1] = Math.min(m[i][j], m[i - 1][j + 1]);
                        m[i][j + 1] = Math.min(m[i][j] + cost[j], m[i][j + 1]);
                    }
                }
                else {
                    m[i][j+1]=Math.min(m[i][j]+cost[j],m[i][j+1]);
                    if (i > 1)
                        m[i-1][j+1]=Math.min(m[i][j],m[i-1][j+1]);
                }
            }




        int k1=-1;
        int min=999999;

        for(int i=1;i<n+2;i++)
            if(m[i][n]<=min) {
                min = m[i][n];
                k1 = i - 1;
            }

        System.out.println(min);


        boolean[] cu = new boolean[n];
        cu[0]=false;

        int pos=k1+1;
        for(int j=n;j>0;j--)
        {
            int a = m[pos][j]-m[pos-1][j-1];
            if(a==0)
            {
                cu[j-1]=true;
                pos--;
                continue;
            } else if (a==cost[j-1]) {
                cu[j-1]=false;
                pos--;
                continue;
            }


            int b = m[pos][j]-m[pos][j-1];
            if(b==0 && cost[j-1]<=100)
            {
                cu[j-1]=true;
                continue;
            } else if (b==cost[j-1]) {
                cu[j-1]=false;
                continue;
            }

            int c = m[pos][j]-m[pos+1][j-1];
            if(c==0)
            {
                cu[j-1]=true;
                pos++;
                continue;
            } else if (c==cost[j-1]) {
                cu[j-1]=false;
                pos++;
                continue;
            }

        }



        int total=0;
        for(int i=0;i<cu.length;i++)
        {
            if(cu[i])
                total++;
        }

        System.out.println((cost[n-1]>100 && cu[n-1]==false?1:0) + " " + (total));

        for(int i=0;i<cu.length;i++)
            if(cu[i])
                System.out.println(i+1);

        for(boolean i:cu)
            System.out.print(i + " ");

        for(int i=0;i<n+2;i++) {
            for (int j = 0; j < n + 1; j++) {
                System.out.printf("%-7s",(m[i][j] == 999999? "x" :m[i][j]));
            }
            System.out.println("\n");
        }



    }
}