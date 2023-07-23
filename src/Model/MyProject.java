package Model;

import Controller.MessageCommunication;
import View.MainChatFrame;

import java.util.ArrayList;

public class MyProject {

    public static ArrayList<String> usernames = new ArrayList<>();
    public static String activeUser;


    public MyProject() {
        activeUser = "amir";
        usernames.add("amir");
        usernames.add("reza");
        usernames.add("ali");
        usernames.add("sina");
        usernames.add("hossein");
        String serverAddress = "127.0.0.1";
        int serverPort = 12345;
        String username = activeUser;

        Client client = new Client(serverAddress, serverPort, username);
//        client.startMessaging();
        MainChatFrame frame = new MainChatFrame();
        new MessageCommunication(client.getOutputStream(), client.getInputStream(), frame);
    }

}
