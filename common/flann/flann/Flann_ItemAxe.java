// Coded by Flann

package flann.flann;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.ItemAxe;

public class Flann_ItemAxe extends ItemAxe{

	public int tex = 0;
	
	public Flann_ItemAxe(int i, int t, EnumToolMaterial enumtoolmaterial) {
		super(i, enumtoolmaterial);
		tex = t;
		setCreativeTab(FlannModsCore.flanntab);
	}
	
	@SideOnly(Side.CLIENT) //Makes sure that only the client side can call this method
	public String getTextureFile(){ //Tells it what texture file to use
		return "/flann/flann/moretools.png";
	}

	@SideOnly(Side.CLIENT)
	public int getIconFromDamage(int i){ //Tells it what texture index to use
		return tex;
	}
	
}
