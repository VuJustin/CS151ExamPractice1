package casinoroyale;

import mvc.*;

public class RollCommand extends Command {
    public RollCommand(Model model){
        super(model);
    }
    @Override
    public void execute() throws Exception {
        Casino casino = (Casino) model;
        casino.roll();
    }
}
