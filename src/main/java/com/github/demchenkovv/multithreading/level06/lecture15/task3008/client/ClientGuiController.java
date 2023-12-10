package com.github.demchenkovv.multithreading.level06.lecture15.task3008.client;

public class ClientGuiController extends Client {
    private ClientGuiModel model = new ClientGuiModel();
    private ClientGuiView view = new ClientGuiView(this);

    public static void main(String[] args) {
        ClientGuiController cgc = new ClientGuiController();
        cgc.run();
    }

    public void run() {
        SocketThread socketThread = getSocketThread();
        // Нет необходимости запускать SocketThread в отдельном потоке (ответ в папке temp)
        socketThread.run();
    }

    @Override
    protected String getServerAddress() {
        return view.getServerAddress();
    }

    @Override
    protected int getServerPort() {
        return view.getServerPort();
    }

    @Override
    protected String getUserName() {
        return view.getUserName();
    }

    @Override
    protected void sendTextMessage(String text) {
        super.sendTextMessage(text);
    }

    @Override
    protected SocketThread getSocketThread() {
        return new GuiSocketThread();
    }

    public ClientGuiModel getModel() {
        return model;
    }

    /**
     * Inner class
     */
    public class GuiSocketThread extends SocketThread {

        @Override
        protected void processIncomingMessage(String message) {
            // вывести текст сообщения
            model.setNewMessage(message);
            view.refreshMessages();
        }

        @Override
        protected void informAboutAddingNewUser(String userName) {
            // вывести информацию о добавлении нового пользователя
            model.addUser(userName);
            view.refreshUsers();
        }

        @Override
        protected void informAboutDeletingNewUser(String userName) {
            // вывести актуальный список пользователей
            model.deleteUser(userName);
            view.refreshUsers();
        }

        @Override
        protected void notifyConnectionStatusChanged(boolean clientConnected) {
            view.notifyConnectionStatusChanged(clientConnected);
        }
    }
}
