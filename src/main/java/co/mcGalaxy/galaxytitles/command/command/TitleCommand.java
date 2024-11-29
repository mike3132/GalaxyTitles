package co.mcGalaxy.galaxytitles.command.command;

import co.mcGalaxy.galaxytitles.command.argument.MenuArgumentHandler;
import co.mcGalaxy.galaxytitles.manager.GuiManager;
import dev.rosewood.rosegarden.RosePlugin;
import dev.rosewood.rosegarden.command.argument.ArgumentHandlers;
import dev.rosewood.rosegarden.command.framework.ArgumentsDefinition;
import dev.rosewood.rosegarden.command.framework.BaseRoseCommand;
import dev.rosewood.rosegarden.command.framework.CommandContext;
import dev.rosewood.rosegarden.command.framework.CommandInfo;
import dev.rosewood.rosegarden.command.framework.annotation.RoseExecutable;
import org.bukkit.entity.Player;

public class TitleCommand extends BaseRoseCommand {

    public TitleCommand(RosePlugin rosePlugin) {
        super(rosePlugin);
    }

    @Override
    protected CommandInfo createCommandInfo() {
        return CommandInfo.builder("Title")
                .permission("GalaxyTitles.Command.Title")
                .aliases("Titles", "titles")
                .playerOnly()
                .arguments(ArgumentsDefinition.builder()
                        .optional("page", ArgumentHandlers.INTEGER)
                        .build())
                .build();
    }

    @RoseExecutable
    public void execute(CommandContext context, String menu) {
        Player player = (Player) context.getSender();
        this.rosePlugin.getManager(GuiManager.class).open("Title-Menu", player);
    }

    @RoseExecutable
    public void execute(CommandContext context, String menu, Integer page) {
        Player player = (Player) context.getSender();
        this.rosePlugin.getManager(GuiManager.class).open(menu, player, page);
    }


}
