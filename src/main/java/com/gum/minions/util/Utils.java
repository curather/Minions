package com.gum.minions.util;

import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.nbt.ListNBT;
import net.minecraft.util.math.BlockPos;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Utils {
    public static Random rand = new Random();

    public static void printLogger(String value) {
        System.out.println(value);
    }

    public static int random(int min, int max) {

        return (rand.nextInt(max - min) + min);
    }

    public static int random(int number) {

        return (rand.nextInt(number));
    }


    public static List<Integer> oldIdToIntArray(String oldid) {
        String oldidfull = oldid.replace("-", "");

        List<Integer> parts = getIntegerParts(oldidfull, 8);
        return parts;
        //return getConvertedUUID(parts.toArray(new Integer[parts.size()]));
    }

    private static List<Integer> getIntegerParts(String string, int partitionSize) {
        List<Integer> parts = new ArrayList<Integer>();
        int len = string.length();
        for (int i = 0; i < len; i += partitionSize) {
            parts.add(partToDecimalValue(string.substring(i, Math.min(len, i + partitionSize))));
        }
        return parts;
    }

    private static int partToDecimalValue(String hex) {
        int decimal = Long.valueOf(hex, 16).intValue();
        return decimal;
    }

    public static double getDistanceToEntity(Entity entity, BlockPos pos) {
        double deltaX = entity.blockPosition().getX() - pos.getX();
        double deltaY = entity.blockPosition().getY() - pos.getY();
        double deltaZ = entity.blockPosition().getZ() - pos.getZ();

        return Math.sqrt((deltaX * deltaX) + (deltaY * deltaY) + (deltaZ * deltaZ));
    }

    public static ItemStack getTexturedHead(String texture, String oldid, Integer amount) {
        ItemStack texturedhead = new ItemStack(Items.PLAYER_HEAD, amount);

        List<Integer> intarray = Utils.oldIdToIntArray(oldid);

        CompoundNBT skullOwner = new CompoundNBT();
        skullOwner.putIntArray("Id", intarray);

        CompoundNBT properties = new CompoundNBT();
        ListNBT textures = new ListNBT();
        CompoundNBT tex = new CompoundNBT();
        tex.putString("Value", texture);
        textures.add(tex);

        properties.put("textures", textures);
        skullOwner.put("Properties", properties);
        texturedhead.addTagElement("SkullOwner", skullOwner);
        return texturedhead;
    }



}
