package bo.imorochi.almacen_service.infraestructure.outbound;

import bo.imorochi.almacen_service.domain.model.AlmacenSolicitud;
import bo.imorochi.almacen_service.domain.repository.AlmacenSolicitudRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MongoAlmacenSolicitudRepository implements AlmacenSolicitudRepository {
    private final MongoAlmacenSolicitudFacade mongoAlmacenSolicitudFacade;

    public MongoAlmacenSolicitudRepository(MongoAlmacenSolicitudFacade mongoAlmacenSolicitudFacade) {
        this.mongoAlmacenSolicitudFacade = mongoAlmacenSolicitudFacade;
    }

    @Override
    public List<AlmacenSolicitud> findAll() {
        return mongoAlmacenSolicitudFacade.findAll();
    }

    @Override
    public AlmacenSolicitud save(AlmacenSolicitud almacenSolicitud) {
        return mongoAlmacenSolicitudFacade.save(almacenSolicitud);
    }
}
