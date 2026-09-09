import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.*;

public class OrderManager {
    private final ExecutorService executor;
    private final List<Order> orders = Collections.synchronizedList(new ArrayList<>());

    public OrderManager(){
        executor = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
    }

    public void submitOrder(Order order){
        orders.add(order);
        executor.submit(new OrderProcessor(order));
        System.out.printf("Заказ %d принят в обработку\n",order.getId());
    }

    public void waitForAll() throws InterruptedException{
        executor.shutdown(); // Запрещаем новый задачи
        executor.awaitTermination(20,TimeUnit.SECONDS); // Ждем
    }

    public synchronized int getProcessedCount(){
        return (int) orders.stream().filter(o->o.getProcessed()==true).count();
    }



}
