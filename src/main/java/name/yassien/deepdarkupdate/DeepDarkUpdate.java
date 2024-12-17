package name.yassien.deepdarkupdate;

import name.yassien.deepdarkupdate.block.ModBlocks;
import name.yassien.deepdarkupdate.item.ModItems;
import name.yassien.deepdarkupdate.world.gen.ModWorldGeneration;
import net.fabricmc.api.ModInitializer;

import net.kyrptonaught.customportalapi.api.CustomPortalBuilder;
import net.minecraft.block.Blocks;
import net.minecraft.item.Items;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DeepDarkUpdate implements ModInitializer {
	public static final String MOD_ID = "deepdarkupdate";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {

		LOGGER.info("Hello Fabric world!");
		ModItems.registerModItems();
		ModBlocks.registerModBlocks();

		ModWorldGeneration.generateModWorldGen();

		CustomPortalBuilder.beginPortal()
				.frameBlock(Blocks.REINFORCED_DEEPSLATE)
				.lightWithItem(Items.ECHO_SHARD)
				.destDimID(Identifier.of(DeepDarkUpdate.MOD_ID, "darkdim"))
				.tintColor(0x4a4f58)
				.registerPortal();
	}
}