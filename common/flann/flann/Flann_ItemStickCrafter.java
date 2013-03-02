// Coded by Flann

package flann.flann;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class Flann_ItemStickCrafter extends Item{
	
	private int tex;
	
	public Flann_ItemStickCrafter(int par1, int t) {
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
	@SideOnly(Side.CLIENT)
		public String getTextureFile(){
		return "/flann/flann/items.png";
	}

    @Override
	@SideOnly(Side.CLIENT)
		public int getIconFromDamage(int i){
		return tex;
	}
}
