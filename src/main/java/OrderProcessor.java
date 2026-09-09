import static java.lang.Math.random;

public class OrderProcessor implements Runnable{
// Интерфейс Runnable в Java используется для описания задачи,
// которая может выполняться в отдельном потоке.
    private final Order order;

    public OrderProcessor(Order order){
        this.order=order;
    }

    @Override
    public void run(){
        try {
            Thread.sleep(1000 + (int) (Math.random() * 1000));
        } catch (InterruptedException e) {
            System.out.println(e.toString());
        }
        System.out.printf("Поток %d обрабатывает заказ %d\n",Thread.currentThread().getId(),order.getId());
        order.setProcessed(true);
        System.out.printf("Заказ %d обработан\n",order.getId());
    }


}
