package bo.imorochi.almacen_service.infraestructure.utils.configuration;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
public class ParamConfiguration {

    @Value("${connections.obras-service.url: Error loading obrasServiceURL from git file}")
    private String obrasServiceURL;

    @Value("${connections.contabilidad-service.url: Error loading contabilidadServiceURL from git file}")
    private String contabilidadServiceURL;

}
