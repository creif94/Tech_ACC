import java.time.LocalDateTime;
import java.time.*;

public class Order {
    private String orderNumber;
    private String name;
    private LocalDateTime createdDate;

    public Order(String name, String  order_Number){
        this.orderNumber = String.valueOf(order_Number);
        this.name = name;
        this.createdDate = LocalDateTime.now();
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public String getName() {
        return name;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }
}
