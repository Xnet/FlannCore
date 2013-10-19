// Coded by Flann

package mods.flanncore.src;

import net.minecraft.block.Block;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.Configuration;
import net.minecraftforge.common.EnumHelper;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.ShapedOreRecipe;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.Mod.PreInit;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

@NetworkMod(clientSideRequired=true,serverSideRequired=false)
@Mod(modid="FlannCore",name="Flann Core",version="#10")
public class CoreFlann {
	public static final String texLoc = "flanncore:";
	
	public static int BlockID = 800; // 1
	public static int ItemID = 14000; // 4
	
	public static boolean enableSteel, enableStickSteel, enableIngotRedstone;
	public static boolean disableSteelRecipe, combineConfigs;
	public static int bSteelID;
	public static int ironSmeltedID, ingotSteelID, stickSteelID, ingotRedstoneID;
	public static Block blockSteel;
	public static Item ironSmelted, ingotSteel, stickSteel, ingotRedstone;
	
	@PreInit
	public void preInit(FMLPreInitializationEvent event) {
		String categoryBlock, categoryItem, categoryGeneral, categoryEnable;
		
		Configuration config = new Configuration(event.getSuggestedConfigurationFile());
		config.load();
			
			boolean db = false; // default boolean
			combineConfigs = config.get("core", "combineConfigs", db, "Combine all the Flann mods' configs to one common").getBoolean(db);
			if(combineConfigs){
				String modname = "core";
				categoryBlock = modname+"_Block";
				categoryItem = modname+"_Item";
				categoryGeneral = modname+"_General";
				categoryEnable = modname+"_Enable";
			}else{
				categoryBlock = "block";
				categoryItem = "item";
				categoryGeneral = "general";
				categoryEnable = "enable";
			}
			
			enableSteel 		= config.get(categoryGeneral, "enableSteel", 			db).getBoolean(db);
			enableStickSteel 	= config.get(categoryGeneral, "enableStickSteel", 	db).getBoolean(db);
			enableIngotRedstone = config.get(categoryGeneral, "enableIngotRedstone", 	db).getBoolean(db);
			disableSteelRecipe 	= config.get(categoryGeneral, "disableSteelRecipe", 	db, "Disable the crafting of steel block (iron smelted will be removed)").getBoolean(db);
			
			bSteelID 		= config.get(categoryBlock, "blockSteel", BlockID+0).getInt();
			
			ironSmeltedID 	= config.get(categoryItem, "ironSmelted", ItemID+0).getInt()-256;
			ingotSteelID 	= config.get(categoryItem, "ingotSteel",  ItemID+1).getInt()-256;
			stickSteelID 	= config.get(categoryItem, "stickSteel", ItemID+2).getInt()-256;
			ingotRedstoneID = config.get(categoryItem, "ingotRedstone", ItemID+3).getInt()-256;
			
		config.save();
		
		init_objects();
		init_addname();
		
	}
	
	@Init
	public void load(FMLInitializationEvent event){
		init_oredict();
		init_addrecipe();
		init_harvestlvl();
	}
	
	public void init_objects(){
		if(enableSteel){
			blockSteel 		= new Flann_BlockSteel(bSteelID, texLoc+"blockSteel").setUnlocalizedName("blockSteel").setHardness(5F).setResistance(10F).setStepSound(Block.soundMetalFootstep);
			ingotSteel 		= new Flann_ItemMisc(ingotSteelID, "Steel Ingot", texLoc+"ingotSteel").setUnlocalizedName("ingotSteel");
			
			if(!disableSteelRecipe){
				ironSmelted = new Flann_ItemMisc(ironSmeltedID, "Smelted Iron", texLoc+"ironSmelted").setUnlocalizedName("ironSmelted");
			}
			GameRegistry.registerBlock(blockSteel);
		}
		if(enableStickSteel){
			stickSteel 		= new Flann_ItemMisc(stickSteelID, "Steel Stick", texLoc+"stickSteel" ).setUnlocalizedName("stickSteel");
		}
		if(enableIngotRedstone){
			ingotRedstone 	= new Flann_ItemMisc(ingotRedstoneID, "Redstone Ingot", texLoc+"ingotRedstone").setUnlocalizedName("ingotRedstone");
		}
	}
	
	public void init_addname(){
		if(enableSteel){
			if(!disableSteelRecipe){
				//LanguageRegistry.addName(ironSmelted, "Smelted Iron");
			}
			LanguageRegistry.addName(blockSteel, "Steel Block");
			//LanguageRegistry.addName(ingotSteel, "Steel Ingot");
		}
		if(enableStickSteel){
			//LanguageRegistry.addName(stickSteel, "Steel Stick");
		}
		if(enableIngotRedstone){
			//LanguageRegistry.addName(ingotRedstone, "Redstone Ingot");
		}
	}
	
	public void init_oredict(){
		if(enableSteel){
			if(!disableSteelRecipe){
				OreDictionary.registerOre("ironSmelted", ironSmelted);
			}
			OreDictionary.registerOre("blockSteel", blockSteel);
			OreDictionary.registerOre("ingotSteelUnhardened", ingotSteel);
		}
		if(enableStickSteel){
			OreDictionary.registerOre("stickSteel", stickSteel);
		}
		if(enableIngotRedstone){
			OreDictionary.registerOre("ingotRedstone", ingotRedstone);
		}
	}
	
	public void init_addrecipe(){
		if(enableSteel){
			if(!disableSteelRecipe){
				GameRegistry.addSmelting(Block.blockIron.blockID, new ItemStack(ironSmelted), 5);
			}
			GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(blockSteel,4), "SCS", "CSC", "SCS", 'C', new ItemStack(Item.coal, 1, 0), 'S', "ironSmelted"));
			GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(blockSteel,4), "SCS", "CSC", "SCS", 'C', new ItemStack(Item.coal, 1, 1), 'S', "ironSmelted"));
			GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ingotSteel,9), "S", 'S', "blockSteel"));
			GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(blockSteel,1), "SSS", "SSS", "SSS", 'S', "ingotSteel"));
			GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(blockSteel,1), "SSS", "SSS", "SSS", 'S', "ingotSteelUnhardened"));
		}
		if(enableStickSteel){
			GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(stickSteel,4), "S", "S", 'S', "ingotSteel"));
			GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(stickSteel,4), "S", "S", 'S', "ingotSteelUnhardened"));
			
		}
		if(enableIngotRedstone){
			GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ingotRedstone,4), "RRR", "RIR", "RRR", 'R', Item.redstone, 'I', Item.ingotIron));
		}
	}
	
	public void init_harvestlvl(){
		if(enableSteel){
			if(!disableSteelRecipe){}
			MinecraftForge.setBlockHarvestLevel(blockSteel, "pickaxe", 2);
		}
		if(enableStickSteel){}
		if(enableIngotRedstone){}
	}
}
