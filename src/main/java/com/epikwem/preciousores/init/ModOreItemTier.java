
package com.epikwem.preciousores.init;

import net.minecraft.block.Block;
import net.minecraft.block.OreBlock;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.item.*;
import net.minecraft.item.crafting.Ingredient;
import net.minecraftforge.common.ToolType;

public enum ModOreItemTier implements IItemTier {

    SILVER ("silver", 2, 1254, 0.0f, 2, 0, Items.COAL, MaterialColor.LIGHT_GRAY, 6.0f, 3.0f, 1.0f);

    private final String oreName;
    private final int harvestLevel;
    private final int maxUses;
    private final float efficiency;
    private final int attackDamage;
    private final int enchantability;
    private final Item repairMaterial;
    private final MaterialColor color;
    private final float hardness;
    private final float blockResistance;
    private final float attackSpeed;

    private ModOreItemTier(String _oreName, int _harvestLevel, int _maxUses, float _efficiency, int _attackDamage, int _enchantability, Item _repairMaterial, MaterialColor _color, float _hardness, float _blockResistance, float _attackSpeed) {
        oreName = _oreName;
        harvestLevel = _harvestLevel;
        maxUses = _maxUses;
        efficiency = _efficiency;
        attackDamage = _attackDamage;
        enchantability = _enchantability;
        repairMaterial = _repairMaterial;
        color = _color;
        hardness = _hardness;
        blockResistance = _blockResistance;
        attackSpeed = _attackSpeed;
    }

    public final Block block(boolean _wantOreBlock) {
        if (_wantOreBlock)
            return new OreBlock( Block.Properties
                    .create(Material.ROCK, color)
                    .hardnessAndResistance(hardness, 3.0f)
                    .harvestLevel(harvestLevel)
                    .harvestTool(ToolType.PICKAXE) );
        else
            return new Block( Block.Properties
                .create(Material.IRON, color)
                .hardnessAndResistance(hardness+2.0f, blockResistance)
                .harvestLevel(0)
                .harvestTool(ToolType.PICKAXE) );
    }

    public final Item item() {
        return new Item( new Item.Properties().group(ItemGroup.MATERIALS) );
    }

    public final Item tool(ToolType _toolType) {
        if (_toolType.equals(ToolType.PICKAXE))
            return new PickaxeItem(this, 6, 1.0f, new Item.Properties().group(ItemGroup.TOOLS));
        else if (_toolType.equals(ToolType.PICKAXE))
            return new Item( new Item.Properties().group(ItemGroup.TOOLS) );
        else if (_toolType.equals(ToolType.SHOVEL))
            return new Item( new Item.Properties().group(ItemGroup.TOOLS) );
        else
            return new Item( new Item.Properties().group(ItemGroup.TOOLS) );
    }

    public final Item sword() {
        return new SwordItem(this, 4, attackSpeed, new Item.Properties().group(ItemGroup.COMBAT));
    }

    public String getOreName() {
        return oreName;
    }

    public int getHarvestLevel() {
        return harvestLevel;
    }

    public int getMaxUses() {
        return maxUses;
    }

    public float getEfficiency() {
        return efficiency;
    }

    public float getAttackDamage() {
        return attackDamage;
    }

    public int getEnchantability() {
        return enchantability;
    }

    public Ingredient getRepairMaterial() {
        return Ingredient.fromItems(repairMaterial);
    }

    public MaterialColor getColor() {
        return color;
    }

    public float getHardness() {
        return hardness;
    }

    public float getBlockResistance() {
        return blockResistance;
    }

    public float getAttackSpeed() {
        return attackSpeed;
    }

}
