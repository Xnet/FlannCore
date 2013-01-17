// Coded by Flann

package flann;

import java.util.Random;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class Flann_BlockSteel extends Block
{
	
	public int tex = 0;
	
	protected Flann_BlockSteel (int x, int t)
	{
		super (x, Material.iron);
		tex = t;
		setCreativeTab(FlannModsCore.flanntab);
	}
	
	@SideOnly(Side.CLIENT) //Client side only
	public String getTextureFile(){
		return "/flann/blocks.png"; //The texture file to be used
	}
	
	@SideOnly(Side.CLIENT) //Client side only
	public int getBlockTextureFromSide(int i){ //Tells it which texture from the sprite sheet
		return tex;
	}
	
	public int idDropped(int x, Random rand)
	{
		return FlannModsCore.blockSteel.blockID;
	}
	
	public int quantityDropped(Random rand)
	{
		return 1;
	}
}
