package co.mcGalaxy.galaxytitles.util;

import co.mcGalaxy.galaxytitles.GalaxyTitles;
import co.mcGalaxy.galaxytitles.manager.PlaceholderManager;
import dev.rosewood.rosegarden.utils.HexUtils;
import me.clip.placeholderapi.PlaceholderAPI;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.List;
import java.util.Locale;

public class Template {
    private final String id;
    private final String name;
    private final List<String> lore;
    private final String material;
    private final boolean enchanted;
    private final int customModelData;

    public Template(String id, String name, List<String> lore, String material, boolean enchanted, int modelData) {
        this.id = id;
        this.name = name;
        this.lore = lore;
        this.material = material;
        this.enchanted = enchanted;
        this.customModelData = modelData;
    }

    public String getId() {
        return id;
    }

    public ItemStack buildItem(Player player, Title title) {
        String name = PlaceholderManager.parseTitlePlaceholders(player, title, this.name);
        String material = PlaceholderManager.parseTitlePlaceholders(player, title, this.material);
        List<String> lore = PlaceholderManager.parseTitlePlaceholders(player, title, this.lore);

        ItemStack item;

        try {
            item = new ItemStack(Material.valueOf(material.toUpperCase(Locale.ROOT)));
        } catch (IllegalArgumentException exception) {
            GalaxyTitles.getInstance().getLogger().warning("Invalid material at template " + this.id);
            item = new ItemStack(Material.STONE);
        }


        ItemMeta itemMeta = item.getItemMeta();
        if (itemMeta == null) return item;

        itemMeta.setDisplayName(name);
        itemMeta.setLore(lore);
        itemMeta.setCustomModelData(customModelData);
        if (this.enchanted) {
            itemMeta.addEnchant(Enchantment.POWER, 1, true);
            itemMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        }

        item.setItemMeta(itemMeta);

        return item;
    }

    public ItemStack buildItem(Player player, Tier tier) {
        String name = PlaceholderManager.parseTierPlaceholders(player, tier, this.name);
        String material = PlaceholderManager.parseTierPlaceholders(player, tier, this.material);
        List<String> lore = PlaceholderManager.parseTierPlaceholders(player, tier, this.lore);

        ItemStack item;

        try {
            item = new ItemStack(Material.valueOf(material.toUpperCase(Locale.ROOT)));
        } catch (IllegalArgumentException exception) {
            GalaxyTitles.getInstance().getLogger().warning("Invalid material at template " + this.id);
            item = new ItemStack(Material.STONE);
        }


        ItemMeta itemMeta = item.getItemMeta();
        if (itemMeta == null) return item;

        itemMeta.setDisplayName(name);
        itemMeta.setLore(lore);
        itemMeta.setCustomModelData(customModelData);
        if (this.enchanted) {
            itemMeta.addEnchant(Enchantment.POWER, 1, true);
            itemMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        }

        item.setItemMeta(itemMeta);

        return item;
    }

    public ItemStack buildItem(Player player) {
        String name = HexUtils.colorify(PlaceholderAPI.setPlaceholders(player, this.name));
        String material = HexUtils.colorify(PlaceholderAPI.setPlaceholders(player, this.material));
        List<String> lore = this.lore.stream().map(HexUtils::colorify).toList();


        ItemStack item;

        try {
            item = new ItemStack(Material.valueOf(material.toUpperCase(Locale.ROOT)));
        } catch (IllegalArgumentException exception) {
            GalaxyTitles.getInstance().getLogger().warning("Invalid material at template " + this.id);
            item = new ItemStack(Material.STONE);
        }

        ItemMeta itemMeta = item.getItemMeta();
        if (itemMeta == null) return item;

        itemMeta.setDisplayName(name);
        itemMeta.setLore(lore);
        itemMeta.setCustomModelData(customModelData);
        if (this.enchanted) {
            itemMeta.addEnchant(Enchantment.POWER, 1, true);
            itemMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        }

        item.setItemMeta(itemMeta);

        return item;
    }

    public ItemStack buildItem(Filter filter) {
        String name = PlaceholderManager.parseFilterPlaceholders(this.name, filter);
        String material = PlaceholderManager.parseFilterPlaceholders(this.material, filter);
        List<String> lore = PlaceholderManager.parseFilterPlaceholders(this.lore, filter);

        ItemStack item;

        try {
            item = new ItemStack(Material.valueOf(material.toUpperCase(Locale.ROOT)));
        } catch (IllegalArgumentException exception) {
            GalaxyTitles.getInstance().getLogger().warning("Invalid material at template " + this.id);
            item = new ItemStack(Material.STONE);
        }


        ItemMeta itemMeta = item.getItemMeta();
        if (itemMeta == null) return item;

        itemMeta.setDisplayName(name);
        itemMeta.setLore(lore);
        itemMeta.setCustomModelData(customModelData);
        if (this.enchanted) {
            itemMeta.addEnchant(Enchantment.POWER, 1, true);
            itemMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        }

        item.setItemMeta(itemMeta);

        return item;
    }
}
