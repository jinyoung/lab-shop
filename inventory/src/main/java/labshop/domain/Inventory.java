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

    public void decreaseStock(DecreaseStockCommand decreaseStockCommand) {
        setStock(getStock() - decreaseStockCommand.getQty());
    }
}
