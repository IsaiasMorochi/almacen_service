package bo.imorochi.almacen_service.infraestructure.outbound.contabilidad;

import bo.imorochi.almacen_service.application.utils.exception.ApplicationException;
import bo.imorochi.almacen_service.domain.model.Solicitud;
import bo.imorochi.almacen_service.domain.repository.ContabilidadRepository;
import bo.imorochi.almacen_service.infraestructure.outbound.contabilidad.dto.ComprobanteDto;
import bo.imorochi.almacen_service.infraestructure.outbound.contabilidad.dto.ComprobanteRequest;
import bo.imorochi.almacen_service.infraestructure.utils.configuration.ParamConfiguration;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;

@Slf4j
@Component
public class ContabilidadConection implements ContabilidadRepository {

    private final RestTemplate restTemplate;
    @Autowired
    private ParamConfiguration paramConfiguration;

    public ContabilidadConection(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public Integer comprobanteContable(Solicitud solicitud) throws ApplicationException {
        try {
            var headers = new HttpHeaders();
            headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
            headers.setContentType(MediaType.APPLICATION_JSON);

            var request = ComprobanteRequest.builder()
                    .tipoComprobante("ADL").estado("DEFINITIVO")
                    .glosa("Asiento automático desde almacenes")
                    .procesoOrigen("ALM")
                    .idRegistroExterno(solicitud.getIdSolicitud())
                    .build();

            HttpEntity<ComprobanteRequest> bodyRequest = new HttpEntity<>(request, headers);
            String uri = paramConfiguration.getContabilidadServiceURL();

            ResponseEntity<ComprobanteDto> comprobante = restTemplate.postForEntity(uri, bodyRequest, ComprobanteDto.class);
            log.info("[ContabilidadConection][comprobanteContable] comprobante: {}", comprobante);

            return comprobante.getBody().getIdRegistroExterno();

        } catch (HttpClientErrorException | HttpServerErrorException e) {
            log.error("Error en la conexión con SERVICIO CONTABILIDAD");
            log.error("Status Code de respuesta: {}", e.getStatusCode().value());
            log.error(e.getMessage());
            throw new ApplicationException(e.getMessage());
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new ApplicationException(e.getMessage());
        }
    }
}
