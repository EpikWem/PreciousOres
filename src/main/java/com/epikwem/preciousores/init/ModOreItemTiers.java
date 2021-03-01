
package com.epikwem.preciousores.init;

import net.minecraft.block.Block;
import net.minecraft.block.OreBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.item.*;
import net.minecraft.item.crafting.Ingredient;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.event.RegistryEvent;

import static com.epikwem.preciousores.Main.setup;

public enum ModOreItemTiers implements IItemTier {

    SILVER (ModIngots.SILVER_INGOT,
            2,
            1254,
            0.0f,
            2,
            0,
            1.0f);

    private final String oreName;
    private final int harvestLevel;
    private final int maxUses;
    private final float efficiency;
    private final int attackDamage;
    private final int enchantability;
    private final Item repairItem;
    private final float attackSpeed;

    ModOreItemTiers(final ModIngots _oreIngot, int _harvestLevel, int _maxUses, float _efficiency, int _attackDamage, int _enchantability, float _attackSpeed) {
        oreName = _oreIngot.getOreName();
        harvestLevel = _harvestLevel;
        maxUses = _maxUses;
        efficiency = _efficiency;
        attackDamage = _attackDamage;
        enchantability = _enchantability;
        repairItem = _oreIngot.getItem();
        attackSpeed = _attackSpeed;
    }

    public void registerOreTools(final RegistryEvent.Register<Item> _itemRegistryEvent) {
        _itemRegistryEvent.getRegistry().registerAll(
                this.setupSword(),
                this.setupTool(ToolType.PICKAXE),
                this.setupTool(ToolType.AXE),
                this.setupTool(ToolType.SHOVEL),
                this.setupTool(ToolType.HOE)
        );
    }

    private Item setupSword() {
        return setup(oreName+"_sword", new SwordItem(this, 4, attackSpeed, new Item.Properties().group(ItemGroup.COMBAT)));
    }

    private Item setupTool(ToolType _toolType) {
        if (_toolType.equals(ToolType.PICKAXE))
            return setup(oreName+"_pickaxe", new PickaxeItem(this, 6, 1.0f, new Item.Properties().group(ItemGroup.TOOLS)));
        else if (_toolType.equals(ToolType.AXE))
            return setup(oreName+"_axe", new AxeItem(this, 6, 1.0f, new Item.Properties().group(ItemGroup.TOOLS)));
        else if (_toolType.equals(ToolType.SHOVEL))
            return setup(oreName+"_shovel", new ShovelItem(this, 6, 1.0f, new Item.Properties().group(ItemGroup.TOOLS)));
        else
            return setup(oreName+"_hoe", new HoeItem(this, 6, 1.0f, new Item.Properties().group(ItemGroup.TOOLS)));
    }

    @Override
    public int getHarvestLevel() {
        return harvestLevel;
    }

    @Override
    public int getMaxUses() {
        return maxUses;
    }

    @Override
    public float getEfficiency() {
        return efficiency;
    }

    @Override
    public float getAttackDamage() {
        return attackDamage;
    }

    @Override
    public int getEnchantability() {
        return enchantability;
    }

    @Override
    public Ingredient getRepairMaterial() {
        return Ingredient.fromItems(repairItem);
    }

}
