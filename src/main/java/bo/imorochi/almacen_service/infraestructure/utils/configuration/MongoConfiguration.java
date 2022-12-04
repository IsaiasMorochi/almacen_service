package bo.imorochi.almacen_service.infraestructure.utils.configuration;


import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration;
import org.springframework.lang.NonNull;

@Configuration
@Profile("!test")
public class MongoConfiguration extends AbstractMongoClientConfiguration {
    @Autowired
    private ParamConfiguration paramConfiguration;

    @Bean
    @Override
    @NonNull
    public MongoClient mongoClient() {

//        String configuration = "mongodb://" + paramConfiguration.getUserName() + ":" + paramConfiguration.getPassword() +
//                "@" + paramConfiguration.getHost() + ":" + paramConfiguration.getPort() +
//                "/" + paramConfiguration.getDatabase() +
//                "?connectTimeoutMS=" + paramConfiguration.getConnectionTimeoutMS() +
//                "&socketTimeoutMS=" + paramConfiguration.getSocketTimeoutMS() +
//                "&authSource=" + paramConfiguration.getAuthSource() +
//                "&w=" + paramConfiguration.getW() +
//                "&retryWrites=" + paramConfiguration.getRetryWrites();

        String configuration = "mongodb://localhost:27017";
        return MongoClients.create(configuration);
    }

    @Bean
    @Override
    @NonNull
    protected String getDatabaseName() {
        return paramConfiguration.getDatabase();
    }


}
