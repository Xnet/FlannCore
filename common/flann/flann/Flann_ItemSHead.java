// Coded by Flann

package flann.flann;

import java.util.List;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class Flann_ItemSHead extends Item {
	
	
	
	public Flann_ItemSHead(int par1) {
		super(par1);
		setTextureFile("/flann/flann/paxels.png");
		setCreativeTab(FlannModsCore.flanntab);
		setHasSubtypes(true);
		setMaxDamage(0);
	}
	
	@SideOnly(Side.CLIENT)
	public int getIconFromDamage(int i){
		switch(i){
		case 0:return 80;
		case 1:return 81;
		case 2:return 82;
		case 3:return 83;
		case 4:return 84;
		default:return 0;
		}
	}
	
	@Override
	public String getItemNameIS(ItemStack is){
		switch(is.getItemDamage()){
		case 0:return "sheadNeth";
		case 1:return "sheadRed";
		case 2:return "sheadObsid";
		case 3:return "sheadSteel";
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
