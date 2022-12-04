package bo.imorochi.almacen_service.infraestructure.utils;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Collection;

@Data
@Builder
@JsonPropertyOrder({"status", "error", "errors", "message", "path", "timestamp"})
public class ErrorResponse implements Serializable {
    @JsonInclude(JsonInclude.Include.NON_NULL)
    final int status;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    final String error;
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    final Collection<Error> errors;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    final String message;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    final String path;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    final LocalDateTime timestamp;

}
