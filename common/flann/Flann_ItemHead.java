// Coded by Flann

package flann;

import java.util.List;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class Flann_ItemHead extends Item {
	
	
	
	public Flann_ItemHead(int par1) {
		super(par1);
		setTextureFile("/flann/paxels.png");
		setCreativeTab(FlannModsCore.flanntab);
		setHasSubtypes(true);
		setMaxDamage(0);
	}
	
	@SideOnly(Side.CLIENT)
	public int getIconFromDamage(int i){
		switch(i){
		case 0:return 64;
		case 1:return 65;
		case 2:return 66;
		case 3:return 67;
		case 4:return 68;
		default:return 255;
		}
	}
	
	@Override
	public String getItemNameIS(ItemStack is){
		switch(is.getItemDamage()){
		case 0:return "headWood";
		case 1:return "headStone";
		case 2:return "headIron";
		case 3:return "headDiamond";
		case 4:return "headGold";
		default:return "itemUnknown";
		}
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void getSubItems(int itemID, CreativeTabs tab,List itemList){
		for(int i=0;i<5;i++){
			itemList.add(new ItemStack(itemID,1,i));
		}
	}
	
}
