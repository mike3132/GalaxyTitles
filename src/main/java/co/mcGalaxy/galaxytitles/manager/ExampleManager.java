package co.mcGalaxy.galaxytitles.manager;

import dev.rosewood.rosegarden.RosePlugin;
import dev.rosewood.rosegarden.manager.Manager;

public class ExampleManager extends Manager {

    public ExampleManager(RosePlugin rosePlugin) {
        super(rosePlugin);
    }

    @Override
    public void reload() {
        // startup function :D
    }

    @Override
    public void disable() {
        // goodbye function :(
    }

}
