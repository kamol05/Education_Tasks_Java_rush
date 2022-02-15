package com.javarush.task.task30.task3008;


import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.logging.Handler;

public class Server {
    private static Map<String,Connection> connectionMap = new ConcurrentHashMap<>();

    public static void main(String[] args) throws IOException {
        try(ServerSocket ss = new ServerSocket(ConsoleHelper.readInt()) ){
            ConsoleHelper.writeMessage("сервер запущен...");
            while (true){
                new Handler(ss.accept()).start(); }
        }catch (IOException e){ e.printStackTrace(); }

    }

    private static class Handler extends Thread{
        private Socket socket;
        public Handler(Socket socket){
            this.socket = socket;
        }

        private String serverHandshake(Connection connection) throws IOException, ClassNotFoundException {
            while (true) {
                connection.send(new Message(MessageType.NAME_REQUEST));
                Message message = connection.receive();
                if (message.getType() != MessageType.USER_NAME) {
                    ConsoleHelper.writeMessage("Получено сообщение от " + socket.getRemoteSocketAddress() + ". Тип сообщения не соответствует протоколу.");
                    continue;
                }
                String userName = message.getData();
                if (userName.isEmpty()) {
                    ConsoleHelper.writeMessage("Попытка подключения к серверу с пустым именем от " + socket.getRemoteSocketAddress());
                    continue; }
                if (connectionMap.containsKey(userName)) {
                    ConsoleHelper.writeMessage("Попытка подключения к серверу с уже используемым именем от " + socket.getRemoteSocketAddress());
                    continue;
                }
                connectionMap.put(userName, connection);
                connection.send(new Message(MessageType.NAME_ACCEPTED));
                return userName;
            }
        }

        private void notifyUsers(Connection connection, String userName) throws IOException {
            String cname = "";
            for (String s : connectionMap.keySet()){
                cname = s;
                if ( !cname.equals(userName)) {
                    connection.send(new Message(MessageType.USER_ADDED,cname));
                }
            }
        }

        private void serverMainLoop(Connection connection, String userName) throws IOException, ClassNotFoundException {
            while (true){
                Message message = connection.receive();
                String data = message.getData();

                if (message.getType() != MessageType.TEXT) { ConsoleHelper.writeMessage("Oshibka"); }

                if (message.getType() == MessageType.TEXT ){
                    String s = userName + ": " + data;
                    sendBroadcastMessage(new Message(MessageType.TEXT,s));
                }
            }
        }


        @Override
        public void run() {
            ConsoleHelper.writeMessage("Установлено новое соединение с " + socket.getRemoteSocketAddress());

            String userName = null;

            try (Connection connection = new Connection(socket)) {
                userName = serverHandshake(connection);

                // Сообщаем всем участникам, что присоединился новый участник
                sendBroadcastMessage(new Message(MessageType.USER_ADDED, userName));

                // Сообщаем новому участнику о существующих участниках
                notifyUsers(connection, userName);

                // Обрабатываем сообщения пользователей
                serverMainLoop(connection, userName);

            } catch (IOException | ClassNotFoundException e) {
                ConsoleHelper.writeMessage("Ошибка при обмене данными с " + socket.getRemoteSocketAddress());
            }

            if (userName != null) {
                connectionMap.remove(userName);
                sendBroadcastMessage(new Message(MessageType.USER_REMOVED, userName));
            }

            ConsoleHelper.writeMessage("Соединение с " + socket.getRemoteSocketAddress() + " закрыто.");
        }
    }


    public static void sendBroadcastMessage(Message message){
        
        for (Connection c : connectionMap.values()){
            try {
                c.send(message);
            } catch (IOException e) {
                System.out.println("сообшеные не доставлено");
            }
        }
    }


}
