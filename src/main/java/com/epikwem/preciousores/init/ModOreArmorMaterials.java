
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

    SILVER( "silver",
            18,
            new int[]{2, 5, 6, 2},
            20,
            SoundEvents.ITEM_ARMOR_EQUIP_GOLD,
            1.0F,
            0.0F,
            ModItems.SILVER_INGOT );

    private static final int[] MAX_DAMAGE_ARRAY = new int[]{13, 15, 16, 11};

    private final String oreName;
    private final int maxDamageFactor;
    private final int[] damageReductionAmountArray;
    private final int enchantability;
    private final SoundEvent soundEvent;
    private final float toughness;
    private final float knockbackResistance;
    private final Item repairItem;

    ModOreArmorMaterials(String _oreName, int _maxDamageFactor, int[] _damageReductionAmountArray, int _enchantability, SoundEvent _soundEvent, float _toughness, float _knockbackResistance, final Item _repairItem) {
        oreName = _oreName;
        maxDamageFactor = _maxDamageFactor;
        damageReductionAmountArray = _damageReductionAmountArray;
        enchantability = _enchantability;
        soundEvent = _soundEvent;
        toughness = _toughness;
        knockbackResistance = _knockbackResistance;
        repairItem = _repairItem;
    }

    public void registerOreArmors(final RegistryEvent.Register<Item> _itemRegistryEvent) {
        final Item.Properties properties = new Item.Properties().group(ItemGroup.COMBAT);
        _itemRegistryEvent.getRegistry().registerAll(
            setup(oreName+"_helmet", new ArmorItem(this, EquipmentSlotType.HEAD, properties)),
            setup(oreName+"_chestplate", new ArmorItem(this, EquipmentSlotType.CHEST, properties)),
            setup(oreName+"_leggings", new ArmorItem(this, EquipmentSlotType.LEGS, properties)),
            setup(oreName+"_boots", new ArmorItem(this, EquipmentSlotType.FEET, properties))
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
        return oreName;
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
