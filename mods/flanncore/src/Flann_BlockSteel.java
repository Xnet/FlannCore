// Coded by Flann

package mods.flanncore.src;

import java.util.Random;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;

public class Flann_BlockSteel extends Block
{
	public String tex;
	
	protected Flann_BlockSteel (int id, String texture)
	{
		super (id, Material.iron);
		setCreativeTab(CreativeTabs.tabBlock);
		tex = texture;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister IR){
		this.blockIcon = IR.registerIcon(tex);
	}
	
	public int idDropped(int x, Random rand)
	{
		return this.blockID;
	}
	
	public int quantityDropped(Random rand)
	{
		return 1;
	}
}
