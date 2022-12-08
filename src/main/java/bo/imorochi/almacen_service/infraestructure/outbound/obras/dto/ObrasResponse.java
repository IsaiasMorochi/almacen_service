package bo.imorochi.almacen_service.infraestructure.outbound.obras.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ObrasResponse {
    private Integer idSolicitud;
    private String titulo;
    private String descripcion;
    private String estadoSolicitud; //PENDIENTE, ENTREGADO
    private String fechaSolicitud;
    private Integer idSolicitudAlmacen;
}
