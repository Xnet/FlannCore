// Coded by Flann

package mods.flann.src;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public class Flann_CreativeTab extends CreativeTabs{

	public Flann_CreativeTab(String label) {
		super(label);
	}
	
	@Override
	public ItemStack getIconItemStack() {
	    return new ItemStack(FlannModCore.FRM,1,1);
	}
}
