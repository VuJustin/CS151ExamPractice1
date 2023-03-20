package casinoroyale;

import mvc.Command;
import mvc.Model;

public class RollCommand extends Command {
    public RollCommand(Model model) {

        super(model);
    }
    @Override
    public void execute() throws Exception{
        Casino c = (Casino) model;
        c.roll();
    }
}
