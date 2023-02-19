package labshop.domain;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = "NoProductId")
public class NoProductId extends RuntimeException {

    public NoProductId() {
        super("NoProductId");
    }
}
