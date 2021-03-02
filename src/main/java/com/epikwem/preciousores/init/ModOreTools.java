
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

public enum ModOreTools implements IItemTier {

    SILVER ("silver",
            2,
            1254,
            0.0f,
            2,
            0,
            ModItems.SILVER_INGOT,
            1.0f);

    private final String oreName;
    private final int harvestLevel;
    private final int maxUses;
    private final float efficiency;
    private final int attackDamage;
    private final int enchantability;
    private final Item repairItem;
    private final float attackSpeed;

    ModOreTools(String _oreName, int _harvestLevel, int _maxUses, float _efficiency, int _attackDamage, int _enchantability, final Item _repairItem, float _attackSpeed) {
        oreName = _oreName;
        harvestLevel = _harvestLevel;
        maxUses = _maxUses;
        efficiency = _efficiency;
        attackDamage = _attackDamage;
        enchantability = _enchantability;
        repairItem = _repairItem;
        attackSpeed = _attackSpeed;
    }

    public void registerOreTools(final RegistryEvent.Register<Item> _itemRegistryEvent) {
        final Item.Properties properties = new Item.Properties().group(ItemGroup.TOOLS);
        _itemRegistryEvent.getRegistry().registerAll(
            setup(oreName+"_sword", new SwordItem(this, 4, attackSpeed, new Item.Properties().group(ItemGroup.COMBAT)) ),
            setup(oreName+"_pickaxe", new PickaxeItem(this, 6, 1.0f, properties) ),
            setup(oreName+"_axe", new AxeItem(this, 6, 1.0f, properties) ),
            setup(oreName+"_shovel", new ShovelItem(this, 6, 1.0f, properties) ),
            setup(oreName+"_hoe", new HoeItem(this, 6, 1.0f, properties) )
        );
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
