// Coded by Flann

package mods.flann.src;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.ItemPickaxe;

public class Flann_ItemPickaxe extends ItemPickaxe{

	public String tex = "";
	
	
	public Flann_ItemPickaxe(int i, String t, EnumToolMaterial enumtoolmaterial) {
		super(i, enumtoolmaterial);
		tex = t;
		setCreativeTab(FlannModCore.flanntab);
	}
	
	@Override
	@SideOnly(Side.CLIENT) //Makes sure that only the client side can call this method
	public void registerIcons(IconRegister IR){
		this.itemIcon = IR.registerIcon(FlannModCore.modid + ":" + tex);
	}
	
}
