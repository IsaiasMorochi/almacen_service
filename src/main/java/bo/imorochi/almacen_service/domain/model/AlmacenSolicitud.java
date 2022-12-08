package bo.imorochi.almacen_service.domain.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document("alm_solicitud")
public class AlmacenSolicitud {
    @Id
    private String id;

    private Integer idSolicitud;
    private String titulo;
    private String descripcion;
    private String estadoSolicitud; //PENDIENTE, ENTREGADO
    private String fechaSolicitud;
    private String procesoOrigen;
    private Integer idRegistroExterno;
}
