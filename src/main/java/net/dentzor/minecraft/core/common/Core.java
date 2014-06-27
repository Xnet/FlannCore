package net.dentzor.minecraft.core.common;

import net.dentzor.minecraft.core.block.BlockSteel;
import net.dentzor.minecraft.core.item.ItemMisc;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.ShapedOreRecipe;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;

@Mod(modid = net.dentzor.minecraft.core.common.Core.modid, name = net.dentzor.minecraft.core.common.Core.modname, version = net.dentzor.minecraft.core.common.Core.modversion)
public class Core {
    @SidedProxy(clientSide = "net.dentzor.minecraft.core.common.ClientProxy", serverSide = "net.dentzor.minecraft.core.common.CommonProxy")
    public static CommonProxy  proxy;

    // Set mod-specific names etc.
    public static final String modid           = "flanncore";
    public static final String modname         = "Flann Core Mod";
    public static final String modversion      = "#11";
    public static final String textureLocation = Core.modid + ":";

    // Create all blocks in the core mod (NOT initialize)
    public static Block        blockSteel;

    // Booleans to enable/disable stuff
    public static boolean      enableSteel, enableStickSteel, enableIngotRedstone;
    public static boolean      disableSteelRecipe, combineConfigs;

    // Create all items in the core mod (NOT initialize)
    public static Item         ironSmelted, ingotSteel, stickSteel, ingotRedstone;

    // Constructor
    public Core() {

    }

    @EventHandler
    public static void preInit(FMLPreInitializationEvent event) {
        Core.loadConfig(event);
        Core.init_items();
        Core.registerItems();
        Core.registerBlocks();
    }

    @EventHandler
    public static void atInit(FMLInitializationEvent event) {
        Core.registerOreDictionary();
        Core.init_crafting();
    }

    @EventHandler
    public static void postInit(FMLPostInitializationEvent event) {

    }

    // Register all items in forge GameRegistry
    public static void registerItems() {
        if (enableSteel) {
            GameRegistry.registerItem(Core.ingotSteel, "ingotSteel");
            if (!disableSteelRecipe) {
                GameRegistry.registerItem(Core.ironSmelted, "ironSmelted");
            }
        }
        if (enableStickSteel) {
            GameRegistry.registerItem(Core.stickSteel, "stickSteel");
        }
        if (enableIngotRedstone) {
            GameRegistry.registerItem(Core.ingotRedstone, "ingotRedstone");
        }
    }

    // Registering the blocks into the GameRegistry
    public static void registerBlocks() {
        if (enableSteel) {
            GameRegistry.registerBlock(Core.blockSteel, Core.blockSteel.getUnlocalizedName().substring(5));
        }
    }

    // Load the config-values
    public static void loadConfig(FMLPreInitializationEvent event) {
        String categoryGeneral;

        Configuration config = new Configuration(event.getSuggestedConfigurationFile());
        config.load();

        boolean db = true; // default boolean
        combineConfigs = config.get("core", "combineConfigs", db, "Combine all the Flann mods' configs to one common").getBoolean(db);
        if (combineConfigs) {
            categoryGeneral = modid + "_General";
        } else {
            categoryGeneral = "general";
        }

        enableSteel = config.get(categoryGeneral, "enableSteel", db).getBoolean(db);
        enableStickSteel = config.get(categoryGeneral, "enableStickSteel", db).getBoolean(db);
        enableIngotRedstone = config.get(categoryGeneral, "enableIngotRedstone", db).getBoolean(db);
        disableSteelRecipe = config.get(categoryGeneral, "disableSteelRecipe", false, "Disable the crafting of steel block (iron smelted will be removed)").getBoolean(false);

        config.save();
    }

    // init_items
    public static void init_items() {

        // Core.headVanilla = new ItemHeadPaxel(Core.textureLocation,
        // "headPaxel", Core.tabPaxel);

        if (enableSteel) {
            blockSteel = new BlockSteel(Material.iron, textureLocation + "blockSteel").setHardness(5F).setResistance(10F).setStepSound(Block.soundTypeMetal).setBlockName("blockSteel");
            ingotSteel = new ItemMisc("Steel Ingot", textureLocation + "ingotSteel", CreativeTabs.tabMaterials).setUnlocalizedName("ingotSteel");

            if (!disableSteelRecipe) {
                ironSmelted = new ItemMisc("Smelted Iron", textureLocation + "ironSmelted", CreativeTabs.tabMaterials).setUnlocalizedName("ironSmelted");
            }
        }
        if (enableStickSteel) {
            stickSteel = new ItemMisc("Steel Stick", textureLocation + "stickSteel", CreativeTabs.tabMaterials).setUnlocalizedName("stickSteel");
        }
        if (enableIngotRedstone) {
            ingotRedstone = new ItemMisc("Redstone Ingot", textureLocation + "ingotRedstone", CreativeTabs.tabMaterials).setUnlocalizedName("ingotRedstone");
        }
    }
    
    // Add to oreDictionary
    public static void registerOreDictionary(){
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
    
    // Init crafting
    public static void init_crafting(){
        if(enableSteel){
            if(!disableSteelRecipe){
                GameRegistry.addSmelting(Blocks.iron_block, new ItemStack(ironSmelted), 5);
            }
            GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(blockSteel,4), "SCS", "CSC", "SCS", 'C', new ItemStack(Items.coal, 1, 0), 'S', "ironSmelted"));
            GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(blockSteel,4), "SCS", "CSC", "SCS", 'C', new ItemStack(Items.coal, 1, 1), 'S', "ironSmelted"));
            GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ingotSteel,9), "S", 'S', "blockSteel"));
            GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(blockSteel,1), "SSS", "SSS", "SSS", 'S', "ingotSteel"));
            GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(blockSteel,1), "SSS", "SSS", "SSS", 'S', "ingotSteelUnhardened"));
        }
        if(enableStickSteel){
            GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(stickSteel,4), "S", "S", 'S', "ingotSteel"));
            GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(stickSteel,4), "S", "S", 'S', "ingotSteelUnhardened"));
    
        }
        if(enableIngotRedstone){
            GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ingotRedstone,4), "RRR", "RIR", "RRR", 'R', Items.redstone, 'I', Items.iron_ingot));
        }
    }

}
