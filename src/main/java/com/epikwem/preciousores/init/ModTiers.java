
package com.epikwem.preciousores.init;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import org.jetbrains.annotations.NotNull;

public class ModTiers
{

    public static final ModTier
            BLAZINGGOLD = new ModTier ("blazinggold",
                    751,
                    2,
                    6,
                    ModItems.BLAZINGGOLD_INGOT),

            OBSIDIANITE = new ModTier ("obsidianite",
                    1956,
                    3,
                    12,
                    ModItems.OBSIDIANITE),

            SHININGGOLD = new ModTier ("shininggold",
                    472,
                     1,
                     24,
                     ModItems.SHININGGOLD_SHARD),

            SILVER = new ModTier ("silver",
                    122,
                    2,
                    18,
                    ModItems.SILVER_INGOT);

    public static class ModTier implements Tier
    {
        private final String ore_name;
        private final int durability;
        private final float attack_speed;
        private final float attack_damage;
        private final int level;
        private final int ench_value;
        private final Ingredient repair_ingredient;

        public ModTier(final String ore_name, int durability, int level, int ench_value, final Item repair_item) {
            this.ore_name = ore_name;
            this.durability = durability;
            this.attack_speed = 0;
            this.attack_damage = 0;
            this.level = level;
            this.ench_value = ench_value;
            this.repair_ingredient = Ingredient.of(repair_item);
        }

        public String getOreName()
        {
            return ore_name;
        }

        @Override
        public int getUses() {
            return durability;
        }

        @Override
        public float getSpeed() {
            return attack_speed;
        }

        @Override
        public float getAttackDamageBonus() {
            return attack_damage;
        }

        @Override
        public int getLevel() {
            return level;
        }

        @Override
        public int getEnchantmentValue() {
            return ench_value;
        }

        @Override
        public @NotNull Ingredient getRepairIngredient() {
            return repair_ingredient;
        }
    }
}
