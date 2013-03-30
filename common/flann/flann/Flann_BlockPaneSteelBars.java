// Coded by Flann

package flann.flann;

import java.util.Random;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.BlockPane;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.util.Icon;

public class Flann_BlockPaneSteelBars extends BlockPane
{
	protected Flann_BlockPaneSteelBars (int x)
	{
		super (x, "Flann:steelBars", "Flann:steelBars", Material.iron, true);
		setCreativeTab(FlannModsCore.flanntab);
	}

	@Override
	public int idDropped(int x, Random rand, int y)
	{
		return FlannModsCore.steelBars.blockID;
	}

	@Override
	public int quantityDropped(Random rand)
	{
		return 1;
	}

}
