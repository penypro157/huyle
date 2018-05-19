package spring.web.controller;

import javax.websocket.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

@ClientEndpoint
public class MyClientEndpoint {

    private Session session = null;

    public MyClientEndpoint() throws URISyntaxException, DeploymentException, IOException {
        URI uri = new URI("ws://localhost:8080/englishweb/server1");
        WebSocketContainer webSocketContainer=ContainerProvider.getWebSocketContainer();
        webSocketContainer.connectToServer(this,uri);
//       Session session =  ContainerProvider.getWebSocketContainer().connectToServer(this,uri);
    }

    @OnOpen
    public void handleOpen(Session session) {
        this.session = session;
        System.out.println("Connected to Server!");
    }

    @OnMessage
    public void handleMessage(String message) {
        System.out.println("Response from Server: " + message);
    }

    @OnClose
    public void handleClose() {
        System.out.println("Disconnected to Server!");
    }

    @OnError
    public void handleError(Throwable t) {
        t.printStackTrace();
    }

    public void sendMessage(String message) throws IOException {
        this.session.getBasicRemote().sendText(message);
    }

    public void disconnect() throws IOException {
        this.session.close();
    }

}
