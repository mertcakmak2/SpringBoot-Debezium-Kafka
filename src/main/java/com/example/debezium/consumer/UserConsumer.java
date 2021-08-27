package com.example.debezium.consumer;

import com.example.debezium.model.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserConsumer {

    private final ObjectMapper mapper;

    @KafkaListener(topics = "dbserver1.db.user")
    public void consumeUser(ConsumerRecord<String, String> record) throws JsonProcessingException {
        String consumedValue = record.value();

        var jsonNode = mapper.readTree(consumedValue);
        JsonNode payload = jsonNode.path("payload");
        JsonNode after = payload.path("after");

        String userString = after.toString();
        User user = mapper.readValue(userString, User.class);
        System.out.println(user.toString());

    }
}
