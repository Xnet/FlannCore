package net.dentzor.minecraft.core.item;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class ItemMisc extends Item {

    String local_name;

    public ItemMisc(String displayName, String texture, CreativeTabs creativetab) {
        setCreativeTab(creativetab);
        setTextureName(texture);
        setMaxStackSize(64);
        local_name = displayName;
    }

    @Override
    public String getItemStackDisplayName(ItemStack is) {
        return local_name;
    }
}
