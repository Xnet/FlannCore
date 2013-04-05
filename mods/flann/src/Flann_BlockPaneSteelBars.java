// Coded by Flann

package mods.flann.src;

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
		super (x, FlannModCore.modid+":steelBars", FlannModCore.modid+":steelBars", Material.iron, true);
		setCreativeTab(FlannModCore.flanntab);
	}

	@Override
	public int idDropped(int x, Random rand, int y)
	{
		return FlannModCore.steelBars.blockID;
	}

	@Override
	public int quantityDropped(Random rand)
	{
		return 1;
	}

}
