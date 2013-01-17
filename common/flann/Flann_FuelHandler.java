// Coded by Flann

package flann;

import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.IFuelHandler;

public class Flann_FuelHandler implements IFuelHandler{
	
	@Override
	public int getBurnTime(ItemStack fuel) { //This method sets burn time
		if(fuel.itemID == FlannModsCore.stickIngot.shiftedIndex && fuel.getItemDamage() == 0){
			return 100; //1/4 of coal
		}else if(fuel.itemID == FlannModsCore.paxelWood.shiftedIndex){
			return 300; //1/4 of coal
		}else if(fuel.itemID == FlannModsCore.battleaxeWood.shiftedIndex){
			return 300; //1/4 of coal
		}
		return 0;
	}
}