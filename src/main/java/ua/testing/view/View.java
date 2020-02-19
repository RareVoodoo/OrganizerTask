package ua.testing.view;

import ua.testing.model.Event;

import java.util.ArrayList;

public class View {

    public static final  String [] MAIN_MENU_MESSAGES= {
            " Sort by Event date", " Sort by importance"," exit"
    };
    public static final String  WRONG_INPUT_INT_DATA = "Your input is wrong. Enter again";


    public void printMessage(String message){
        System.out.println(message);
    }

    public void printEventList(ArrayList<Event> events){
        for (Event event:events){
            System.out.printf("%s | %s | Importance lvl: %s \n",
                    event.getEventDate(),
                    event.getEventName(),
                    event.getImportanceLevel());
        }
    }

    public void loadMainMenuWithMessages(String [] messages){
        for (int i = 0; i < messages.length; i++) {
            printMessage((i + 1) + messages[i]);
        }
    }
}
