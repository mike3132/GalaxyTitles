package co.mcGalaxy.galaxytitles.util;

import co.mcGalaxy.galaxytitles.GalaxyTitles;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;
import java.util.Locale;

public enum ConfigUtils {

    TITLES,
    TEMPLATES,
    SHOP,
    TIERS;

    public File getFile() {
        return new File(GalaxyTitles.getInstance().getDataFolder(), this.toString().toLowerCase(Locale.ROOT) + ".yml");
    }

    public FileConfiguration get() {
        return YamlConfiguration.loadConfiguration(this.getFile());
    }

    public void create() {
        GalaxyTitles.getInstance().saveResource(this.getFile().getName(), false);
    }

    public void save(FileConfiguration config) {
        try {
            config.save(new File(GalaxyTitles.getInstance().getDataFolder(), this.toString().toLowerCase(Locale.ROOT) + ".yml"));
        }
        catch (IOException exception) {
            GalaxyTitles.getInstance().getLogger().warning("Failed to save config " + this.getFile().getName());
        }
    }



}
