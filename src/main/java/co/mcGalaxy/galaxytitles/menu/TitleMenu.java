package co.mcGalaxy.galaxytitles.menu;

import dev.rosewood.rosegarden.RosePlugin;
import dev.rosewood.rosegarden.gui.RoseMenuWrapper;
import dev.rosewood.rosegarden.gui.action.Action;
import dev.rosewood.rosegarden.gui.action.type.MessageAction;
import dev.rosewood.rosegarden.gui.action.type.PlaySoundAction;
import dev.rosewood.rosegarden.gui.fill.type.OutlineFill;
import dev.rosewood.rosegarden.gui.item.RoseItem;
import dev.rosewood.rosegarden.gui.parameter.Context;
import dev.rosewood.rosegarden.gui.provider.Providers;
import dev.rosewood.rosegarden.gui.provider.animation.FlickerItemProvider;
import dev.rosewood.rosegarden.gui.provider.slot.MultiSlotProvider;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;

public class TitleMenu extends RoseMenuWrapper {

    public static final String MenuID = "Title-Menu";

    public TitleMenu(RosePlugin rosePlugin) {
        super(rosePlugin, MenuID);
    }

    @Override
    public void create() {
        this.addPage("&2Title Menu", 54, page -> {
            RoseItem borderItem = RoseItem.of(Material.BLACK_STAINED_GLASS_PANE);
            RoseItem stone = RoseItem.of(Material.STONE, "&fStone");
            RoseItem cobble = RoseItem.of(Material.COBBLESTONE, "&7Broken Stone");

            page.fill(OutlineFill.of(borderItem), borderItem);
            page.addIcon(23, new FlickerItemProvider(item -> stone, item -> cobble));


            page.addIcon(22, RoseItem.of(Material.DIAMOND, "&3Sparkly Diamond")
                    .setLore("&1Custom lore")
                    .addEnchantment(Enchantment.DENSITY, 1));

            page.on(Providers.ON_CLOSE, MessageAction.of("&3You closed the menu"));

        }, 10);
    }


}
