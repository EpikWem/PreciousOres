
package com.epikwem.preciousores.init;

import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraftforge.event.RegistryEvent;

import static com.epikwem.preciousores.Main.setup;

public enum ModOreArmorMaterials implements IArmorMaterial {

    SILVER( ModIngots.SILVER_INGOT,
            18,
            new int[]{2, 5, 6, 2},
            20,
            SoundEvents.ITEM_ARMOR_EQUIP_GOLD,
            1.0F,
            0.0F );

    private static final int[] MAX_DAMAGE_ARRAY = new int[]{13, 15, 16, 11};

    private final String name;
    private final int maxDamageFactor;
    private final int[] damageReductionAmountArray;
    private final int enchantability;
    private final SoundEvent soundEvent;
    private final float toughness;
    private final float knockbackResistance;
    private final Item repairItem;

    ModOreArmorMaterials(final ModIngots _modIngot, int _maxDamageFactor, int[] _damageReductionAmountArray, int _enchantability, SoundEvent _soundEvent, float _toughness, float _knockbackResistance) {
        name = _modIngot.getOreName();
        maxDamageFactor = _maxDamageFactor;
        damageReductionAmountArray = _damageReductionAmountArray;
        enchantability = _enchantability;
        soundEvent = _soundEvent;
        toughness = _toughness;
        knockbackResistance = _knockbackResistance;
        repairItem = _modIngot.getItem();
    }

    public void registerOreArmors(final RegistryEvent.Register<Item> _itemRegistryEvent) {
        final Item.Properties properties = new Item.Properties().group(ItemGroup.COMBAT);
        _itemRegistryEvent.getRegistry().registerAll(
            setup(name+"_helmet", new ArmorItem(this, EquipmentSlotType.HEAD, properties)),
            setup(name+"_chestplate", new ArmorItem(this, EquipmentSlotType.CHEST, properties)),
            setup(name+"_leggings", new ArmorItem(this, EquipmentSlotType.LEGS, properties)),
            setup(name+"_boots", new ArmorItem(this, EquipmentSlotType.FEET, properties))
        );
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
