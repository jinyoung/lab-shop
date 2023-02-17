package labshop.domain;

import java.util.Date;
import java.util.List;
import javax.persistence.*;
import labshop.MonolithApplication;
import labshop.domain.OrderPlaced;
import labshop.external.Inventory;
import labshop.external.InventoryService;
import labshop.external.UpdateStockCommand;
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

    @PrePersist
    public void checkAvailabilityAndDecreaseStock() throws OutOfStock{
        /** TODO: Get request to Inventory        */
        InventoryService inventoryService = applicationContext().getBean(InventoryService.class);
        
        Inventory inventory = 
            inventoryService.getStock( Long.valueOf(getProductId()) );

        if(inventory.getStock() < getQty()) throw new OutOfStock();

        OrderPlaced orderPlaced = new OrderPlaced(this);
        orderPlaced.publishAfterCommit();
        /** TODO:  REST API Call to Inventory        */
        UpdateStockCommand updateStockCommand = new UpdateStockCommand();
        updateStockCommand.setQty(getQty().longValue());

        applicationContext().getBean(InventoryService.class)
           .updateStock(Long.valueOf(getProductId()), updateStockCommand);


    }



    public static OrderRepository repository() {
        OrderRepository orderRepository = applicationContext()
            .getBean(OrderRepository.class);
        return orderRepository;
    }

    public static ApplicationContext applicationContext() {
        return MonolithApplication.applicationContext;
    }
}
