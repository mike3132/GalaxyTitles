package co.mcGalaxy.galaxytitles.manager;

import co.mcGalaxy.galaxytitles.GalaxyTitles;
import co.mcGalaxy.galaxytitles.util.ConfigUtils;
import co.mcGalaxy.galaxytitles.util.Status;
import co.mcGalaxy.galaxytitles.util.Template;
import co.mcGalaxy.galaxytitles.util.Tier;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.FileConfiguration;

import java.util.*;

public class TierManager {
    private static final List<Tier> tiers = new ArrayList<>();

    public static void loadTiers() {
        tiers.clear();

        FileConfiguration config = ConfigUtils.TIERS.get();
        ConfigurationSection section = config.getConfigurationSection("");
        if (section == null) return;

        for (String name : section.getKeys(false)) {
            String display = config.getString(name + ".display");
            List<String> lore = config.getStringList(name + ".lore");
            String material = config.getString(name + ".material");

            ConfigurationSection rawTemplates = config.getConfigurationSection(name + ".templates");
            if (rawTemplates == null) {
                GalaxyTitles.getInstance().getLogger().warning("Invalid templates for tier " + name);
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

            tiers.add(new Tier(name, display, templates, lore, material));
        }
    }

    public static List<Tier> getTiers() {
        return tiers;
    }

    public static Tier getTier(String name) {
        for (Tier tier : tiers) {
            if (tier.getName().equalsIgnoreCase(name)) return tier;
        }

        return null;
    }
}
