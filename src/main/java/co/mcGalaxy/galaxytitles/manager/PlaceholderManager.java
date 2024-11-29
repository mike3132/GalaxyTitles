package co.mcGalaxy.galaxytitles.manager;

import co.mcGalaxy.galaxytitles.util.Filter;
import co.mcGalaxy.galaxytitles.util.Tier;
import co.mcGalaxy.galaxytitles.util.Title;
import dev.rosewood.rosegarden.utils.HexUtils;
import me.clip.placeholderapi.PlaceholderAPI;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class PlaceholderManager {

    public static String parseTitlePlaceholders(Player player, Title title, String string) {
        return HexUtils.colorify(PlaceholderAPI.setPlaceholders(player, string.replace("%title_name%", title.getName())
                .replace("%title_display%", title.getDisplay())
                .replace("%title_tier%", title.getTier().getDisplay())
                .replace("%title_tier_name%", title.getTier().getName())
                .replace("%title_permission%", title.getPermission())
                .replace("%title_material%", title.getMaterial())
                .replace("%title_cost%", String.valueOf(title.getCost()))));
    }

    public static List<String> parseTitlePlaceholders(Player player, Title title, List<String> lore) {
        List<String> newLore = new ArrayList<>();

        for (String line : lore) {
            if (line.equalsIgnoreCase("%title_lore%")) {
                for (String tagLine : title.getLore()) {
                    newLore.add(parseTitlePlaceholders(player, title, tagLine));
                }
                continue;
            }

            newLore.add(parseTitlePlaceholders(player, title, line));
        }

        return newLore;
    }

    public static String parseTierPlaceholders(Player player, Tier tier, String string) {
        return HexUtils.colorify(PlaceholderAPI.setPlaceholders(player, string.replace("%tier_name%", tier.getName())
                .replace("%tier_display%", tier.getDisplay())
                .replace("%tier_material%", tier.getMaterial())));
    }

    public static List<String> parseTierPlaceholders(Player player, Tier tier, List<String> lore) {
        List<String> newLore = new ArrayList<>();

        for (String line : lore) {
            if (line.equalsIgnoreCase("%tier_lore%")) {
                for (String tagLine : tier.getLore()) {
                    newLore.add(parseTierPlaceholders(player, tier, tagLine));
                }
                continue;
            }

            newLore.add(parseTierPlaceholders(player, tier, line));
        }

        return newLore;
    }

    public static String parsePagePlaceholder(String string, int page, int max) {
        return HexUtils.colorify(string.replace("%page%", String.valueOf(page)).replace("%max%", String.valueOf(max)));
    }

    public static String parseFilterPlaceholders(String string, Filter filter) {
        return HexUtils.colorify(string.replace("%filter_name%", filter.toString().toLowerCase(Locale.ROOT))
                .replace("%filter%", filter.getDisplayName())
                .replace("%filter_material%", filter.getMaterial()));
    }

    public static List<String> parseFilterPlaceholders(List<String> list, Filter filter) {
        List<String> newList = new ArrayList<>();

        for (String line : list) {
            newList.add(parseFilterPlaceholders(line, filter));
        }

        return newList;
    }
}