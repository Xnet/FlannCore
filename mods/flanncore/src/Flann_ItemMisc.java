// Coded by Flann

package mods.flanncore.src;

import java.util.List;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;

public class Flann_ItemMisc extends Item {
	
	public String tex, name;
	
	public Flann_ItemMisc(int id, String displayName, String texture){
		super(id);
		setCreativeTab(CreativeTabs.tabMaterials);
		tex = texture;
		name = displayName;
	}
	
	@Override
	public String getItemDisplayName(ItemStack is){
		return name;
	}
	
	@Override
	@SideOnly(Side.CLIENT) //Makes sure that only the client side can call this method
	public void registerIcons(IconRegister IR){
		this.itemIcon = IR.registerIcon(tex);
	}
}
