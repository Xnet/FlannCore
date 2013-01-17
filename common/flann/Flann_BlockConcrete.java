//coded by Flann

package flann;

import java.util.Random;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class Flann_BlockConcrete extends Block 
{
	public int tex = 0;
	
	protected Flann_BlockConcrete (int x, int y)
	{		
		super (x, Material.rock);
		tex = y;
		setCreativeTab(FlannModsCore.flanntab);
	}

	@Override
	@SideOnly(Side.CLIENT) //Client side only
	public String getTextureFile(){
		return "/flann/blocks.png"; //The texture file to be used
	}

	@Override
	@SideOnly(Side.CLIENT) //Client side only
	public int getBlockTextureFromSide(int x){ //Tells it which texture from the sprite sheet
		return tex;
	}
	
	@Override
	public int idDropped(int par1, Random par2, int par3)
	{
		return FlannModsCore.concrete.blockID;
	}

	@Override
	public int quantityDropped(Random rand)
	{
		return 1;
	}
}
