package co.mcGalaxy.galaxytitles.command.argument;

import co.mcGalaxy.galaxytitles.manager.GuiManager;
import dev.rosewood.rosegarden.RosePlugin;
import dev.rosewood.rosegarden.command.framework.Argument;
import dev.rosewood.rosegarden.command.framework.ArgumentHandler;
import dev.rosewood.rosegarden.command.framework.CommandContext;
import dev.rosewood.rosegarden.command.framework.InputIterator;

import java.util.ArrayList;
import java.util.List;

public class MenuArgumentHandler extends ArgumentHandler<String> {

    private final RosePlugin plugin;

    public MenuArgumentHandler(RosePlugin plugin) {
        super(String.class);
        this.plugin = plugin;
    }

    @Override
    public String handle(CommandContext commandContext, Argument argument, InputIterator inputIterator) throws HandledArgumentException {
        String input = inputIterator.next();

        if (!this.plugin.getManager(GuiManager.class).getActiveMenus().containsKey(input))
            throw new HandledArgumentException("gui-argument-handler-menu");

        return input.toLowerCase();
    }

    @Override
    public List<String> suggest(CommandContext commandContext, Argument argument, String[] strings) {
        return new ArrayList<>(this.plugin.getManager(GuiManager.class).getActiveMenus().keySet());
    }

}
