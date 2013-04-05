// Coded by Flann

package mods.flann.src;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.IArmorTextureProvider;

public class Flann_ItemArmor extends ItemArmor implements IArmorTextureProvider{

	public String tex = "";
	
	public Flann_ItemArmor(int i, String t, EnumArmorMaterial enumarmormaterial, int j, int k) {
		super(i, enumarmormaterial, j, k);
		tex = t;
		setCreativeTab(FlannModCore.flanntab);
	}
	
	@Override
	@SideOnly(Side.CLIENT) //Makes sure that only the client side can call this method
	public void updateIcons(IconRegister IR){
		this.iconIndex = IR.registerIcon(FlannModCore.modid + ":" + tex);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public String getArmorTextureFile(ItemStack item) {
		
	// NETH
		if(item.itemID == FlannModCore.nethHelmet.itemID || item.itemID == FlannModCore.nethPlate.itemID || item.itemID == FlannModCore.nethBoots.itemID)
			return "/mods/" + FlannModCore.modid + "/textures/armor/neth_1.png";
		else if(item.itemID == FlannModCore.nethLegs.itemID)
			return "/mods/" + FlannModCore.modid + "/textures/armor/neth_2.png";
	// RED
		else if(item.itemID == FlannModCore.redHelmet.itemID || item.itemID == FlannModCore.redPlate.itemID || item.itemID == FlannModCore.redBoots.itemID)
			return "/mods/" + FlannModCore.modid + "/textures/armor/red_1.png";
		else if(item.itemID == FlannModCore.redLegs.itemID)
			return "/mods/" + FlannModCore.modid + "/textures/armor/red_2.png";
	// OBSID
		else if(item.itemID == FlannModCore.obsidHelmet.itemID || item.itemID == FlannModCore.obsidPlate.itemID || item.itemID == FlannModCore.obsidBoots.itemID)
			return "/mods/" + FlannModCore.modid + "/textures/armor/obsid_1.png";
		else if(item.itemID == FlannModCore.obsidLegs.itemID)
			return "/mods/" + FlannModCore.modid + "/textures/armor/obsid_2.png";
	// STEEL
		else if(item.itemID == FlannModCore.steelHelmet.itemID || item.itemID == FlannModCore.steelPlate.itemID || item.itemID == FlannModCore.steelBoots.itemID)
			return "/mods/" + FlannModCore.modid + "/textures/armor/steel_1.png";
		else if(item.itemID == FlannModCore.steelLegs.itemID)
			return "/mods/" + FlannModCore.modid + "/textures/armor/steel_2.png";
	// DEFAULT
		else
			return "/armor/gold_1.png";
	}
	
}
