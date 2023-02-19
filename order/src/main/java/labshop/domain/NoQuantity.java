package labshop.domain;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = "NoQuantity")
public class NoQuantity extends RuntimeException {

    public NoQuantity() {
        super("NoQuantity");
    }
}
