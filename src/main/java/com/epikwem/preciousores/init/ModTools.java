
package com.epikwem.preciousores.init;

import com.epikwem.preciousores.content.SilverSword;
import net.minecraft.item.*;
import net.minecraft.item.crafting.Ingredient;
import net.minecraftforge.event.RegistryEvent;

import static com.epikwem.preciousores.Main.setup;

public enum ModTools implements IItemTier {

    BLAZINGGOLD ("blazinggold",
            2,
            1125,
            0.0f,
            2,
            0,
            ModItems.BLAZINGGOLD_INGOT,
            1.0f),

    SHININGGOLD ("shininggold",
             2,
             876,
             0.0f,
             2,
             0,
             ModItems.SHININGGOLD_CRYSTAL,
            1.0f),

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

    ModTools(String _oreName, int _harvestLevel, int _maxUses, float _efficiency, int _attackDamage, int _enchantability, final Item _repairItem, float _attackSpeed) {
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
            setup(oreName+"_pickaxe", new PickaxeItem(this, 6, 1.0f, properties) ),
            setup(oreName+"_axe", new AxeItem(this, 6, 1.0f, properties) ),
            setup(oreName+"_shovel", new ShovelItem(this, 6, 1.0f, properties) ),
            setup(oreName+"_hoe", new HoeItem(this, 6, 1.0f, properties) )
        );
        _itemRegistryEvent.getRegistry().register( setup(oreName+"_sword", (
            this.equals(SILVER) ?
            new SilverSword() :
            new SwordItem(this, 4, attackSpeed, new Item.Properties().group(ItemGroup.COMBAT))
        ) ) );
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

    public float getAttackSpeed() {
        return attackSpeed;
    }

}
