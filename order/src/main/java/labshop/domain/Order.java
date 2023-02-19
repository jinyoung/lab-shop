package labshop.domain;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import labshop.OrderApplication;
import labshop.domain.OrderPlaced;
import labshop.external.Inventory;
import labshop.external.InventoryService;
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

    private BigDecimal amount;

    @ElementCollection
    private List<OrderDetail> details;

    private Status status;


    @PrePersist
    public void validateOrderInfoAndPublish() throws OutOfStock{
        /** Check Availability    */
        InventoryService inventoryService = applicationContext().getBean(InventoryService.class);
        
        Inventory inventory = 
            inventoryService.getStock( Long.valueOf(getProductId()) );

        if(inventory.getStock() < getQty()) throw new OutOfStock();

        /** Validate and Calculate the amount */
        if(getDetails()!=null){

            BigDecimal amount = 
                getDetails().stream()
                .map(x -> {if(x.getQty() == null ) throw new NoQuantity(); return x;} )
                .map(x -> {if(x.getProductId() == null ) throw new NoProductId(); return x;} )
                .map(x -> new BigDecimal(x.getQty()).multiply(x.getPrice()))    
                .reduce(BigDecimal.ZERO, BigDecimal::add);
            
            setAmount(amount);            
        }else{
            throw new NoDetails();
        }

        setStatus(Status.ORDERPLACED);

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
