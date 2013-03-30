// Coded by Flann

package flann.flann;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class Flann_ItemStickCrafter extends Item{
	
	private String tex;
	
	public Flann_ItemStickCrafter(int par1, String t) {
		super(par1);
		tex=t;
		setCreativeTab(FlannModsCore.flanntab);
		setMaxStackSize(1);
		setContainerItem(this);
	}
	
	@Override
	public boolean doesContainerItemLeaveCraftingGrid(ItemStack par1ItemStack)
    {
        return false;
    }
	
	@Override
	@SideOnly(Side.CLIENT) //Makes sure that only the client side can call this method
	public void updateIcons(IconRegister IR){
		this.iconIndex = IR.registerIcon(FlannModsCore.modid + ":" + tex);
	}
}
