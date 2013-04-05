// Coded by Flann

package mods.flann.src;

import java.util.Random;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

public class Flann_BlockBarbedWire extends Block
{
	protected Flann_BlockBarbedWire (int x)
	{
		super (x, Flann_Material.iron2);
		//setRequiresSelfNotify();
		setCreativeTab(FlannModCore.flanntab);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister IR){
		this.blockIcon = IR.registerIcon(FlannModCore.modid + ":" + this.getUnlocalizedName2());
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
