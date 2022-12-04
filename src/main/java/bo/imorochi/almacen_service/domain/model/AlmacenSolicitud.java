package bo.imorochi.almacen_service.domain.model;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document("alm_solicitud")
public class AlmacenSolicitud {
    private String idSolicitud;
    private String titulo;
    private String descripcion;
    private String estadoSolicitud; //PENDIENTE, ENTREGADO
    private String fechaSolicitud;
    private String idRegistroExterno;
    private String procesoOrigen;
}
