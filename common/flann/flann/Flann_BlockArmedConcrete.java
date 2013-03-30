//coded by Flann

package flann.flann;

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
		setCreativeTab(FlannModsCore.flanntab);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister IR){
		this.blockIcon = IR.registerIcon(FlannModsCore.modid + ":" + FlannModsCore.concrete.getUnlocalizedName2());
		this.texT = IR.registerIcon(FlannModsCore.modid + ":" + this.getUnlocalizedName2());
		this.texB = IR.registerIcon(FlannModsCore.modid + ":" + this.getUnlocalizedName2());
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
		world.setBlock(x, y, z, FlannModsCore.steelBarsDirty.blockID);
	}
	
	@Override
	public int idDropped(int x, Random rand, int j)
	{
		return FlannModsCore.concrete.blockID;
	}

	@Override
	public int quantityDropped(Random rand)
	{
		return 1;
	}
}
