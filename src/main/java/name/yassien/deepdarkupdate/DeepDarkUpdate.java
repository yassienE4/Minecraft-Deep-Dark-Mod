package name.yassien.deepdarkupdate;

import name.yassien.deepdarkupdate.block.ModBlocks;
import name.yassien.deepdarkupdate.item.ModItems;
import net.fabricmc.api.ModInitializer;

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
	}
}