package labshop.domain;

import java.util.Date;
import java.util.List;
import javax.persistence.*;
import labshop.OrderApplication;
import labshop.domain.OrderPlaced;
import lombok.Data;
import org.springframework.context.ApplicationContext;

@Entity
@Table(name = "Order_table")
@Data
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String productId;

    private Integer qty;

    private String customerId;

    private Double amount;

    @ElementCollection
    private List<OrderDetail> details;

    @PostPersist
    public void onPostPersist() {
        /** TODO: Get request to Inventory
        labshop.external.GetStockQuery getStockQuery = new labshop.external.GetStockQuery();
        labshop.external.InventoryService inventoryService = applicationContext().getBean(labshop.external.InventoryService.class);
        labshop.external.Inventory inventory = 
            inventoryService.getStock( {TODO: please put the id} );
        */

        OrderPlaced orderPlaced = new OrderPlaced(this);
        orderPlaced.publishAfterCommit();
    }

    public static OrderRepository repository() {
        OrderRepository orderRepository = applicationContext()
            .getBean(OrderRepository.class);
        return orderRepository;
    }

    public static ApplicationContext applicationContext() {
        return OrderApplication.applicationContext;
    }
}
