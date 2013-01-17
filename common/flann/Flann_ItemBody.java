// Coded by Flann

package flann;

import java.util.List;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class Flann_ItemBody extends Item {
	
	
	
	public Flann_ItemBody(int par1) {
		super(par1);
		setTextureFile("/flann/paxels.png");
		setCreativeTab(FlannModsCore.flanntab);
		setHasSubtypes(true);
		setMaxDamage(0);
	}
	
	@SideOnly(Side.CLIENT)
	public int getIconFromDamage(int i){
		switch(i){
		case 0:return 96;
		case 1:return 97;
		case 2:return 98;
		case 3:return 99;
		case 4:return 100;
		default:return 255;
		}
	}
	
	@Override
	public String getItemNameIS(ItemStack is){
		switch(is.getItemDamage()){
		case 0:return "bodyWood";
		case 1:return "bodyStone";
		case 2:return "bodyIron";
		case 3:return "bodyDiamond";
		case 4:return "bodyGold";
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
