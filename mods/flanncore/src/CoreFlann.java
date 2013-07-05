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
@Mod(modid="FlannCore",name="Flann Core",version="#7")
public class CoreFlann {
	public static final String texLoc = "flanncore:";
	
	public static int BlockID = 800; // 1
	public static int ItemID = 14000; // 4
	
	public static boolean enableSteel, enableStickSteel, enableIngotRedstone;
	public static boolean disableSteelRecipe;
	public static int bSteelID;
	public static int ironSmeltedID, ingotSteelID, stickSteelID, ingotRedstoneID;
	public static Block blockSteel;
	public static Item ironSmelted, ingotSteel, stickSteel, ingotRedstone;
	
	@PreInit
	public void preInit(FMLPreInitializationEvent event) {
		Configuration config = new Configuration(event.getSuggestedConfigurationFile());
		config.load();
			bSteelID 		= config.get("block", "blockSteel", BlockID+0).getInt();
			
			ironSmeltedID 	= config.get("item", "ironSmelted", ItemID+0).getInt()-256;
			ingotSteelID 	= config.get("item", "ingotSteel",  ItemID+1).getInt()-256;
			stickSteelID 	= config.get("item", "stickSteel", ItemID+2).getInt()-256;
			ingotRedstoneID = config.get("item", "ingotRedstone", ItemID+3).getInt()-256;
			
			boolean db = false; // default boolean
			enableSteel 		= config.get("general", "enableSteel", 			db).getBoolean(db);
			enableStickSteel 	= config.get("general", "enableStickSteel", 	db).getBoolean(db);
			enableIngotRedstone = config.get("general", "enableIngotRedstone", 	db).getBoolean(db);
			disableSteelRecipe 	= config.get("general", "disableSteelRecipe", 	db, "Disable the crafting of steel block (iron smelted will be removed)").getBoolean(false);
		config.save();
	}
	
	@Init
	public void load(FMLInitializationEvent event){
		
		if(enableSteel){
			blockSteel 		= new Flann_BlockSteel(bSteelID, texLoc+"blockSteel").setUnlocalizedName("blockSteel").setHardness(5F).setResistance(10F).setStepSound(Block.soundMetalFootstep);
			ingotSteel 		= new Flann_ItemMisc(ingotSteelID, "Steel Ingot", texLoc+"ingotSteel").setUnlocalizedName("ingotSteel");
			
			if(!disableSteelRecipe){
				ironSmelted = new Flann_ItemMisc(ironSmeltedID, "Smelted Iron", texLoc+"ironSmelted").setUnlocalizedName("ironSmelted");
				//LanguageRegistry.addName(ironSmelted, "Smelted Iron");
				OreDictionary.registerOre("ironSmelted", ironSmelted);
				GameRegistry.addSmelting(Block.blockIron.blockID, new ItemStack(ironSmelted), 5);
			}
			
			GameRegistry.registerBlock(blockSteel);
			MinecraftForge.setBlockHarvestLevel(blockSteel, "pickaxe", 2);
			
			LanguageRegistry.addName(blockSteel, "Steel Block");
			//LanguageRegistry.addName(ingotSteel, "Steel Ingot");
			
			OreDictionary.registerOre("blockSteel", blockSteel);
			OreDictionary.registerOre("ingotSteelUnhardened", ingotSteel);
			
			GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(blockSteel,4), "SCS", "CSC", "SCS", 'C', new ItemStack(Item.coal, 1, 0), 'S', "ironSmelted"));
			GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(blockSteel,4), "SCS", "CSC", "SCS", 'C', new ItemStack(Item.coal, 1, 1), 'S', "ironSmelted"));
			GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ingotSteel,9), "S", 'S', "blockSteel"));
			GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(blockSteel,1), "SSS", "SSS", "SSS", 'S', "ingotSteel"));
			GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(blockSteel,1), "SSS", "SSS", "SSS", 'S', "ingotSteelUnhardened"));
		}
		if(enableStickSteel){
			stickSteel 		= new Flann_ItemMisc(stickSteelID, "Steel Stick", texLoc+"stickSteel" ).setUnlocalizedName("stickSteel");
			//LanguageRegistry.addName(stickSteel, "Steel Stick");
			OreDictionary.registerOre("stickSteel", stickSteel);
			GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(stickSteel,4), "S", "S", 'S', "ingotSteel"));
			GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(stickSteel,4), "S", "S", 'S', "ingotSteelUnhardened"));
			
		}
		if(enableIngotRedstone){
			ingotRedstone 	= new Flann_ItemMisc(ingotRedstoneID, "Redstone Ingot", texLoc+"ingotRedstone").setUnlocalizedName("ingotRedstone");
			//LanguageRegistry.addName(ingotRedstone, "Redstone Ingot");
			OreDictionary.registerOre("ingotRedstone", ingotRedstone);
			GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ingotRedstone,4), "RRR", "RIR", "RRR", 'R', Item.redstone, 'I', Item.ingotIron));
		}
	}
}
