package name.yassien.deepdarkupdate.world.biome.surface;

import name.yassien.deepdarkupdate.block.ModBlocks;
import name.yassien.deepdarkupdate.world.biome.ModBiomes;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.surfacebuilder.MaterialRules;

public class ModMaterialRules
{

    private static final MaterialRules.MaterialRule DEEPSLATE = makeStateRule(Blocks.DEEPSLATE);
    private static final MaterialRules.MaterialRule SCULK_DEEPSLATE = makeStateRule(ModBlocks.SCULK_DEEPSLATE);

    private static final MaterialRules.MaterialRule BEDROCK_CEILING = makeStateRule(Blocks.BEDROCK);

    public static MaterialRules.MaterialRule makeRules() {
        MaterialRules.MaterialCondition isAtOrAboveWaterLevel = MaterialRules.water(-1, 0);

        MaterialRules.MaterialRule surface = MaterialRules.sequence(MaterialRules.condition(isAtOrAboveWaterLevel, DEEPSLATE), SCULK_DEEPSLATE);

        return MaterialRules.sequence(
                MaterialRules.sequence(MaterialRules.condition(MaterialRules.biome(ModBiomes.TEST_BIOME),
                                MaterialRules.condition(MaterialRules.STONE_DEPTH_FLOOR, DEEPSLATE)),
                        MaterialRules.condition(MaterialRules.STONE_DEPTH_CEILING, SCULK_DEEPSLATE)),

                MaterialRules.sequence(MaterialRules.condition(MaterialRules.not(MaterialRules.verticalGradient("bedrock_roof", YOffset.belowTop(5), YOffset.getTop())), BEDROCK_CEILING)),
                MaterialRules.sequence(MaterialRules.condition(MaterialRules.not(MaterialRules.verticalGradient("bedrock_roof", YOffset.belowTop(4), YOffset.getTop())), BEDROCK_CEILING)),
                MaterialRules.sequence(MaterialRules.condition(MaterialRules.not(MaterialRules.verticalGradient("bedrock_roof", YOffset.belowTop(3), YOffset.getTop())), BEDROCK_CEILING)),
                MaterialRules.sequence(MaterialRules.condition(MaterialRules.not(MaterialRules.verticalGradient("bedrock_roof", YOffset.belowTop(2), YOffset.getTop())), BEDROCK_CEILING)),
                MaterialRules.sequence(MaterialRules.condition(MaterialRules.not(MaterialRules.verticalGradient("bedrock_roof", YOffset.belowTop(1), YOffset.getTop())), BEDROCK_CEILING)),
                MaterialRules.sequence(MaterialRules.condition(MaterialRules.not(MaterialRules.verticalGradient("bedrock_roof", YOffset.belowTop(0), YOffset.getTop())), BEDROCK_CEILING)),





                MaterialRules.condition(MaterialRules.STONE_DEPTH_FLOOR, surface),
                MaterialRules.condition(MaterialRules.STONE_DEPTH_CEILING, surface)
        );
    }

    private static MaterialRules.MaterialRule makeStateRule(Block block) {
        return MaterialRules.block(block.getDefaultState());
    }
}
