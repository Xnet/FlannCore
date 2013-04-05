//coded by Flann

package mods.flann.src;

import java.util.Random;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;

public class Flann_BlockConcrete extends Block 
{
	protected Flann_BlockConcrete (int x)
	{		
		super (x, Material.rock);
		setCreativeTab(FlannModCore.flanntab);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister IR){
		this.blockIcon = IR.registerIcon(FlannModCore.modid + ":" + this.getUnlocalizedName2());
	}
	
	@Override
	public int idDropped(int par1, Random par2, int par3)
	{
		return FlannModCore.concrete.blockID;
	}

	@Override
	public int quantityDropped(Random rand)
	{
		return 1;
	}
}
