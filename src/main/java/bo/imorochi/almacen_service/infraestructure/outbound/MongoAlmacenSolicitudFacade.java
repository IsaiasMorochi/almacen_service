package bo.imorochi.almacen_service.infraestructure.outbound;

import bo.imorochi.almacen_service.domain.model.AlmacenSolicitud;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MongoAlmacenSolicitudFacade extends MongoRepository<AlmacenSolicitud, Integer> {
}
