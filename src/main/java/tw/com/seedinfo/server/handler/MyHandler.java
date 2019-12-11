package tw.com.seedinfo.server.handler;


import org.springframework.web.socket.*;

public class MyHandler implements WebSocketHandler {
    // 连接继开处理
    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus closeStatus) throws Exception {
        // TODO Auto-generated method stub

        System.out.println("Connection closed..." + session.getRemoteAddress().toString());

    }

    // 连接建立处理
    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        // TODO Auto-generated method stub
        System.out.println("Connection established..." + session.getRemoteAddress().toString());
    }

    // 接收、发送信息处理
    @Override
    public void handleMessage(WebSocketSession session, WebSocketMessage<?> socketMessage) throws Exception {
        // TODO Auto-generated method stub
        try {
            System.out.println("Req: " + socketMessage.getPayload());
            // 发送信息
            TextMessage returnMessage = new TextMessage(socketMessage.getPayload() + " received at server");
            session.sendMessage(returnMessage);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 错误处理（客户端突然关闭等接收到的错误）
    @Override
    public void handleTransportError(WebSocketSession session, Throwable exception) throws Exception {
        // TODO Auto-generated method stub
        if (session.isOpen()) {
            session.close();
        }
        System.out.println(exception.toString());
        System.out.println("WS connection error,close...");
    }

    @Override
    public boolean supportsPartialMessages() {
        // TODO Auto-generated method stub
        return false;
    }
}