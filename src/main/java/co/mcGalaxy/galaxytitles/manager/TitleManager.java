package co.mcGalaxy.galaxytitles.manager;

import co.mcGalaxy.galaxytitles.GalaxyTitles;
import co.mcGalaxy.galaxytitles.util.*;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.FileConfiguration;

import java.util.*;

public class TitleManager {
    private static final Set<Title> titles = new HashSet<>();

    public static Set<Title> getTags() {
        return titles;
    }

    public static void loadTitles() {
        titles.clear();

        FileConfiguration config = ConfigUtils.TITLES.get();
        ConfigurationSection section = config.getConfigurationSection("");
        if (section == null) return;

        for (String name : section.getKeys(false)) {
            String display = config.getString(name + ".display");
            Tier tier = TierManager.getTier(config.getString(name + ".tier"));

            if (tier == null) {
                GalaxyTitles.getInstance().getLogger().warning("Invalid tier for title " + name);
                continue;
            }

            List<String> lore = config.getStringList(name + ".lore");
            String material = config.getString(name + ".material");
            String permission = config.getString(name + ".permission");
            int cost = config.getInt(name + ".cost");

            ConfigurationSection rawTemplates = config.getConfigurationSection(name + ".templates");
            if (rawTemplates == null) {
                GalaxyTitles.getInstance().getLogger().warning("Invalid templates for title " + name);
                continue;
            }

            Map<Status, Template> templates = new HashMap<>();

            boolean failed = false;

            for (String path : rawTemplates.getKeys(false)) {
                Status status;
                Template template;

                try {
                    status = Status.valueOf(path.toUpperCase(Locale.ROOT));
                    template = TemplateManager.getTemplate(config.getString(name + ".templates." + path));
                    if (template == null) {
                        GalaxyTitles.getInstance().getLogger().warning("Invalid template for title " + name);
                        failed = true;
                        break;
                    }
                }
                catch (IllegalArgumentException exception) {
                    GalaxyTitles.getInstance().getLogger().warning("Invalid template for title " + name);
                    failed = true;
                    break;
                }

                templates.put(status, template);
            }

            if (failed) continue;

            titles.add(new Title(name, display, tier, permission, material, templates, lore, cost));
        }
    }

    public static Title getTitle(String name) {
        for (Title title : titles) {
            if (title.getName().equalsIgnoreCase(name)) return title;
        }
        return null;
    }
}

