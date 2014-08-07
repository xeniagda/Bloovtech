package com.loovjo.bloovtech.block;

import java.util.ArrayList;
import java.util.Arrays;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.BlockWorkbench;
import net.minecraft.block.material.Material;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import com.loovjo.bloovtech.BloovMain;
import com.loovjo.bloovtech.tileentity.TileEntityCustomCraftingTable;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockCustomCraftingTable extends BlockContainer {

	public Block type;
	private Item i;

	public BlockCustomCraftingTable(Block type) {
		super(Material.wood);
		this.type = type;
		useNeighborBrightness = true;

	}

	public void setI(Item i) {
		this.i = i;
	}

	public boolean onBlockActivated(World p_149727_1_, int p_149727_2_,
			int p_149727_3_, int p_149727_4_, EntityPlayer p_149727_5_,
			int p_149727_6_, float p_149727_7_, float p_149727_8_,
			float p_149727_9_) {
		if (p_149727_1_.isRemote) {
			return true;
		} else {
			p_149727_5_.openGui(BloovMain.instance, 3, p_149727_1_,
					p_149727_2_, p_149727_3_, p_149727_4_);
			return true;
		}
	}

	@Override
	public ArrayList<ItemStack> getDrops(World world, int x, int y, int z,
			int metadata, int fortune) {
		// TODO Auto-generated method stub
		return new ArrayList<ItemStack>(
				Arrays.asList(new ItemStack[] { new ItemStack(i) }));
	}

	@Override
	public IIcon getIcon(int p_149691_1_, int p_149691_2_) {

		return type.getIcon(p_149691_1_, p_149691_2_);
	}

	@Override
	public boolean shouldSideBeRendered(IBlockAccess p_149646_1_,
			int p_149646_2_, int p_149646_3_, int p_149646_4_, int p_149646_5_) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public TileEntity createNewTileEntity(World var1, int var2) {
		return new TileEntityCustomCraftingTable(type);
	}

	@SideOnly(Side.CLIENT)
	public Item getItem(World p_149694_1_, int p_149694_2_, int p_149694_3_,
			int p_149694_4_) {
		return i;
	}
}
