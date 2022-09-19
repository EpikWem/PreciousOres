
package com.epikwem.preciousores.init;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.crafting.Ingredient;

public class ModArmorMaterials
{

    public static final ModArmorMaterial
            BLAZINGGOLD = new ModArmorMaterial("blazinggold",
                    new int[]{3, 5, 6, 3},
                    16,
                    10,
                    SoundEvents.ARMOR_EQUIP_GOLD,
                    0.0f,
                    0.0f,
                    ModItems.BLAZINGGOLD_INGOT),

            OBSIDIANITE = new ModArmorMaterial("obsidianite",
                    new int[]{3, 5, 6, 3},
                    35,
                    6,
                    SoundEvents.ARMOR_EQUIP_NETHERITE,
                    1.0f,
                    1.5f,
                    ModItems.OBSIDIANITE),

            SHININGGOLD = new ModArmorMaterial("shininggold",
                    new int[]{3, 5, 6, 3},
                    9,
                    16,
                    SoundEvents.ARMOR_EQUIP_DIAMOND,
                    1.0f,
                    0.0f,
                    ModItems.SHININGGOLD_SHARD),

            SILVER = new ModArmorMaterial("silver",
                    new int[]{3, 5, 6, 3},
                    18,
                    20,
                    SoundEvents.ARMOR_EQUIP_IRON,
                    1.0f,
                    0.0f,
                    ModItems.SILVER_INGOT);

    private static class ModArmorMaterial implements ArmorMaterial
    {

        private final int[] defenses;
        private final int durability_multiplier;
        private final SoundEvent equip_sound;
        private final Ingredient repair_ingredient;
        private final String ore_name;
        private final int ench_value;
        private final float toughness;
        private final float knockbackResistance;

        private ModArmorMaterial(String ore_name, int[] defenses, int durability_multiplier, int ench_value, SoundEvent equip_sound, float toughness, float knockbackResistance, Item repair_item)
        {
            this.ore_name = ore_name;
            this.defenses = defenses;
            this.durability_multiplier = durability_multiplier;
            this.ench_value = ench_value;
            this.toughness = toughness;
            this.knockbackResistance = knockbackResistance;
            this.equip_sound = equip_sound;
            this.repair_ingredient = Ingredient.of(repair_item);
        }

        @Override
        public int getDurabilityForSlot(EquipmentSlot slot) {
            return (new int[]{13, 15, 16, 11})[slot.getIndex()] * durability_multiplier;
        }

        @Override
        public int getDefenseForSlot(EquipmentSlot slot) {
            return defenses[slot.getIndex()];
        }

        @Override
        public int getEnchantmentValue() {
            return ench_value;
        }

        @Override
        public SoundEvent getEquipSound() {
            return equip_sound;
        }

        @Override
        public Ingredient getRepairIngredient() {
            return repair_ingredient;
        }

        @Override
        public String getName() {
            return ore_name;
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

}
