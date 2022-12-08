package bo.imorochi.almacen_service.infraestructure.outbound.mongo;

import bo.imorochi.almacen_service.domain.model.AlmacenSolicitud;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface MongoAlmacenSolicitudFacade extends MongoRepository<AlmacenSolicitud, Integer> {
    @Query("{'idSolicitud' : :#{#idSolicitud}}")
    Optional<AlmacenSolicitud> findByIdSolicitud(@Param("idSolicitud") Integer idSolicito);

}
