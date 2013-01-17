// Coded by Flann

package flann;

import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;

public class Flann_Material extends Material{
	
	public Flann_Material(MapColor par1MapColor) {
		super(par1MapColor);
	}

	public static final Material iron2 = (new Flann_Material(MapColor.ironColor)).setRequiresTool();
	
	protected Material setRequiresTool()
    {
        super.setRequiresTool();
        return this;
    }
}
