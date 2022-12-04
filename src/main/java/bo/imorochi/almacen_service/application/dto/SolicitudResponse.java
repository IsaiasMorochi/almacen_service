package bo.imorochi.almacen_service.application.dto;

import bo.imorochi.almacen_service.domain.model.AlmacenSolicitud;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SolicitudResponse {
    private List<AlmacenSolicitud> solicitudList;
}
