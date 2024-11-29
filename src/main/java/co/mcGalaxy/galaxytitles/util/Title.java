package co.mcGalaxy.galaxytitles.util;

import co.mcGalaxy.galaxytitles.GalaxyTitles;
import org.bukkit.entity.Player;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;

import java.util.List;
import java.util.Map;
import java.util.Objects;

public class Title {
    private final String name;
    private final String display;
    private final Tier tier;
    private final String permission;
    private final String material;
    private final Map<Status, Template> templates;
    private final List<String> lore;
    private final int cost;

    public Title(String name, String display, Tier tier, String permission, String material, Map<Status, Template> templates, List<String> lore, int cost) {
        this.name = name;
        this.display = display;
        this.tier = tier;
        this.permission = permission;
        this.material = material;
        this.templates = templates;
        this.lore = lore;
        this.cost = cost;
    }

    public String getName() {
        return name;
    }

    public List<String> getLore() {
        return lore;
    }

    public String getDisplay() {
        return display;
    }

    public String getPermission() {
        return permission;
    }

    public Map<Status, Template> getTemplates() {
        return templates;
    }

    public String getMaterial() {
        return material;
    }

    public Tier getTier() {
        return tier;
    }

    public Status getStatus(Player player) {
        Status status = Status.LOCKED;

        if (player.hasPermission(this.permission))
            status = Status.UNLOCKED;

        PersistentDataContainer container = player.getPersistentDataContainer();
        if (!container.has(GalaxyTitles.getKey(), PersistentDataType.STRING)) return status;

        if (Objects.requireNonNull(container.get(GalaxyTitles.getKey(), PersistentDataType.STRING)).equalsIgnoreCase(this.name))
            status = Status.SELECTED;

        return status;
    }

    public Status getShopStatus(Player player) {
        Status status = Status.SHOP;

        if (player.hasPermission(this.permission))
            status = Status.SHOP_OWNED;

        return status;
    }

    public int getCost() {
        return cost;
    }
}
