package ua.testing;

import ua.testing.controller.Controller;
import ua.testing.model.Calendar;
import ua.testing.model.Event;
import ua.testing.view.View;

import java.text.ParseException;


/**
 * Hello world!
 *
 */

public class App 
{
    public static void main( String[] args ) throws ParseException {
        Calendar calendar = new Calendar();
        View view = new View();
        Controller controller = new Controller(new Calendar(), view);
        controller.processUser();
    }
}
