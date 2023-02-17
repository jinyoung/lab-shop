package labshop.domain;

import java.util.Date;
import java.util.List;
import javax.persistence.*;
import labshop.InventoryApplication;
import lombok.Data;
import org.springframework.context.ApplicationContext;

@Entity
@Table(name = "Inventory_table")
@Data
public class Inventory {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Long stock;

    public static InventoryRepository repository() {
        InventoryRepository inventoryRepository = applicationContext()
            .getBean(InventoryRepository.class);
        return inventoryRepository;
    }

    public static ApplicationContext applicationContext() {
        return InventoryApplication.applicationContext;
    }

    public static void updateStock(OrderPlaced orderPlaced) {
        /** Example 1:  new item 
        Inventory inventory = new Inventory();
        repository().save(inventory);
        */

        /** Example 2:  finding and process
        
        repository().findById(orderPlaced.get???()).ifPresent(inventory->{
            
            inventory // do something
            repository().save(inventory);
         });
        */

    }
}
