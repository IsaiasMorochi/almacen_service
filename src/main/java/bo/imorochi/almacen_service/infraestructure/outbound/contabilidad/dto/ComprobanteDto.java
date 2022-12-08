package bo.imorochi.almacen_service.infraestructure.outbound.contabilidad.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ComprobanteDto {
    private Integer idComprobante;
    private String tipoComprobante;
    private String estado;
    private String glosa;
    private String procesoOrigen;
    private Integer registroExterno;
}
