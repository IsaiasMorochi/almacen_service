package bo.imorochi.almacen_service.infraestructure.outbound.contabilidad.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ComprobanteRequest {
    private String TipoComprobante;
    private String Estado;
    private String Glosa;
    private String ProcesoOrigen;
    private Integer IdRegistroExterno;
}
