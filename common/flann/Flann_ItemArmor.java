// Coded by Flann

package flann;

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
		return "/flann/morearmor.png";
	}
	
	@SideOnly(Side.CLIENT)
	public int getIconFromDamage(int i){ //Tells it what texture index to use
		return tex;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public String getArmorTextureFile(ItemStack item) {
		
	// NETH
		if(item.itemID == FlannModsCore.nethHelmet.shiftedIndex || item.itemID == FlannModsCore.nethPlate.shiftedIndex || item.itemID == FlannModsCore.nethBoots.shiftedIndex)
			return "/flann/armor/neth_1.png";
		else if(item.itemID == FlannModsCore.nethLegs.shiftedIndex)
			return "/flann/armor/neth_2.png";
	// RED
		else if(item.itemID == FlannModsCore.redHelmet.shiftedIndex || item.itemID == FlannModsCore.redPlate.shiftedIndex || item.itemID == FlannModsCore.redBoots.shiftedIndex)
			return "/flann/armor/red_1.png";
		else if(item.itemID == FlannModsCore.redLegs.shiftedIndex)
			return "/flann/armor/red_2.png";
	// OBSID
		else if(item.itemID == FlannModsCore.obsidHelmet.shiftedIndex || item.itemID == FlannModsCore.obsidPlate.shiftedIndex || item.itemID == FlannModsCore.obsidBoots.shiftedIndex)
			return "/flann/armor/obsid_1.png";
		else if(item.itemID == FlannModsCore.obsidLegs.shiftedIndex)
			return "/flann/armor/obsid_2.png";
	// STEEL
		else if(item.itemID == FlannModsCore.steelHelmet.shiftedIndex || item.itemID == FlannModsCore.steelPlate.shiftedIndex || item.itemID == FlannModsCore.steelBoots.shiftedIndex)
			return "/flann/armor/steel_1.png";
		else if(item.itemID == FlannModsCore.steelLegs.shiftedIndex)
			return "/flann/armor/steel_2.png";
	// DEFAULT
		else
			return "/armor/gold_1.png";
	}
	
}
