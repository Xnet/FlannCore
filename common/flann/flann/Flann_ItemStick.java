// Coded by Flann

package flann.flann;

import java.util.List;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class Flann_ItemStick extends Item {
	
	
	
	public Flann_ItemStick(int par1) {
		super(par1);
		setTextureFile("/flann/flann/paxels.png");
		setCreativeTab(FlannModsCore.flanntab);
		setHasSubtypes(true);
		setMaxDamage(0);
	}
	
	@SideOnly(Side.CLIENT)
	public int getIconFromDamage(int i){
		switch(i){
		case 0:return 32;
		case 1:return 33;
		case 2:return 34;
		case 3:return 35;
		case 4:return 36;
		default:return 255;
		}
	}
	
	@Override
	public String getItemNameIS(ItemStack is){
		switch(is.getItemDamage()){
		case 0:return "paxelStickWood";
		case 1:return "paxelStickStone";
		case 2:return "paxelStickIron";
		case 3:return "paxelStickDiamond";
		case 4:return "paxelStickGold";
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
