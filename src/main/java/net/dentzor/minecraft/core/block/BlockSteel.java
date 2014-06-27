package net.dentzor.minecraft.core.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class BlockSteel extends Block {

    public BlockSteel(Material material, String texture) {
        super(material);
        setCreativeTab(CreativeTabs.tabBlock);
        setHardness(5.0F);
        setResistance(5.0F);
        setLightLevel(0.5F);
        setBlockTextureName(texture);
        setHarvestLevel("pickaxe", 2);
    }
}
