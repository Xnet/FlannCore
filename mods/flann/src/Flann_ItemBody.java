// Coded by Flann

package mods.flann.src;

import java.util.List;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;

public class Flann_ItemBody extends Item {
	
	public Icon tw;//Wood
	public Icon ts;//Stone
	public Icon ti;//Iron
	public Icon td;//Diamond
	public Icon tg;//Gold
	public String tex = "";
	
	public Flann_ItemBody(int par1, String t) {
		super(par1);
		setCreativeTab(FlannModCore.flanntab);
		setHasSubtypes(true);
		setMaxDamage(0);
		tex = t;
	}
	
	@Override
	@SideOnly(Side.CLIENT) //Makes sure that only the client side can call this method
	public void updateIcons(IconRegister IR){
		this.iconIndex = IR.registerIcon(FlannModCore.modid + ":" + tex + "_1");
		this.tw = IR.registerIcon(FlannModCore.modid + ":" + tex + "_1");
		this.ts = IR.registerIcon(FlannModCore.modid + ":" + tex + "_2");
		this.ti = IR.registerIcon(FlannModCore.modid + ":" + tex + "_3");
		this.td = IR.registerIcon(FlannModCore.modid + ":" + tex + "_4");
		this.tg = IR.registerIcon(FlannModCore.modid + ":" + tex + "_5");
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public Icon getIconFromDamage(int i){
		switch(i){
		case 0:return tw;
		case 1:return ts;
		case 2:return ti;
		case 3:return td;
		case 4:return tg;
		default:return iconIndex;
		}
	}
	
	@Override
	public String getItemDisplayName(ItemStack is){
		switch(is.getItemDamage()){
		case 0:return "Wooden Paxelbody";
		case 1:return "Stone Paxelbody";
		case 2:return "Iron Paxelbody";
		case 3:return "Diamond Paxelbody";
		case 4:return "Golden Paxelbody";
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
