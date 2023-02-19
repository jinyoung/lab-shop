package labshop.domain;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.INSUFFICIENT_STORAGE, reason = "OutOfStock")
public class OutOfStock extends RuntimeException {

    public OutOfStock() {
        super("OutOfStock");
    }
}
