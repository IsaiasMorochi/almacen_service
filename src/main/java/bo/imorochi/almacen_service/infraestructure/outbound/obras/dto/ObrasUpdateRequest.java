package bo.imorochi.almacen_service.infraestructure.outbound.obras.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ObrasUpdateRequest {
    private Integer idSolicitud;
    private Integer idSolicitudAlmacen;
}
