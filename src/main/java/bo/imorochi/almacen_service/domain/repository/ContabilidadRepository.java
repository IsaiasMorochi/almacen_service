package bo.imorochi.almacen_service.domain.repository;

import bo.imorochi.almacen_service.domain.model.Solicitud;

public interface ContabilidadRepository {
    Integer comprobanteContable(Solicitud request);
}
