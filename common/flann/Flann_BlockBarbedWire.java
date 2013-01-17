// Coded by Flann

package flann;

import java.util.Random;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

public class Flann_BlockBarbedWire extends Block
{
	public int tex;
	
	protected Flann_BlockBarbedWire (int x, int i)
	{
		super (x, i, Flann_Material.iron2);
		setRequiresSelfNotify();
		tex = i;
		setCreativeTab(FlannModsCore.flanntab);
	}
	
	@Override
	@SideOnly(Side.CLIENT) //Client side only
		public String getTextureFile(){
		return "/flann/blocks.png"; //The texture file to be used
	}

	@Override
	@SideOnly(Side.CLIENT) //Client side only
		public int getBlockTextureFromSide(int i){ //Tells it which texture from the sprite sheet
		return tex;
	}
	
	@Override
	public void onEntityCollidedWithBlock(World world, int i, int j, int k, Entity entity)
	{
	    entity.motionX *= 0.20000000000000002D;
	    entity.motionZ *= 0.20000000000000002D;
		entity.attackEntityFrom(DamageSource.cactus, 2);
	}

	@Override
	public boolean isOpaqueCube()
	{
		return false;
	}

	@Override
	public AxisAlignedBB getCollisionBoundingBoxFromPool(World world, int i, int j, int k)
    {
        return null;
    }

	@Override
	public int getRenderType()
    {
        return 1;
    }

	@Override
	public boolean renderAsNormalBlock()
	{
		return false;
	}
	
	@Override
	public int idDropped(int par1, Random par2Random, int par3)
    {
        return this.blockID;
    }
	
	@Override
	public int quantityDropped(Random random)
	{
		return 1;
	}
	
}
