package co.mcGalaxy.galaxytitles.manager;

import co.mcGalaxy.galaxytitles.command.command.BaseCommand;
import co.mcGalaxy.galaxytitles.command.command.TitleCommand;
import dev.rosewood.rosegarden.RosePlugin;
import dev.rosewood.rosegarden.command.framework.BaseRoseCommand;
import dev.rosewood.rosegarden.manager.AbstractCommandManager;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.function.Function;

public class CommandManager extends AbstractCommandManager {

    public CommandManager(RosePlugin rosePlugin) {
        super(rosePlugin);
    }

    @Override
    public @NotNull List<Function<RosePlugin, BaseRoseCommand>> getRootCommands() {
        return List.of(BaseCommand::new, TitleCommand::new);
    }

}
