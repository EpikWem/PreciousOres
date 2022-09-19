
package com.epikwem.preciousores.content;

import com.epikwem.preciousores.init.ModItems;
import com.epikwem.preciousores.init.ModTools;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nullable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SilverSword extends SwordItem {

    public SilverSword() {
        super(ModTools.SILVER, 4, ModTools.SILVER.getAttackSpeed(), new Item.Properties().group(ItemGroup.COMBAT));
    }

    @Override
    public void onPlayerStoppedUsing(ItemStack _stack, World _world, LivingEntity _entity, int _timeLeft) {
        Map<Enchantment,Integer> oldEnchants = EnchantmentHelper.getEnchantments(_stack);
        _stack = addSilverEnchants(oldEnchants, _stack);
    }

    private static ItemStack addSilverEnchants(final Map<Enchantment,Integer> _oldEnchants, final ItemStack _stack) {
        if (_stack.isEmpty())
            return _stack;
        Map<Enchantment,Integer> enchMap = new HashMap<>(_oldEnchants);

        // smite +II
        int oldSmiteLevel = 0;
        if (enchMap.containsKey(Enchantments.SMITE)) {
            oldSmiteLevel = enchMap.get(Enchantments.SMITE);
            enchMap.remove(Enchantments.SMITE);
        }
        enchMap.put(Enchantments.SMITE, oldSmiteLevel+2);

        // fire aspect I
        if (!enchMap.containsKey(Enchantments.FIRE_ASPECT))
            enchMap.put(Enchantments.FIRE_ASPECT, 1);

        // + others
        if (enchMap.size() > 0)
            EnchantmentHelper.setEnchantments(enchMap, _stack);

        return _stack;
    }

    @Override
    @OnlyIn(Dist.CLIENT)
    public void addInformation(ItemStack _stack, @Nullable World _world, List<ITextComponent> _tooltip, ITooltipFlag _flag) {
        super.addInformation(_stack, _world, _tooltip, _flag);
        _tooltip.add( new TranslationTextComponent("tips.smite_tooltip")  );
    }

}
