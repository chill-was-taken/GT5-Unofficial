package gregtech.loaders.oreprocessing;

import static gregtech.api.util.GT_Recipe.GT_Recipe_Map.sAssemblerRecipes;
import static gregtech.api.util.GT_Recipe.GT_Recipe_Map.sCompressorRecipes;
import static gregtech.api.util.GT_Recipe.GT_Recipe_Map.sCutterRecipes;
import static gregtech.api.util.GT_Recipe.GT_Recipe_Map.sFluidSolidficationRecipes;
import static gregtech.api.util.GT_Recipe.GT_Recipe_Map.sHammerRecipes;
import static gregtech.api.util.GT_RecipeBuilder.SECONDS;
import static gregtech.api.util.GT_RecipeBuilder.TICKS;
import static gregtech.api.util.GT_Utility.calculateRecipeEU;

import net.minecraft.item.ItemStack;

import gregtech.api.GregTech_API;
import gregtech.api.enums.*;
import gregtech.api.util.GT_ModHandler;
import gregtech.api.util.GT_OreDictUnificator;
import gregtech.api.util.GT_Utility;

public class ProcessingBlock implements gregtech.api.interfaces.IOreRecipeRegistrator {

    public ProcessingBlock() {
        OrePrefixes.block.add(this);
    }

