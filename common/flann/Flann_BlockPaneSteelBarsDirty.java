// Coded by Flann

package flann;

import java.util.Random;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import net.minecraft.block.BlockPane;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class Flann_BlockPaneSteelBarsDirty extends BlockPane
{
	public int tex = 0;
	
	protected Flann_BlockPaneSteelBarsDirty (int x, int y)
	{
		super (x, y, 0, Material.iron, true);
		tex = y;
		setCreativeTab(FlannModsCore.flanntab);
	}
	
	@Override
	@SideOnly(Side.CLIENT) //Client side only
		public String getTextureFile(){
		return "/flann/blocks.png"; //The texture file to be used
	}
	
	@SideOnly(Side.CLIENT) //Client side only
		public int getBlockTextureFromSide(int i){ //Tells it which texture from the sprite sheet
		return tex;
	}
	
	@Override
	public int idDropped(int x, Random rand, int j)
	{
		return FlannModsCore.steelBars.blockID;
	}

	@Override
	public int quantityDropped(Random rand)
	{
		return 1;
	}

}
