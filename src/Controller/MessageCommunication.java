package Controller;

import Model.Message;
import View.ChatChooseButton;
import View.ChatScreen;
import View.MainChatFrame;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;

public class MessageCommunication {

    protected ObjectOutputStream outputStream;
    protected ObjectInputStream inputStream;
    protected MainChatFrame frame;

    public MessageCommunication(ObjectOutputStream out, ObjectInputStream in, MainChatFrame frame) {
        this.outputStream = out;
        this.inputStream = in;
        this.frame = frame;
        frame.messageField.addActionListener(e -> sendMessage());
        receiveMessage();
    }

    private void sendMessage() {

        String messageText = frame.messageField.getText().trim();
        if (!messageText.isEmpty()) {

            Message newMessage = new Message(frame.getActiveChatScreen().getModel().getMyUsername(), frame.getActiveChatScreen().getModel().getOtherUsername(), messageText);
            try {
                outputStream.writeObject(newMessage);
                outputStream.flush();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            // Scroll down to show the latest message
            frame.getActiveChatScreen().scrollDown();

            // Clear the chatArea after sending the message
            frame.messageField.setText("");

            frame.getActiveChatScreen().addUserMessage(messageText);
            ChatChooseButton button = findButton(newMessage.getReceiver());
            frame.getModel().moveButtonToTop(frame, button);

        }
    }

    private void receiveMessage() {

        Thread receiveThread = new Thread(() -> {
            try {
                // ToDo: Change While True.
                while (true) {
                    Message message = (Message) inputStream.readObject();
                    getChatScreen(message).addOtherMessage(message.getMessage());
                    ChatChooseButton button = findButton(message.getSender());
                    frame.getModel().moveButtonToTop(frame, button);
                }
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        });
        receiveThread.start();

    }

    private ChatChooseButton findButton(String username) {
        for (ChatChooseButton button : frame.getButtons()) {
            if (button.getChatScreen().getModel().getMyUsername().equals(username)
                    || button.getChatScreen().getModel().getOtherUsername().equals(username)) {
                return button;
            }
        }
        return null;
    }

    private ChatScreen getChatScreen(Message message) {
        return frame.getChatScreens().get(message.getSender());
    }


}
