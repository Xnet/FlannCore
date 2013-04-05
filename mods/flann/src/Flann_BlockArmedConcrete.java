//coded by Flann

package mods.flann.src;

import java.util.Random;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.util.Icon;
import net.minecraft.world.World;

public class Flann_BlockArmedConcrete extends Block
{
	public Icon texT;//Texture Top
	public Icon texB;//Texture Bottom
	protected Flann_BlockArmedConcrete (int x)
	{
		super (x, Material.rock);
		setCreativeTab(FlannModCore.flanntab);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister IR){
		this.blockIcon = IR.registerIcon(FlannModCore.modid + ":" + FlannModCore.concrete.getUnlocalizedName2());
		this.texT = IR.registerIcon(FlannModCore.modid + ":" + this.getUnlocalizedName2());
		this.texB = IR.registerIcon(FlannModCore.modid + ":" + this.getUnlocalizedName2());
	}

	@Override
	@SideOnly(Side.CLIENT) //Client side only
	public Icon getBlockTextureFromSideAndMetadata(int side, int metadata){ //Tells it which texture from the sprite sheet
		switch(side){
		case 0:return texB;
		case 1:return texT;
		default:return blockIcon;
		}
	}
	
	@Override
	public void onBlockDestroyedByPlayer(World world, int x, int y, int z, int m)
	{
		world.setBlock(x, y, z, FlannModCore.steelBarsDirty.blockID);
	}
	
	@Override
	public int idDropped(int x, Random rand, int j)
	{
		return FlannModCore.concrete.blockID;
	}

	@Override
	public int quantityDropped(Random rand)
	{
		return 1;
	}
}
