// Coded by Flann

package flann.flann;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.IArmorTextureProvider;

public class Flann_ItemArmor extends ItemArmor implements IArmorTextureProvider{

	public int tex = 0;
	
	public Flann_ItemArmor(int i, int t, EnumArmorMaterial enumarmormaterial, int j, int k) {
		super(i, enumarmormaterial, j, k);
		tex = t;
		setCreativeTab(FlannModsCore.flanntab);
	}
	
	@SideOnly(Side.CLIENT) //Makes sure that only the client side can call this method
	public String getTextureFile(){ //Tells it what texture file to use
		return "/flann/flann/morearmor.png";
	}
	
	@SideOnly(Side.CLIENT)
	public int getIconFromDamage(int i){ //Tells it what texture index to use
		return tex;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public String getArmorTextureFile(ItemStack item) {
		
	// NETH
		if(item.itemID == FlannModsCore.nethHelmet.itemID || item.itemID == FlannModsCore.nethPlate.itemID || item.itemID == FlannModsCore.nethBoots.itemID)
			return "/flann/flann/armor/neth_1.png";
		else if(item.itemID == FlannModsCore.nethLegs.itemID)
			return "/flann/flann/armor/neth_2.png";
	// RED
		else if(item.itemID == FlannModsCore.redHelmet.itemID || item.itemID == FlannModsCore.redPlate.itemID || item.itemID == FlannModsCore.redBoots.itemID)
			return "/flann/flann/armor/red_1.png";
		else if(item.itemID == FlannModsCore.redLegs.itemID)
			return "/flann/flann/armor/red_2.png";
	// OBSID
		else if(item.itemID == FlannModsCore.obsidHelmet.itemID || item.itemID == FlannModsCore.obsidPlate.itemID || item.itemID == FlannModsCore.obsidBoots.itemID)
			return "/flann/flann/armor/obsid_1.png";
		else if(item.itemID == FlannModsCore.obsidLegs.itemID)
			return "/flann/flann/armor/obsid_2.png";
	// STEEL
		else if(item.itemID == FlannModsCore.steelHelmet.itemID || item.itemID == FlannModsCore.steelPlate.itemID || item.itemID == FlannModsCore.steelBoots.itemID)
			return "/flann/flann/armor/steel_1.png";
		else if(item.itemID == FlannModsCore.steelLegs.itemID)
			return "/flann/flann/armor/steel_2.png";
	// DEFAULT
		else
			return "/armor/gold_1.png";
	}
	
}
