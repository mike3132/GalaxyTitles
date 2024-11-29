package co.mcGalaxy.galaxytitles.command.command;

import co.mcGalaxy.galaxytitles.manager.LocaleManager;
import dev.rosewood.rosegarden.RosePlugin;
import dev.rosewood.rosegarden.command.ReloadCommand;
import dev.rosewood.rosegarden.command.framework.ArgumentsDefinition;
import dev.rosewood.rosegarden.command.framework.BaseRoseCommand;
import dev.rosewood.rosegarden.command.framework.CommandContext;
import dev.rosewood.rosegarden.command.framework.CommandInfo;
import dev.rosewood.rosegarden.command.framework.annotation.RoseExecutable;
import dev.rosewood.rosegarden.utils.HexUtils;

public class BaseCommand extends BaseRoseCommand {

    public BaseCommand(RosePlugin rosePlugin) {
        super(rosePlugin);
    }

    LocaleManager localeManager = this.rosePlugin.getManager(LocaleManager.class);

    @Override
    protected CommandInfo createCommandInfo() {
        return CommandInfo.builder("GalaxyTitles")
                .descriptionKey("command-example-description")
                .permission("GalaxyTitles.Command")
                .aliases("GalaxyTitle", "galaxytitle", "galaxytitles")
                .playerOnly(false)
                .arguments(ArgumentsDefinition.builder().optionalSub(new ReloadCommand(this.rosePlugin)))
                .build();
    }

    @RoseExecutable
    public void execute(CommandContext context) {
        String message = HexUtils.colorify("&bWritten by &5Mike3132 &bfor mcGalaxy");

        context.getSender().sendMessage(localeManager.getLocaleMessage("prefix") + message);
    }

}