package labshop.external;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class InventoryServiceImpl implements InventoryService {

    public Inventory getStock(Long id) {
        Inventory inventory = new Inventory();

        return inventory;
    }
}
