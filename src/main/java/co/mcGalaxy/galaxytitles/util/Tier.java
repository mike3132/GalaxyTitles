package co.mcGalaxy.galaxytitles.util;

import java.util.List;
import java.util.Map;

public class Tier {
        private final String name;
        private final String display;
        private final Map<Status, Template> templates;
        private final List<String> lore;
        private final String material;

    public Tier(String name, String display, Map<Status, Template> templates, List<String> lore, String material) {
            this.name = name;
            this.display = display;
            this.templates = templates;
            this.lore = lore;
            this.material = material;
        }

        public String getName() {
            return name;
        }

        public String getDisplay() {
            return display;
        }

        public Map<Status, Template> getTemplates() {
            return templates;
        }

        public Template getTemplate(Status status){
            return templates.get(status);
        }

        public List<String> getLore() {
            return lore;
        }

        public String getMaterial() {
            return material;
        }
    }
