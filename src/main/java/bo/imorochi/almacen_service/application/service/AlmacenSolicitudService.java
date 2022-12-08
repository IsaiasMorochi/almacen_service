package bo.imorochi.almacen_service.application.service;

import bo.imorochi.almacen_service.application.dto.SolicitudCreateRequest;
import bo.imorochi.almacen_service.application.dto.SolicitudResponse;
import bo.imorochi.almacen_service.application.dto.SolicitudUpdateRequest;
import bo.imorochi.almacen_service.application.utils.exception.ApplicationException;
import bo.imorochi.almacen_service.domain.model.AlmacenSolicitud;
import bo.imorochi.almacen_service.domain.model.Solicitud;
import bo.imorochi.almacen_service.domain.repository.AlmacenSolicitudRepository;
import bo.imorochi.almacen_service.domain.repository.ContabilidadRepository;
import bo.imorochi.almacen_service.domain.repository.ObrasRepositoty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Random;

@Slf4j
@Service
public class AlmacenSolicitudService {

    @Autowired
    private AlmacenSolicitudRepository almacenSolicitudRepository;

    @Autowired
    private ContabilidadRepository contabilidadRepository;

    @Autowired
    private ObrasRepositoty obrasRepositoty;

    public SolicitudResponse crearSolicitud(SolicitudCreateRequest request) {
        try {
            var solicitud = AlmacenSolicitud.builder()
                    .idSolicitud(new Random().nextInt(1000))
                    .titulo(request.getTitulo())
                    .descripcion(request.getDescripcion())
                    .estadoSolicitud(request.getEstadoSolicitud())
                    .fechaSolicitud(request.getFechaSolicitud())
                    .procesoOrigen(request.getProcesoOrigen())
                    .idRegistroExterno(request.getIdRegistroExterno())
                    .build();

            var solicitudAlmacen = almacenSolicitudRepository.save(solicitud);
            return new SolicitudResponse(solicitudAlmacen.getIdSolicitud());

        } catch (ApplicationException e) {
            throw new ApplicationException(e.getMessage());
        }
    }

    public Optional<Solicitud> deliveryOrder(SolicitudUpdateRequest request) {
        try {

            var solicitudAlmacen = almacenSolicitudRepository.findByIdSolicitud(request.getIdSolicitud());

            if (solicitudAlmacen.isEmpty())
                throw new ApplicationException("No se encontro un registro previamente registrado para la solicitud: " + request.getIdSolicitud());

            solicitudAlmacen.get().setEstadoSolicitud("ENTREGADO");
            almacenSolicitudRepository.save(solicitudAlmacen.get());

            var solicitDto = extractSolicitudDto(solicitudAlmacen.get());

            this.obrasRepositoty.updatestateObras(solicitDto);
            this.contabilidadRepository.comprobanteContable(solicitDto);

            return Optional.of(solicitDto);

        } catch (ApplicationException e) {
            throw new ApplicationException(e.getMessage());
        }
    }

    private Solicitud extractSolicitudDto(AlmacenSolicitud almacenSolicitud) {
        return Solicitud.builder()
                .idSolicitud(almacenSolicitud.getIdSolicitud())
                .titulo(almacenSolicitud.getTitulo())
                .descripcion(almacenSolicitud.getDescripcion())
                .estadoSolicitud(almacenSolicitud.getEstadoSolicitud())
                .fechaSolicitud(almacenSolicitud.getFechaSolicitud())
                .procesoOrigen(almacenSolicitud.getProcesoOrigen())
                .idRegistroExterno(almacenSolicitud.getIdRegistroExterno())
                .build();
    }

    public List<AlmacenSolicitud> findAll() {
        try {
            return this.almacenSolicitudRepository.findAll();
        } catch (ApplicationException e) {
            throw new ApplicationException(e.getMessage());
        }
    }

}
