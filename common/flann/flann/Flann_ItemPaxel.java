// Coded by Flann

package flann.flann;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemSpade;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTool;

public class Flann_ItemPaxel extends ItemPickaxe {
    
    public int tex = 0;
    
    protected Flann_ItemPaxel(int par1, int t, EnumToolMaterial par2EnumToolMaterial)
    {
        super(par1, par2EnumToolMaterial);
		tex = t;
		setCreativeTab(FlannModsCore.flanntab);
	}
	
    @Override
	@SideOnly(Side.CLIENT) //Makes sure that only the client side can call this method
	public String getTextureFile(){ //Tells it what texture file to use
		return "/flann/flann/paxels.png";
	}
    
	@Override
	@SideOnly(Side.CLIENT)
	public int getIconFromDamage(int i){ //Tells it what texture index to use
		return tex;
	}
	
	public boolean canHarvestBlock(Block par1Block)
    {
		if (par1Block == Block.snow || par1Block == Block.blockSnow)
			return par1Block == Block.snow ? true : par1Block == Block.blockSnow;
		else
			return super.canHarvestBlock(par1Block);
    }
	
	@Override
    public float getStrVsBlock(ItemStack par1ItemStack, Block par2Block)
    {
    	if(par2Block != null && (par2Block.blockMaterial == Material.wood || par2Block.blockMaterial == Material.vine || par2Block.blockMaterial == Material.plants))
    		return this.efficiencyOnProperMaterial;
    	else if(par2Block != null && (par2Block == Block.grass || par2Block == Block.dirt || par2Block == Block.sand || par2Block == Block.gravel || par2Block == Block.snow || par2Block == Block.blockSnow || par2Block == Block.blockClay || par2Block == Block.tilledField || par2Block == Block.slowSand || par2Block == Block.mycelium))
    		return this.efficiencyOnProperMaterial;
    	else if(par2Block != null && (par2Block == Block.planks || par2Block == Block.bookShelf || par2Block == Block.wood || par2Block == Block.chest || par2Block == Block.stoneDoubleSlab || par2Block == Block.stoneSingleSlab || par2Block == Block.pumpkin || par2Block == Block.pumpkinLantern))
    		return this.efficiencyOnProperMaterial;
    	else
    		return super.getStrVsBlock(par1ItemStack, par2Block);
    }
}
