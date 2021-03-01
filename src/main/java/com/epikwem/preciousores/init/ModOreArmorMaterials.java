
package com.epikwem.preciousores.init;

import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;

public enum ModOreArmorMaterials implements IArmorMaterial {

    SILVER("silver",
            18,
            new int[]{2, 5, 6, 2},
            20,
            SoundEvents.ITEM_ARMOR_EQUIP_GOLD,
            1.0F,
            0.0F,
            ModIngots.SILVER_INGOT
    );

    private static final int[] MAX_DAMAGE_ARRAY = new int[]{13, 15, 16, 11};

    private final String name;
    private final int maxDamageFactor;
    private final int[] damageReductionAmountArray;
    private final int enchantability;
    private final SoundEvent soundEvent;
    private final float toughness;
    private final float knockbackResistance;
    private final Item repairItem;

    private ModOreArmorMaterials(String _name, int _maxDamageFactor, int[] _damageReductionAmountArray, int _enchantability, SoundEvent _soundEvent, float _toughness, float _knockbackResistance, Item _repairItem) {
        name = _name;
        maxDamageFactor = _maxDamageFactor;
        damageReductionAmountArray = _damageReductionAmountArray;
        enchantability = _enchantability;
        soundEvent = _soundEvent;
        toughness = _toughness;
        knockbackResistance = _knockbackResistance;
        repairItem = _repairItem;
    }

    @Override
    public int getDurability(EquipmentSlotType slotIn) {
        return MAX_DAMAGE_ARRAY[slotIn.getIndex()] * this.maxDamageFactor;
    }

    @Override
    public int getDamageReductionAmount(EquipmentSlotType slotIn) {
        return damageReductionAmountArray[slotIn.getIndex()];
    }

    @Override
    public int getEnchantability() {
        return enchantability;
    }

    @Override
    public SoundEvent getSoundEvent() {
        return soundEvent;
    }

    @Override
    public Ingredient getRepairMaterial() {
        return Ingredient.fromItems(repairItem);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public float getToughness() {
        return toughness;
    }

    @Override
    public float getKnockbackResistance() {
        return knockbackResistance;
    }
}
