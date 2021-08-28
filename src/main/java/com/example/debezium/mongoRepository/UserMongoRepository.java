package com.example.debezium.mongoRepository;

import com.example.debezium.mongoModel.MongoUser;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMongoRepository extends MongoRepository<MongoUser, String> {
}
