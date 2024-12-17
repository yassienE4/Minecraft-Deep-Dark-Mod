package name.yassien.deepdarkupdate.world.biome;

import name.yassien.deepdarkupdate.DeepDarkUpdate;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.sound.BiomeMoodSound;
import net.minecraft.sound.MusicType;
import net.minecraft.structure.AncientCityGenerator;
import net.minecraft.util.Identifier;
import net.minecraft.world.biome.*;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.carver.ConfiguredCarvers;
import net.minecraft.world.gen.feature.DefaultBiomeFeatures;
import net.minecraft.world.gen.feature.VegetationPlacedFeatures;

public class ModBiomes
{

    public static final RegistryKey<Biome> TEST_BIOME = RegistryKey.of(RegistryKeys.BIOME,
            Identifier.of(DeepDarkUpdate.MOD_ID, "test_biome"));

    public static void bootstrap(Registerable<Biome> context)
    {
        context.register(TEST_BIOME, testBiome(context));
    }

    public static void globalOverworldGeneration(GenerationSettings.LookupBackedBuilder builder) {
        DefaultBiomeFeatures.addLandCarvers(builder);


        DefaultBiomeFeatures.addMineables(builder);
        DefaultBiomeFeatures.addSprings(builder);
    }

    public static Biome testBiome(Registerable<Biome> context) {

        SpawnSettings.Builder spawnBuilder = new SpawnSettings.Builder();

        DefaultBiomeFeatures.addBatsAndMonsters(spawnBuilder);

        GenerationSettings.LookupBackedBuilder biomeBuilder =
                new GenerationSettings.LookupBackedBuilder(context.getRegistryLookup(RegistryKeys.PLACED_FEATURE),
                        context.getRegistryLookup(RegistryKeys.CONFIGURED_CARVER));

        biomeBuilder.carver(GenerationStep.Carver.AIR, ConfiguredCarvers.NETHER_CAVE);

        globalOverworldGeneration(biomeBuilder);


        DefaultBiomeFeatures.addDefaultOres(biomeBuilder);

        return new Biome.Builder()
                .precipitation(false)
                .downfall(1f)
                .temperature(1f)
                .generationSettings(biomeBuilder.build())
                .spawnSettings(spawnBuilder.build())
                .effects((new BiomeEffects.Builder())
                        .waterColor(0x3F76E4)
                        .waterFogColor(0x050533)
                        .skyColor(0x77ADFF)
                        .grassColor(0x91BD59)
                        .foliageColor(0x77AB2F)
                        .fogColor(0xC0D8FF)
                        .moodSound(BiomeMoodSound.CAVE).build())
                .build();
    }
}
