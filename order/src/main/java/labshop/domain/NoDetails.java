package labshop.domain;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NO_CONTENT, reason = "NoDetails")
public class NoDetails extends RuntimeException {

    public NoDetails() {
        super("NoDetails");
    }
}
