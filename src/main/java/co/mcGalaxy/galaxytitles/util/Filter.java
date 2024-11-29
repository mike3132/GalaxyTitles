package co.mcGalaxy.galaxytitles.util;

import co.mcGalaxy.galaxytitles.GalaxyTitles;

import java.util.Locale;

public enum Filter {

    ALL,
    LOCKED,
    UNLOCKED;

    public String getDisplayName() {
        return GalaxyTitles.getInstance().getConfig().getString("filter." + this.toString().toLowerCase(Locale.ROOT) + ".display");
    }

    public String getMaterial() {
        return GalaxyTitles.getInstance().getConfig().getString("filter." + this.toString().toLowerCase(Locale.ROOT) + ".material");
    }


}
