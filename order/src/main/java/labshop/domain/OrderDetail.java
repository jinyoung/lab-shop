package labshop.domain;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import org.springframework.beans.BeanUtils;

@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDetail {

    private String productId;

    private Long qty;

    private BigDecimal price;
}
