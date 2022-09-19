
package com.epikwem.preciousores.content;

import com.epikwem.preciousores.init.ModTiers;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;

public class SilverSword extends SwordItem
{

    public SilverSword() {
        super(ModTiers.SILVER, 4, 6.5f, new Item.Properties().tab(CreativeModeTab.TAB_COMBAT));
    }

    @Override
    public boolean hurtEnemy(ItemStack p_43278_, LivingEntity p_43279_, LivingEntity p_43280_) {
        //if (p_43280_.getEntityData());
        return super.hurtEnemy(p_43278_, p_43279_, p_43280_);
    }


}
