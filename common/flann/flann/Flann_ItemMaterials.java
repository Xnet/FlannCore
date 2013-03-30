// Coded by Flann

package flann.flann;

import java.util.List;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;

public class Flann_ItemMaterials extends Item {
	
	public Icon t0;//Smelted Iron
	public Icon t1;//Steel Ingot
	public Icon t2;//Steel Stick
	public Icon t3;//Redstone Ingot
	public String tex = "";
	
	public Flann_ItemMaterials(int par1, String t) {
		super(par1);
		setCreativeTab(FlannModsCore.flanntab);
		setHasSubtypes(true);
		setMaxDamage(0);
		tex = t;
	}
	
	@Override
	@SideOnly(Side.CLIENT) //Makes sure that only the client side can call this method
	public void updateIcons(IconRegister IR){
		this.iconIndex = IR.registerIcon(FlannModsCore.modid + ":" + tex + "_1");
		this.t0 = IR.registerIcon(FlannModsCore.modid + ":" + tex + "_1");
		this.t1 = IR.registerIcon(FlannModsCore.modid + ":" + tex + "_2");
		this.t2 = IR.registerIcon(FlannModsCore.modid + ":" + tex + "_3");
		this.t3 = IR.registerIcon(FlannModsCore.modid + ":" + tex + "_4");
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
