package co.mcGalaxy.galaxytitles.manager;

import co.mcGalaxy.galaxytitles.menu.TitleMenu;
import dev.rosewood.rosegarden.RosePlugin;
import dev.rosewood.rosegarden.gui.RoseMenuWrapper;
import dev.rosewood.rosegarden.manager.AbstractGuiManager;

import java.util.List;
import java.util.function.Function;

public class GuiManager extends AbstractGuiManager {


    public GuiManager(RosePlugin rosePlugin) {
        super(rosePlugin);
    }

    @Override
    public List<Function<RosePlugin, RoseMenuWrapper>> getMenus() {
        return List.of(TitleMenu::new);
    }


}
