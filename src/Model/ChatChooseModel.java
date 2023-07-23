package Model;

import View.ChatChooseButton;

import java.util.ArrayList;

public class ChatChooseModel {


    protected ArrayList<ChatChooseButton> chooseButtons = new ArrayList<>();


    public ArrayList<ChatChooseButton> getChooseButtons() {
        return chooseButtons;
    }

    public void setChooseButtons(ArrayList<ChatChooseButton> chooseButtons) {
        this.chooseButtons = chooseButtons;
    }
}
