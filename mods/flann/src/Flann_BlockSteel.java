// Coded by Flann

package mods.flann.src;

import java.util.Random;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;

public class Flann_BlockSteel extends Block
{
	protected Flann_BlockSteel (int x)
	{
		super (x, Material.iron);
		setCreativeTab(FlannModCore.flanntab);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister IR){
		this.blockIcon = IR.registerIcon(FlannModCore.modid + ":" + this.getUnlocalizedName2());
	}
	
	public int idDropped(int x, Random rand)
	{
		return FlannModCore.blockSteel.blockID;
	}
	
	public int quantityDropped(Random rand)
	{
		return 1;
	}
}
