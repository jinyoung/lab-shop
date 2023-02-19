package labshop.external;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class InventoryServiceImpl implements InventoryService {

    @Override
    public void updateStock(Long id, UpdateStockCommand updateStockCommand) {
        // TODO Auto-generated method stub
        
    }

    public Inventory getStock(Long id) {
        Inventory inventory = new Inventory();

        return inventory;
    }
}
