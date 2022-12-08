package bo.imorochi.almacen_service.infraestructure.outbound.obras;

import bo.imorochi.almacen_service.application.utils.exception.ApplicationException;
import bo.imorochi.almacen_service.domain.model.AlmacenSolicitud;
import bo.imorochi.almacen_service.domain.repository.ObrasRepositoty;
import bo.imorochi.almacen_service.infraestructure.utils.configuration.ParamConfiguration;
import bo.imorochi.almacen_service.infraestructure.utils.enums.EndpointEnum;
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
public class ObrasConection implements ObrasRepositoty {

    private final RestTemplate restTemplate;

    @Autowired
    private ParamConfiguration paramConfiguration;

    public ObrasConection(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public Integer updatestate(AlmacenSolicitud request) {
        try {
            var headers = new HttpHeaders();
            headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
            headers.setContentType(MediaType.APPLICATION_JSON);

            HttpEntity<AlmacenSolicitud> bodyRequest = new HttpEntity<>(request, headers);
            String uri = this.paramConfiguration.getContabilidadServiceURL();

            ResponseEntity<AlmacenSolicitud> obrasState = restTemplate.postForEntity(uri, bodyRequest, AlmacenSolicitud.class);
            log.info("[ObrasConection][updatestate] comprobante: {}", obrasState);

            return obrasState.getBody().getIdSolicitud();

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
