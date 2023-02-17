package labshop.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InventoryServiceImpl implements InventoryService{

    @Autowired
    InventoryRepository repository;

    public Inventory getStock(Long id){
        return repository.findById(id).get();
    }

    public void updateStock(
        Long id,
        UpdateStockCommand updateStockCommand
    ){
        repository.findById(id).ifPresent(inventory -> {
            inventory.updateStock(updateStockCommand);
        });

    }
}
