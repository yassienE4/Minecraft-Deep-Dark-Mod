package name.yassien.deepdarkupdate.world.biome.surface;

import name.yassien.deepdarkupdate.block.ModBlocks;
import name.yassien.deepdarkupdate.world.biome.ModBiomes;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.world.gen.surfacebuilder.MaterialRules;

public class ModMaterialRules
{
    private static final MaterialRules.MaterialRule DIRT = makeStateRule(Blocks.DIRT);
    private static final MaterialRules.MaterialRule GRASS_BLOCK = makeStateRule(Blocks.GRASS_BLOCK);
    private static final MaterialRules.MaterialRule RUBY = makeStateRule(ModBlocks.SCULK_DEEPSLATE_BRICK);
    private static final MaterialRules.MaterialRule RAW_RUBY = makeStateRule(ModBlocks.PINK_GARNET_BLOCK);

    public static MaterialRules.MaterialRule makeRules() {
        MaterialRules.MaterialCondition isAtOrAboveWaterLevel = MaterialRules.water(-1, 0);

        MaterialRules.MaterialRule grassSurface = MaterialRules.sequence(MaterialRules.condition(isAtOrAboveWaterLevel, GRASS_BLOCK), DIRT);

        return MaterialRules.sequence(
                MaterialRules.sequence(MaterialRules.condition(MaterialRules.biome(ModBiomes.TEST_BIOME),
                                MaterialRules.condition(MaterialRules.STONE_DEPTH_FLOOR, RAW_RUBY)),
                        MaterialRules.condition(MaterialRules.STONE_DEPTH_CEILING, RUBY)),

                // Default to a grass and dirt surface
                MaterialRules.condition(MaterialRules.STONE_DEPTH_FLOOR, grassSurface)
        );
    }

    private static MaterialRules.MaterialRule makeStateRule(Block block) {
        return MaterialRules.block(block.getDefaultState());
    }
}
