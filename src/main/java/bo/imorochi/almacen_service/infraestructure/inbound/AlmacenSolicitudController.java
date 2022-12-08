package bo.imorochi.almacen_service.infraestructure.inbound;

import bo.imorochi.almacen_service.application.dto.SolicitudCreateRequest;
import bo.imorochi.almacen_service.application.dto.SolicitudUpdateRequest;
import bo.imorochi.almacen_service.application.service.AlmacenSolicitudService;
import bo.imorochi.almacen_service.application.utils.exception.ApplicationException;
import bo.imorochi.almacen_service.infraestructure.utils.ErrorResponse;
import bo.imorochi.almacen_service.infraestructure.utils.Error;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;

@Validated
@RestController
@RequestMapping("/solicitud")
public class AlmacenSolicitudController {

    private final AlmacenSolicitudService service;

    public AlmacenSolicitudController(AlmacenSolicitudService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<?> crearSolicitud(@RequestBody SolicitudCreateRequest request) {
        try {
            var response = service.crearSolicitud(request);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (ApplicationException e) {
            var body = ErrorResponse.builder()
                    .errors(Collections.singleton(new Error(HttpStatus.BAD_REQUEST, e.getMessage())))
                    .build();
            return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            var body = ErrorResponse.builder()
                    .errors(Collections.singleton(new Error(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage())))
                    .build();
            return new ResponseEntity<>(body, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping
    public ResponseEntity<?> deliveryOrder(@RequestBody SolicitudUpdateRequest request) {
        try {
            var response = service.deliveryOrder(request);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (ApplicationException e) {
            var body = ErrorResponse.builder()
                    .errors(Collections.singleton(new Error(HttpStatus.BAD_REQUEST, e.getMessage())))
                    .build();
            return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            var body = ErrorResponse.builder()
                    .errors(Collections.singleton(new Error(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage())))
                    .build();
            return new ResponseEntity<>(body, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping
    public ResponseEntity<?> findAll() {
        try {
            var response = service.findAll();
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (ApplicationException e) {
            var body = ErrorResponse.builder()
                    .errors(Collections.singleton(new Error(HttpStatus.BAD_REQUEST, e.getMessage())))
                    .build();
            return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            var body = ErrorResponse.builder()
                    .errors(Collections.singleton(new Error(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage())))
                    .build();
            return new ResponseEntity<>(body, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
