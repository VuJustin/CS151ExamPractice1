package casinoroyale;

import mvc.AppFactory;
import mvc.Command;
import mvc.Model;
import mvc.View;

public class CasinoFactory implements AppFactory {
    public Model makeModel(){
        return new Casino();
    }
    public View makeView(Model m){
        return new CasinoView(m);
    }
    public String getTitle(){ return "Casino Program"; }
    public String[] getHelp(){
        return new String[] {"Roll - Click to roll 2 dice", "Roll a 7 to Win", "Roll a 3 to Lose"};
    }
    public String about(){return "Casino Royale";}
    public String[] getEditCommands(){
        return new String[] {"roll"};
    }
    public Command makeEditCommand(Model model, String type, Object source){
        if(type == "roll")
            return new RollCommand(model);
        return null;
    }
}
