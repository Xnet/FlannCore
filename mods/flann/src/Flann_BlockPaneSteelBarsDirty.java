// Coded by Flann

package mods.flann.src;

import java.util.Random;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import net.minecraft.block.BlockPane;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;

public class Flann_BlockPaneSteelBarsDirty extends BlockPane
{
	protected Flann_BlockPaneSteelBarsDirty (int x)
	{
		super (x, FlannModCore.modid+":steelBarsDirty", FlannModCore.modid+":steelBarsDirty", Material.iron, true);
		setCreativeTab(FlannModCore.flanntab);
	}
	
	@Override
	public int idDropped(int x, Random rand, int j)
	{
		return FlannModCore.steelBars.blockID;
	}

	@Override
	public int quantityDropped(Random rand)
	{
		return 1;
	}

}
