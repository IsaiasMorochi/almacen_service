package bo.imorochi.almacen_service.application.service;

import bo.imorochi.almacen_service.application.dto.SolicitudRequest;
import bo.imorochi.almacen_service.application.dto.SolicitudResponse;
import bo.imorochi.almacen_service.application.utils.exception.ApplicationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class AlmacenSolicitudService {

    public SolicitudResponse actualizarSolicitud(SolicitudRequest request) {
        try {
            if (1 == 1)
                throw new ApplicationException("error: Solicit");
            return new SolicitudResponse();
        } catch (ApplicationException e) {
            throw new ApplicationException(e.getMessage());
        }
    }
}
