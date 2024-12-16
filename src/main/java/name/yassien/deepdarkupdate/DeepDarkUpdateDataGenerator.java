package name.yassien.deepdarkupdate;

import name.yassien.deepdarkupdate.block.ModBlocks;
import name.yassien.deepdarkupdate.datagen.*;
import name.yassien.deepdarkupdate.world.ModConfiguredFeatures;
import name.yassien.deepdarkupdate.world.ModPlacedFeatures;
import name.yassien.deepdarkupdate.world.biome.ModBiomes;
import name.yassien.deepdarkupdate.world.dimension.ModDimensions;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.minecraft.registry.RegistryBuilder;
import net.minecraft.registry.RegistryKeys;

public class DeepDarkUpdateDataGenerator implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator)
	{
		FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();

		pack.addProvider(ModBlockTagProvider::new);
		pack.addProvider(ModItemTagProvider::new);
		pack.addProvider(ModLootTableProvider::new);
		pack.addProvider(ModModelProvider::new);
		pack.addProvider(ModRecipeProvider::new);
		pack.addProvider(ModWorldGenerator::new);
	}

	@Override
	public void buildRegistry(RegistryBuilder registryBuilder) {

		registryBuilder.addRegistry(RegistryKeys.CONFIGURED_FEATURE, ModConfiguredFeatures::bootstrap);
		registryBuilder.addRegistry(RegistryKeys.PLACED_FEATURE, ModPlacedFeatures::bootstrap);

		registryBuilder.addRegistry(RegistryKeys.BIOME, ModBiomes::bootstrap);

		registryBuilder.addRegistry(RegistryKeys.DIMENSION_TYPE, ModDimensions::bootstrapType);
	}
}
