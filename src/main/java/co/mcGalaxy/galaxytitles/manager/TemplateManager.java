package co.mcGalaxy.galaxytitles.manager;

import co.mcGalaxy.galaxytitles.util.ConfigUtils;
import co.mcGalaxy.galaxytitles.util.Template;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.FileConfiguration;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TemplateManager {
    private static final Set<Template> templates = new HashSet<>();

    public static void loadTemplates() {
        templates.clear();

        FileConfiguration config = ConfigUtils.TEMPLATES.get();
        ConfigurationSection section = config.getConfigurationSection("");
        if (section == null) return;

        for (String id : section.getKeys(false)) {
            String name = config.getString(id + ".name");
            List<String> lore = config.getStringList(id + ".lore");
            String material = config.getString(id + ".material");
            boolean enchanted = config.getBoolean(id + ".enchanted");
            int customModelData = config.getInt(id + ".model_data");

            templates.add(new Template(id, name, lore, material, enchanted, customModelData));
        }
    }

    public static Template getTemplate(String name) {
        for (Template template : templates) {
            if (template.getId().equalsIgnoreCase(name)) return template;
        }

        return null;
    }
}
