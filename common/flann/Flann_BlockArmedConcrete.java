//coded by Flann

package flann;

import java.util.Random;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.world.World;

public class Flann_BlockArmedConcrete extends Block
{
	public int texS;//Texture Side
	public int texTB;//Texture Top/Bottom
	protected Flann_BlockArmedConcrete (int x,int t,int tt)
	{
		super (x, Material.rock);
		texS=t;
		texTB=tt;
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
		
		if(x == 0){
			return texTB;
		}
		else if(x == 1){
			return texTB;
		}
		else{
			return texS;	
		}
	}
	
	@Override
	public void onBlockDestroyedByPlayer(World world, int x, int y, int z, int m)
	{
		world.setBlockWithNotify(x, y, z, FlannModsCore.steelBarsDirty.blockID);
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
