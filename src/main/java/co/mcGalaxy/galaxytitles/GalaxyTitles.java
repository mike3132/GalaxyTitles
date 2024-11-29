package co.mcGalaxy.galaxytitles;

import co.mcGalaxy.galaxytitles.config.SettingKey;
import co.mcGalaxy.galaxytitles.manager.*;
import co.mcGalaxy.galaxytitles.util.ConfigUtils;
import dev.rosewood.rosegarden.RosePlugin;
import dev.rosewood.rosegarden.config.RoseSetting;
import dev.rosewood.rosegarden.manager.Manager;
import org.bukkit.NamespacedKey;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class GalaxyTitles extends RosePlugin {

    private static GalaxyTitles instance;
    private static NamespacedKey key;

    public static GalaxyTitles getInstance() {
        return instance;
    }


    public GalaxyTitles() {
        super(-1, -1,
                DataManager.class,
                LocaleManager.class,
                CommandManager.class,
                GuiManager.class);

        instance = this;
        key = new NamespacedKey(instance, "GalaxyTitle_Title");
    }

    @Override
    public void enable() {

        for (ConfigUtils configUtils : ConfigUtils.values()) {
            configUtils.create();
        }

        TemplateManager.loadTemplates();
        TierManager.loadTiers();
        TitleManager.loadTitles();

    }

    @Override
    public void disable() {

        key = null;
        instance = null;

    }

    @Override
    protected @NotNull List<Class<? extends Manager>> getManagerLoadPriority() {
        return List.of(ExampleManager.class);
    }

    @Override
    protected @NotNull List<RoseSetting<?>> getRoseConfigSettings() {
        return SettingKey.getKeys();
    }

    public static NamespacedKey getKey() {
        return key;
    }

}
