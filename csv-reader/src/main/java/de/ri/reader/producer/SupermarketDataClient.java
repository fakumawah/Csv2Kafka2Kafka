package de.ri.reader.producer;

import de.ri.reader.model.SupermarketData;
import io.micronaut.configuration.kafka.annotation.KafkaClient;
import io.micronaut.configuration.kafka.annotation.KafkaKey;
import io.micronaut.configuration.kafka.annotation.Topic;
import io.micronaut.messaging.annotation.MessageBody;

@KafkaClient(id="supermarket-client")
public interface SupermarketDataClient {

    @Topic("voorraad")
    void sendSupermarketData(@KafkaKey String uuid, @MessageBody SupermarketData supermarketData);

    void sendSupermarketData(@Topic String topic, @KafkaKey String uuid, @MessageBody SupermarketData supermarketData);
}
