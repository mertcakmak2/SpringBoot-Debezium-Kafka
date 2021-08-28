package com.example.debezium.mongoModel;

import com.example.debezium.model.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;

@Document(collection="users")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MongoUser {

    @Id
    private String id;

    private User user;

}
