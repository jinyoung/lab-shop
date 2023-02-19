package labshop.common;

import io.cucumber.spring.CucumberContextConfiguration;
import labshop.OrderApplication;
import org.springframework.boot.test.context.SpringBootTest;

@CucumberContextConfiguration
@SpringBootTest(classes = { OrderApplication.class })
public class CucumberSpingConfiguration {}
