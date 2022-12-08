package bo.imorochi.almacen_service.application.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SolicitudCreateRequest {
    private String titulo;
    private String descripcion;
    private String estadoSolicitud;
    private String fechaSolicitud;
    private String procesoOrigen;
    private Integer idRegistroExterno;
}
