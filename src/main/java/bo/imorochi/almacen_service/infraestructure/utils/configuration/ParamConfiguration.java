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

    @Value("${mongo.username: Error loading from git file}")
    private String userName;
    @Value("${mongo.password: Error loading from git file}")
    private String password;
    @Value("${mongo.database: Error loading from git file}")
    private String database;
    @Value("${mongo.port: Error loading from git file}")
    private int port;
    @Value("${mongo.host: Error loading from git file}")
    private String host;
    @Value("${mongo.connectionTimeoutMS: Error loading from git file}")
    private int connectionTimeoutMS;
    @Value("${mongo.socketTimeoutMS: Error loading from git file}")
    private int socketTimeoutMS;
    @Value("${mongo.authSource: Error loading from git file}")
    private String authSource;
    @Value("${mongo.w: Error loading from git file}")
    private String w;
    @Value("${mongo.retryWrites: Error loading from git file}")
    private String retryWrites;

}
