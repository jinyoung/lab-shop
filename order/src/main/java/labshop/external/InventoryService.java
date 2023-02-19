package labshop.external;

import java.util.Date;
import java.util.List;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(
    name = "inventory",
    url = "${api.url.inventory}",
    fallback = InventoryServiceImpl.class
)
public interface InventoryService {
    @GetMapping(path = "/inventories/{id}")
    public Inventory getStock(@PathVariable("id") Long id);
}
