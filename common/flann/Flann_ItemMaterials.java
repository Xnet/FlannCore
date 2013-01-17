// Coded by Flann

package flann;

import java.util.List;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class Flann_ItemMaterials extends Item {
	
	public Flann_ItemMaterials(int par1) {
		super(par1);
		setTextureFile("/flann/items.png");
		setCreativeTab(FlannModsCore.flanntab);
		setHasSubtypes(true);
		setMaxDamage(0);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public int getIconFromDamage(int i){
		switch(i){
		case 0:return 0;
		case 1:return 1;
		case 2:return 2;
		case 3:return 3;
		default:return 0;
		}
	}
	
	@Override
	public String getItemNameIS(ItemStack is){
		switch(is.getItemDamage()){
		case 0:return "smeltedIron";
		case 1:return "ingotSteel";
		case 2:return "stickSteel";
		case 3:return "ingotRedstone";
		default:return "itemUnknown";
		}
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void getSubItems(int itemID, CreativeTabs tab,List itemList){
		for(int i=0;i<4;i++){
			itemList.add(new ItemStack(itemID,1,i));
		}
	}
	
}
