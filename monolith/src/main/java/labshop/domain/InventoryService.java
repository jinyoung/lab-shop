package labshop.domain;

public interface InventoryService {
    public Inventory getStock(Long id);

    public void updateStock(
        Long id,
        UpdateStockCommand updateStockCommand
    );
}
