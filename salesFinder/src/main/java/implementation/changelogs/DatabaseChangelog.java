package implementation.changelogs;

import com.github.mongobee.changeset.ChangeLog;
import com.github.mongobee.changeset.ChangeSet;
import com.mongodb.BasicDBList;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

@ChangeLog
public class DatabaseChangelog {

    @ChangeSet(order = "001", id = "addUsersDB", author = "esemenciuc")
    public void usersDBConfig(MongoDatabase db) {
        db.createCollection("users");
        MongoCollection<Document> usersCollection = db.getCollection("users");
        BasicDBList dbl = new BasicDBList();
        dbl.add("ADMIN");
        Document doc = new Document("username", "admin").append("password", "admin").append("email", "admin@yahoo.com").append("roles", dbl);
        usersCollection.insertOne(doc);
    }

}
