
package com.epikwem.preciousores.world.generation;

import net.minecraft.block.Blocks;
import net.minecraft.world.gen.feature.template.BlockMatchRuleTest;
import net.minecraft.world.gen.feature.template.RuleTest;

public class ModFillerBlockTypes {

    public static final RuleTest
        ANDESITE = new BlockMatchRuleTest(Blocks.ANDESITE),
        DIORITE = new BlockMatchRuleTest(Blocks.DIORITE),
        GLOWSTONE = new BlockMatchRuleTest(Blocks.GLOWSTONE),
        GRANITE = new BlockMatchRuleTest(Blocks.GRANITE),
        MAGMA_BLOCK = new BlockMatchRuleTest(Blocks.MAGMA_BLOCK),
        STONE = new BlockMatchRuleTest(Blocks.STONE);

}
