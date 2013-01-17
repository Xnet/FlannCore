package flann;

import net.minecraftforge.client.MinecraftForgeClient;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.Mod.Instance;

public class ClientProxy extends CommonProxy{
	@Override
	public void registerRenderInformation() //This is why you needed the server side
	{
		// Blocks
		MinecraftForgeClient.preloadTexture("/flann/blocks.png");
		
		// Items
		MinecraftForgeClient.preloadTexture("/flann/battleaxes.png");
		MinecraftForgeClient.preloadTexture("/flann/items.png");
		MinecraftForgeClient.preloadTexture("/flann/morearmor.png");
		MinecraftForgeClient.preloadTexture("/flann/moretools.png");
		MinecraftForgeClient.preloadTexture("/flann/paxels.png");
	}
	
}
