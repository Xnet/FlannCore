// Coded by Flann

package mods.flann.src;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.ItemSword;

public class Flann_ItemSword extends ItemSword{

	public String tex = "";
	
	
	public Flann_ItemSword(int i, String t, EnumToolMaterial enumtoolmaterial) {
		super(i, enumtoolmaterial);
		tex = t;
		setCreativeTab(FlannModCore.flanntab);
	}
	
	@Override
	@SideOnly(Side.CLIENT) //Makes sure that only the client side can call this method
	public void updateIcons(IconRegister IR){
		this.iconIndex = IR.registerIcon(FlannModCore.modid + ":" + tex);
	}
	
}
