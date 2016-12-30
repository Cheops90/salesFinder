package implementation.user.repository;

import implementation.user.dao.Client;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Component;

@Component
public interface ClientRepository extends MongoRepository<Client, String> {

    @Query("{ 'username' : ?0 }")
    Client getClientByUsername(String userName);

}
