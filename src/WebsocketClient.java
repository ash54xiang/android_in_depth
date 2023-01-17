package src;

import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import com.vic_project.vic_bv_01.MainActivity;

import java.net.URI;
import java.net.URISyntaxException;

import tech.gusavila92.websocketclient.WebSocketClient;

public class WebsocketClient {
    private WebSocketClient webSocketClient;
    private boolean isConnected; // use to connect WebSocket
    private MainActivity _mainActivity;

    private static WebsocketClient single_instance = null;

    private WebsocketClient() {
    }

    public static WebsocketClient getInstance() {
        if (single_instance == null)
            single_instance = new WebsocketClient();

        return single_instance;
    }

    public void SetActivity(AppCompatActivity activity) {
        _mainActivity = (MainActivity) activity;
    }

    public void CreateWebSocketClient(String address) {
        URI uri;
        try {
            uri = new URI(address);
        } catch (URISyntaxException e) {
            e.printStackTrace();
            return;
        }

        webSocketClient = new WebSocketClient(uri) {
            @Override
            public void onOpen() {
                isConnected = true;
                Log.i("WebSocket", "Session is onOpen");
                // webSocketClient.send("Hello World!");
                // CONNECT TO SERVER (BC?)
            }

            @Override
            public void onTextReceived(String s) {
                Log.i("WebSocket", "Message received");
                final String message = s;
                // SEND MESSAGE TO OR SHOULD DISPLAY AT WHERE?
                // PREPARED SendSocketDataToBC, ALLOWED BV->BC, I assume BC is server
            }

            @Override
            public void onBinaryReceived(byte[] data) {
                Log.i("WebSocket", "onBinaryReceived");
            }

            @Override
            public void onPingReceived(byte[] data) {
                Log.i("WebSocket", "onPingReceived");
            }

            @Override
            public void onPongReceived(byte[] data) {
                Log.i("WebSocket", "onPongReceived");
            }

            @Override
            public void onException(Exception e) {
                System.out.println(e.getMessage());
                webSocketClient.close();
            }

            @Override
            public void onCloseReceived() {
                Log.i("WebSocket", "Closed ");
            }
        };

        isConnected = false;
        webSocketClient.setConnectTimeout(10000);
        webSocketClient.setReadTimeout(60000);
    }

    //
    public void Connect() {
        try {
            webSocketClient.connect();
        } catch (IllegalStateException ex) {
            webSocketClient.close();
        } catch (Exception ex) {
            webSocketClient.close();
            ex.printStackTrace();
        }
    }

    public void CloseConnection() {
        webSocketClient.close();
    }

    public void SendPing() {
        byte[] payLoad = "Hello".getBytes();

        if (isConnected)
            webSocketClient.sendPing(payLoad);
    }

    public void SendSocketDataToBC(String socketData) {
        if (isConnected)
            webSocketClient.send(socketData);
    }
}
