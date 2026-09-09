import java.util.*;
import java.util.stream.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);

        OrderManager orderManager = new OrderManager();

        orderManager.submitOrder(new Order(0,"Продукт 1"));
        orderManager.submitOrder(new Order(1,"Продукт 2"));
        orderManager.submitOrder(new Order(2,"Продукт 3"));
        orderManager.submitOrder(new Order(3,"Продукт 4"));
        orderManager.submitOrder(new Order(4,"Продукт 5 "));

        orderManager.getProcessedCount();

        try {
            orderManager.waitForAll();
        } catch (InterruptedException e) {
            System.out.println(e.toString());
        }

        System.out.println(orderManager.getProcessedCount());

        System.out.println(Runtime.getRuntime().availableProcessors());
    }
}