package labshop;

import labshop.config.kafka.KafkaProcessor;
import labshop.domain.Inventory;
import labshop.domain.InventoryRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
@EnableBinding(KafkaProcessor.class)
@EnableFeignClients
public class InventoryApplication {

    public static ApplicationContext applicationContext;


    public static void main(String[] args) {
        applicationContext =
            SpringApplication.run(InventoryApplication.class, args);

        // default stock is 10000 for productId 1
        
        Inventory inventory = new Inventory();
        inventory.setId(1L);
        inventory.setStock(10000L);

        Inventory.repository().save(inventory);
        
    }
}
