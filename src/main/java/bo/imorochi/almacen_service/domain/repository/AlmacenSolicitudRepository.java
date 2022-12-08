package bo.imorochi.almacen_service.domain.repository;

import bo.imorochi.almacen_service.domain.model.AlmacenSolicitud;

import java.util.List;
import java.util.Optional;

public interface AlmacenSolicitudRepository {

    List<AlmacenSolicitud> findAll();
    AlmacenSolicitud save(AlmacenSolicitud almacenSolicitud);
    Optional<AlmacenSolicitud> findByIdSolicitud(Integer idSolicitud);
}
