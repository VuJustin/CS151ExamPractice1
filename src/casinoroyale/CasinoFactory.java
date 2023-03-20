package casinoroyale;

import mvc.AppFactory;
import mvc.Command;
import mvc.Model;
import mvc.View;

import javax.xml.transform.Source;

public class CasinoFactory implements AppFactory {
    public Model makeModel(){
        return new Casino();
    }
    public View makeView(Model m){
        return new CasinoView(m);
    }
    public String getTitle(){
        return "Casino Royale";
    }
    public String[] getHelp(){
        return new String[] {"press roll to roll 2 dices", "Get 7 to Win"};
    }
    public String about(){
        return "casino problem";
    }
    public String[] getEditCommands(){
        return new String[] {"Roll"};
    }
    public Command makeEditCommand(Model model, String type, Object source){
        if(type == "Roll")
            return new RollCommand(model);
        return null;
    }
}
