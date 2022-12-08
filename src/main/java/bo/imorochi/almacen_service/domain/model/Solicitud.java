package bo.imorochi.almacen_service.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Solicitud {
    private Integer idSolicitud;
    private String titulo;
    private String descripcion;
    private String estadoSolicitud; //PENDIENTE, ENTREGADO
    private String fechaSolicitud;
    private String procesoOrigen;
    private Integer idRegistroExterno;
}
