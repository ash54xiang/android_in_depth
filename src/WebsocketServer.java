package src;

import javax.websocket.OnMessage;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint("/socket")
public class WebsocketServer {
    @OnMessage
    public String handleTextMessage(String message) {
        System.out.println("New Text Message Received");
        return message;
    }
}
