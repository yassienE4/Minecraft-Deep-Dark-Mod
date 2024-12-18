package name.yassien.deepdarkupdate.world.biome;

import name.yassien.deepdarkupdate.DeepDarkUpdate;
import name.yassien.deepdarkupdate.world.biome.surface.ModMaterialRules;
import terrablender.api.SurfaceRuleManager;
import terrablender.api.TerraBlenderApi;

public class ModTerrablenderAPI implements TerraBlenderApi
{
    @Override
    public void onTerraBlenderInitialized() {
        SurfaceRuleManager.addSurfaceRules(SurfaceRuleManager.RuleCategory.OVERWORLD,DeepDarkUpdate.MOD_ID, ModMaterialRules.makeRules());
    }
}
