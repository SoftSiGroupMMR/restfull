package dk.si.route;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.MessageProperties;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class Util {
    private ObjectMapper objectMapper = new ObjectMapper();

    public String rootToJson(Root root) throws JsonProcessingException {
        return objectMapper.writeValueAsString(root);
    }

    public Root rootFromJson(String jsonString) throws JsonProcessingException {
        Root root = objectMapper.readValue(jsonString, Root.class);
        return root;
    }

    public void sendToRoute(Route route, String root) throws IOException, TimeoutException {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("188.166.16.16");
        factory.setUsername("mmmrj1");
        factory.setPassword("mmmrj1");
        try (Connection connection = factory.newConnection();
             Channel channel = connection.createChannel()) {
            channel.queueDeclare(route.getTopic(), false, false, false, null);
            channel.basicPublish("", route.getTopic(), null, root.getBytes("UTF-8"));
        }

    }
}
