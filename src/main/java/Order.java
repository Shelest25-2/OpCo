public class Order {
    private final int id;
    private final String product;
    // volatile - переменная читается и записывается напрямую из основной памяти
    private volatile boolean processed = false;

    public Order(int id, String product){
        this.id=id;
        this.product=product;
    }

    public int getId() {
        return id;
    }

    public String getProduct() {
        return product;
    }

    public boolean getProcessed(){
        return processed;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", product='" + product + '\'' +
                ", processed=" + processed +
                '}';
    }

    public void setProcessed(boolean processed) {
        this.processed = processed;
    }
    // id, product - final

}
