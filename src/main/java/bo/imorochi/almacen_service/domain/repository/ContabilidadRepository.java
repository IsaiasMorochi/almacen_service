package bo.imorochi.almacen_service.domain.repository;

import bo.imorochi.almacen_service.domain.model.AlmacenSolicitud;
import bo.imorochi.almacen_service.infraestructure.outbound.contabilidad.dto.ComprobanteDto;

public interface ContabilidadRepository {
    ComprobanteDto comprobanteContable(AlmacenSolicitud request);
}
