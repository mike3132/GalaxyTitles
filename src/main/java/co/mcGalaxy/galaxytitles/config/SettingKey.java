package co.mcGalaxy.galaxytitles.config;

import co.mcGalaxy.galaxytitles.GalaxyTitles;
import dev.rosewood.rosegarden.config.CommentedConfigurationSection;
import dev.rosewood.rosegarden.config.RoseSetting;
import dev.rosewood.rosegarden.config.RoseSettingSerializer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static dev.rosewood.rosegarden.config.RoseSettingSerializers.STRING;

public class SettingKey {

    private static final List<RoseSetting<?>> KEYS = new ArrayList<>();

    private static <T> RoseSetting <T> create(String key, RoseSettingSerializer<T> serializer, T defaultValue, String... comments) {
        RoseSetting<T> setting = RoseSetting.backed(GalaxyTitles.getInstance(), key, serializer, defaultValue, comments);
        KEYS.add(setting);
        return setting;
    }

    public static final RoseSetting<String> MIKE_TEST_STRING = create("Title", STRING, "DefaultStringValue", "This should be a comment", "So should this");


    private static RoseSetting<CommentedConfigurationSection> create(String key, String... comments) {
        return RoseSetting.backedSection(GalaxyTitles.getInstance(), key, comments);
    }

    public static List<RoseSetting<?>> getKeys() {
        return Collections.unmodifiableList(KEYS);
    }

    private SettingKey() {

    }


}
