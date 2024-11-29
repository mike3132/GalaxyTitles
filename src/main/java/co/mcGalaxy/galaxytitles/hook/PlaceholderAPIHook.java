package co.mcGalaxy.galaxytitles.hook;

import co.mcGalaxy.galaxytitles.GalaxyTitles;
import co.mcGalaxy.galaxytitles.manager.TitleManager;
import co.mcGalaxy.galaxytitles.util.Title;
import me.clip.placeholderapi.PlaceholderAPI;
import me.clip.placeholderapi.expansion.PlaceholderExpansion;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;
import org.jetbrains.annotations.NotNull;

public class PlaceholderAPIHook extends PlaceholderExpansion {


    @Override
    public @NotNull String getIdentifier() {
        return "galaxytitles";
    }

    @Override
    public @NotNull String getAuthor() {
        return "Mike3132";
    }

    @Override
    public @NotNull String getVersion() {
        return "1.0.0";
    }

    @Override
    public String onRequest(OfflinePlayer offlinePlayer, @NotNull String params) {
        Player player = offlinePlayer.getPlayer();
        if (player == null) return "";

        PersistentDataContainer container = player.getPersistentDataContainer();

        if (!container.has(GalaxyTitles.getKey(), PersistentDataType.STRING)) {
            return "";
        }

        Title title = TitleManager.getTitle(container.get(GalaxyTitles.getKey(), PersistentDataType.STRING));
        if (title == null) return "";

        if (params.equalsIgnoreCase("tag")) {
            String space = GalaxyTitles.getInstance().getConfig().getBoolean("include_space") ? " " : "";
            return PlaceholderAPI.setPlaceholders(offlinePlayer, title.getDisplay()) + space;
        }

        if (params.equalsIgnoreCase("title_name")) {
            return title.getName();
        }

        if (params.equalsIgnoreCase("title_tier")) {
            return title.getTier().getDisplay();
        }

        if (params.equalsIgnoreCase("title_tier_name")) {
            return title.getTier().getName();
        }

        return "";
    }
}

