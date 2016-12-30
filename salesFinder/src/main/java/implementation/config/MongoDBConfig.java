package implementation.config;

import com.github.mongobee.Mongobee;
import com.mongodb.Mongo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;


@Configuration
@EnableMongoRepositories(basePackages = "implementation.user.repository")
public class MongoDBConfig {

    private String getDatabaseName() {
        return "salesFinder";
    }

    @Bean
    public Mongobee mongobee() {
        // ToDo Move host and port in properties file.
        Mongobee runner = new Mongobee("mongodb://localhost:27017/" + getDatabaseName());
        runner.setDbName(getDatabaseName());
        runner.setChangeLogsScanPackage("implementation.changelogs");
        runner.setEnabled(true);

        return runner;
    }



    public @Bean Mongo mongo() {
        return new Mongo("localhost", 27017);
    }

    public @Bean MongoTemplate mongoTemplate() throws Exception {
        return new MongoTemplate(mongo(), getDatabaseName());
    }

}
