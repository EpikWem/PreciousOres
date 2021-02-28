
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

public enum ModOreItemTier implements IItemTier {

    SILVER ("silver",
            2,
            1254,
            0.0f,
            2,
            0,
            ModIngots.SILVER_INGOT,
            MaterialColor.LIGHT_GRAY,
            6.0f,
            3.0f,
            1.0f);

    private final String oreName;
    private final int harvestLevel;
    private final int maxUses;
    private final float efficiency;
    private final int attackDamage;
    private final int enchantability;
    private final Item repairItem;
    private final MaterialColor color;
    private final float hardness;
    private final float blockResistance;
    private final float attackSpeed;

    private ModOreItemTier(String _oreName, int _harvestLevel, int _maxUses, float _efficiency, int _attackDamage, int _enchantability, Item _repairItem, MaterialColor _color, float _hardness, float _blockResistance, float _attackSpeed) {
        oreName = _oreName;
        harvestLevel = _harvestLevel;
        maxUses = _maxUses;
        efficiency = _efficiency;
        attackDamage = _attackDamage;
        enchantability = _enchantability;
        repairItem = _repairItem;
        color = _color;
        hardness = _hardness;
        blockResistance = _blockResistance;
        attackSpeed = _attackSpeed;
    }

    public void setupAllBlocks(final RegistryEvent.Register<Block> _blockRegistryEvent) {
        _blockRegistryEvent.getRegistry().registerAll(
                this.setupBlock(true),
                this.setupBlock(false)
        );
    }

    public void setupAllItems(final RegistryEvent.Register<Item> _itemRegistryEvent) {
        _itemRegistryEvent.getRegistry().registerAll(
                setup(oreName+"_ingot", _repairItem),
                this.setupItem("nugget"),
                this.setupSword(),
                this.setupTool(ToolType.PICKAXE),
                this.setupTool(ToolType.AXE),
                this.setupTool(ToolType.SHOVEL),
                this.setupTool(ToolType.HOE)
        );
    }

    public final Block setupBlock(boolean _wantOreBlock) {
        if (_wantOreBlock)
            return setup(oreName+"_ore", new OreBlock( Block.Properties
                    .create(Material.ROCK, color)
                    .sound(SoundType.NETHER_ORE)
                    .hardnessAndResistance(hardness, 3.0f)
                    .harvestLevel(harvestLevel)
                    .harvestTool(ToolType.PICKAXE) )
            );
        else
            return setup(oreName+"_block", new Block( Block.Properties
                .create(Material.IRON, color)
                .sound(SoundType.METAL)
                .hardnessAndResistance(hardness+2.0f, blockResistance)
                .harvestLevel(0)
                .harvestTool(ToolType.PICKAXE) )
            );
    }

    public final Item setupItem(String _type) {
        return setup(oreName+"_"+_type, new Item( new Item.Properties().group(ItemGroup.MATERIALS) ));
    }

    public final Item setupTool(ToolType _toolType) {
        if (_toolType.equals(ToolType.PICKAXE))
            return setup(oreName+"_pickaxe", new PickaxeItem(this, 6, 1.0f, new Item.Properties().group(ItemGroup.TOOLS)));
        else if (_toolType.equals(ToolType.AXE))
            return setup(oreName+"_axe", new AxeItem(this, 6, 1.0f, new Item.Properties().group(ItemGroup.TOOLS)));
        else if (_toolType.equals(ToolType.SHOVEL))
            return setup(oreName+"_shovel", new ShovelItem(this, 6, 1.0f, new Item.Properties().group(ItemGroup.TOOLS)));
        else
            return setup(oreName+"_hoe", new HoeItem(this, 6, 1.0f, new Item.Properties().group(ItemGroup.TOOLS)));
    }

    public final Item setupSword() {
        return setup(oreName+"_sword", new SwordItem(this, 4, attackSpeed, new Item.Properties().group(ItemGroup.COMBAT)));
    }

    public String getOreName() {
        return oreName;
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
    public Item getRepairItem() {
        return repairItem;
    }

    public MaterialColor getColor() {
        return color;
    }

    public float getHardness() {
        return hardness;
    }

    public float getBlockResistance() {
        return blockResistance;
    }

    public float getAttackSpeed() {
        return attackSpeed;
    }

}
