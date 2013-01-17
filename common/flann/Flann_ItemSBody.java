// Coded by Flann

package flann;

import java.util.List;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class Flann_ItemSBody extends Item {
	
	public Flann_ItemSBody(int par1) {
		super(par1);
		setTextureFile("/flann/paxels.png");
		setCreativeTab(FlannModsCore.flanntab);
		setHasSubtypes(true);
		setMaxDamage(0);
	}
	
	@SideOnly(Side.CLIENT)
	public int getIconFromDamage(int i){
		switch(i){
		case 0:return 112;
		case 1:return 113;
		case 2:return 114;
		case 3:return 115;
		case 4:return 116;
		default:return 0;
		}
	}
	
	@Override
	public String getItemNameIS(ItemStack is){
		switch(is.getItemDamage()){
		case 0:return "sbodyNeth";
		case 1:return "sbodyRed";
		case 2:return "sbodyObsid";
		case 3:return "sbodySteel";
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
