package bo.imorochi.almacen_service.infraestructure.utils;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
@JsonPropertyOrder({"code", "field", "message", "timestamp"})
public class Error<C> {
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final C code;
    private final String message;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final String field;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final LocalDateTime timestamp;

    @JsonCreator
    public Error(@JsonProperty("code") C code, @JsonProperty("message") String message) {
        this(code, message, (String)null);
    }

    @JsonCreator
    public Error(@JsonProperty("code") C code, @JsonProperty("message") String message, @JsonProperty("field") String field) {
        this(code, message, field, (LocalDateTime)null);
    }
    @JsonCreator
    public Error(@JsonProperty("code") C code, @JsonProperty("message") String message, @JsonProperty("field") String field, @JsonProperty("timestamp") LocalDateTime timestamp) {
        this.code = code;
        this.message = message;
        this.field = field;
        this.timestamp = timestamp;
    }

}