    @Override
    public void registerOre(OrePrefixes aPrefix, Materials aMaterial, String aOreDictName, String aModName,
        ItemStack aStack) {
        if (aMaterial != Materials.Clay && aMaterial != Materials.Basalt
            && aMaterial != MaterialsBotania.Livingrock
            && aMaterial != MaterialsBotania.Livingwood
            && aMaterial != MaterialsBotania.Dreamwood) {
            if (aMaterial.getProcessingMaterialTierEU() < TierEU.IV
                && GT_OreDictUnificator.get(OrePrefixes.plate, aMaterial, 1L) != null) {

                GT_Values.RA.stdBuilder()
                    .itemInputs(GT_Utility.copyAmount(1L, aStack))
                    .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.plate, aMaterial, 9L))
                    .fluidInputs(
                        Materials.Water.getFluid(
                            Math.max(
                                4,
                                Math.min(1000, ((int) Math.max(aMaterial.getMass() * 10L, 1L)) * TICKS * 30 / 320))))
                    .noFluidOutputs()
                    .duration(2 * ((int) Math.max(aMaterial.getMass() * 10L, 1L)) * TICKS)
                    .eut(TierEU.RECIPE_LV)
                    .addTo(sCutterRecipes);

                GT_Values.RA.stdBuilder()
                    .itemInputs(GT_Utility.copyAmount(1L, aStack))
                    .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.plate, aMaterial, 9L))
                    .fluidInputs(
                        GT_ModHandler.getDistilledWater(
                            Math.max(
                                3,
                                Math.min(750, ((int) Math.max(aMaterial.getMass() * 10L, 1L)) * TICKS * 30 / 426))))
                    .noFluidOutputs()
                    .duration(2 * ((int) Math.max(aMaterial.getMass() * 10L, 1L)) * TICKS)
                    .eut(TierEU.RECIPE_LV)
                    .addTo(sCutterRecipes);

                GT_Values.RA.stdBuilder()
                    .itemInputs(GT_Utility.copyAmount(1L, aStack))
                    .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.plate, aMaterial, 9L))
                    .fluidInputs(
                        Materials.Lubricant.getFluid(
                            Math.max(
                                1,
                                Math.min(250, ((int) Math.max(aMaterial.getMass() * 10L, 1L)) * TICKS * 30 / 1280))))
                    .noFluidOutputs()
                    .duration(((int) Math.max(aMaterial.getMass() * 10L, 1L)) * TICKS)
                    .eut(TierEU.RECIPE_LV)
                    .addTo(sCutterRecipes);
            }
        }

        if (aMaterial == MaterialsBotania.Livingrock || aMaterial == MaterialsBotania.Livingwood
            || aMaterial == MaterialsBotania.Dreamwood) {
            if (aMaterial.getProcessingMaterialTierEU() < TierEU.IV
                && GT_OreDictUnificator.get(OrePrefixes.plate, aMaterial, 1L) != null) {

                GT_Values.RA.stdBuilder()
                    .itemInputs(GT_Utility.copyAmount(1L, aStack), GT_Utility.getIntegratedCircuit(3))
                    .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.plate, aMaterial, 9L))
                    .fluidInputs(
                        Materials.Water.getFluid(
                            Math.max(
                                4,
                                Math.min(1000, ((int) Math.max(aMaterial.getMass() * 10L, 1L)) * TICKS * 30 / 320))))
                    .noFluidOutputs()
                    .duration(2 * ((int) Math.max(aMaterial.getMass() * 10L, 1L)) * TICKS)
                    .eut(TierEU.RECIPE_LV)
                    .addTo(sCutterRecipes);

                GT_Values.RA.stdBuilder()
                    .itemInputs(GT_Utility.copyAmount(1L, aStack), GT_Utility.getIntegratedCircuit(3))
                    .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.plate, aMaterial, 9L))
                    .fluidInputs(
                        GT_ModHandler.getDistilledWater(
                            Math.max(
                                3,
                                Math.min(750, ((int) Math.max(aMaterial.getMass() * 10L, 1L)) * TICKS * 30 / 426))))
                    .noFluidOutputs()
                    .duration(2 * ((int) Math.max(aMaterial.getMass() * 10L, 1L)) * TICKS)
                    .eut(TierEU.RECIPE_LV)
                    .addTo(sCutterRecipes);

                GT_Values.RA.stdBuilder()
                    .itemInputs(GT_Utility.copyAmount(1L, aStack), GT_Utility.getIntegratedCircuit(3))
                    .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.plate, aMaterial, 9L))
                    .fluidInputs(
                        Materials.Lubricant.getFluid(
                            Math.max(
                                1,
                                Math.min(250, ((int) Math.max(aMaterial.getMass() * 10L, 1L)) * TICKS * 30 / 1280))))
                    .noFluidOutputs()
                    .duration(((int) Math.max(aMaterial.getMass() * 10L, 1L)) * TICKS)
                    .eut(TierEU.RECIPE_LV)
                    .addTo(sCutterRecipes);
            }
        }

        ItemStack tStack1 = GT_OreDictUnificator.get(OrePrefixes.ingot, aMaterial, 1L);
        ItemStack tStack2 = GT_OreDictUnificator.get(OrePrefixes.gem, aMaterial, 1L);
        ItemStack tStack3 = GT_OreDictUnificator.get(OrePrefixes.dust, aMaterial, 1L);

        GT_ModHandler.removeRecipeDelayed(GT_Utility.copyAmount(1L, aStack));

        if (tStack1 != null) GT_ModHandler
            .removeRecipeDelayed(tStack1, tStack1, tStack1, tStack1, tStack1, tStack1, tStack1, tStack1, tStack1);
        if (tStack2 != null) GT_ModHandler
            .removeRecipeDelayed(tStack2, tStack2, tStack2, tStack2, tStack2, tStack2, tStack2, tStack2, tStack2);
        if (tStack3 != null) {
            GT_ModHandler
                .removeRecipeDelayed(tStack3, tStack3, tStack3, tStack3, tStack3, tStack3, tStack3, tStack3, tStack3);
        }

        if (aMaterial.mStandardMoltenFluid != null) {
            if (!(aMaterial == Materials.AnnealedCopper || aMaterial == Materials.WroughtIron)) {
                if (aMaterial.getProcessingMaterialTierEU() < TierEU.IV) {

                    GT_Values.RA.stdBuilder()
                        .itemInputs(ItemList.Shape_Mold_Block.get(0L))
                        .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.block, aMaterial, 1L))
                        .fluidInputs(aMaterial.getMolten(1296L))
                        .noFluidOutputs()
                        .duration(14 * SECONDS + 8 * TICKS)
                        .eut(8)
                        .addTo(sFluidSolidficationRecipes);
                }
            }
        }
        if (GregTech_API.sRecipeFile.get(
            ConfigCategories.Recipes.storageblockcrafting,
            OrePrefixes.block.get(aMaterial)
                .toString(),
            false)) {
            if ((tStack1 == null) && (tStack2 == null) && (tStack3 != null)) GT_ModHandler.addCraftingRecipe(
                GT_OreDictUnificator.get(OrePrefixes.block, aMaterial, 1L),
                new Object[] { "XXX", "XXX", "XXX", 'X', OrePrefixes.dust.get(aMaterial) });
            if (tStack2 != null) GT_ModHandler.addCraftingRecipe(
                GT_OreDictUnificator.get(OrePrefixes.block, aMaterial, 1L),
                new Object[] { "XXX", "XXX", "XXX", 'X', OrePrefixes.gem.get(aMaterial) });
            if (tStack1 != null) {
                GT_ModHandler.addCraftingRecipe(
                    GT_OreDictUnificator.get(OrePrefixes.block, aMaterial, 1L),
                    new Object[] { "XXX", "XXX", "XXX", 'X', OrePrefixes.ingot.get(aMaterial) });
            }
        }
        if (tStack1 != null) tStack1.stackSize = 9;
        if (tStack2 != null) tStack2.stackSize = 9;
        if (tStack3 != null) tStack3.stackSize = 9;

        if (tStack2 != null) {
            GT_Values.RA.stdBuilder()
                .itemInputs(aStack)
                .itemOutputs(tStack2)
                .noFluidInputs()
                .noFluidOutputs()
                .duration(5 * SECONDS)
                .eut(24)
                .addTo(sHammerRecipes);
        }

        if (GregTech_API.sRecipeFile.get(
            ConfigCategories.Recipes.storageblockdecrafting,
            OrePrefixes.block.get(aMaterial)
                .toString(),
            tStack2 != null)) {
            if (tStack3 != null)
                GT_ModHandler.addShapelessCraftingRecipe(tStack3, new Object[] { OrePrefixes.block.get(aMaterial) });
            if (tStack2 != null)
                GT_ModHandler.addShapelessCraftingRecipe(tStack2, new Object[] { OrePrefixes.block.get(aMaterial) });
            if (tStack1 != null)
                GT_ModHandler.addShapelessCraftingRecipe(tStack1, new Object[] { OrePrefixes.block.get(aMaterial) });
        }

        if (!OrePrefixes.block.isIgnored(aMaterial) && tStack1 != null) {
            // 9 ingots -> 1 block
            GT_Values.RA.stdBuilder()
                .itemInputs(GT_OreDictUnificator.get(OrePrefixes.ingot, aMaterial, 9L))
                .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.block, aMaterial, 1L))
                .noFluidInputs()
                .noFluidOutputs()
                .duration(15 * SECONDS)
                .eut(calculateRecipeEU(aMaterial, 2))
                .addTo(sCompressorRecipes);
        }

        switch (aMaterial.mName) {
            case "Mercury" -> System.err.println(
                "'blockQuickSilver'?, In which Ice Desert can you actually place this as a solid Block? On Pluto Greg :)");
            case "Iron", "WroughtIron", "Steel" -> GT_Values.RA.stdBuilder()
                .itemInputs(ItemList.IC2_Compressed_Coal_Ball.get(8L), GT_Utility.copyAmount(1L, aStack))
                .itemOutputs(ItemList.IC2_Compressed_Coal_Chunk.get(1L))
                .noFluidInputs()
                .noFluidOutputs()
                .duration(20 * SECONDS)
                .eut(4)
                .addTo(sAssemblerRecipes);
        }
    }
}
