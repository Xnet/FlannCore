// Coded by Flann

package flann.flann;

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
		super (x, "Flann:steelBarsDirty", "Flann:steelBarsDirty", Material.iron, true);
		setCreativeTab(FlannModsCore.flanntab);
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
