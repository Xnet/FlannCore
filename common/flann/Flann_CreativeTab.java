// Coded by Flann

package flann;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public class Flann_CreativeTab extends CreativeTabs{

	public Flann_CreativeTab(String label) {
		super(label);
	}
	
	@Override
	public ItemStack getIconItemStack() {
	    return new ItemStack(FlannModsCore.FRM,1,1);
	}
}
