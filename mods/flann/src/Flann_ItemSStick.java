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

public class Flann_ItemSStick extends Item {
	
	public Icon t0;//Netherrack
	public Icon t1;//Redstone
	public Icon t2;//Obsidian
	public Icon t3;//Steel
	public String tex = "";
	
	public Flann_ItemSStick(int par1, String t) {
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
		this.t0 = IR.registerIcon(FlannModCore.modid + ":" + tex + "_1");
		this.t1 = IR.registerIcon(FlannModCore.modid + ":" + tex + "_2");
		this.t2 = IR.registerIcon(FlannModCore.modid + ":" + tex + "_3");
		this.t3 = IR.registerIcon(FlannModCore.modid + ":" + tex + "_4");
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public Icon getIconFromDamage(int i){
		switch(i){
		case 0:return t0;
		case 1:return t1;
		case 2:return t2;
		case 3:return t3;
		default:return iconIndex;
		}
	}
	
	@Override
	public String getItemDisplayName(ItemStack is){
		switch(is.getItemDamage()){
		case 0:return "Netherrack Paxelstick";
		case 1:return "Redstone Paxelstick";
		case 2:return "Obsidian Paxelstick";
		case 3:return "Steel Paxelstick";
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
