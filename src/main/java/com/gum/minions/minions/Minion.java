package com.gum.minions.minions;

import net.minecraft.block.Block;
import net.minecraft.item.Item;

import java.util.ArrayList;
import java.util.HashMap;

public interface Minion {
    void tick();

    int getTickCount();

    void setTickCount(int tickCount);

    int getNextAction();

    void setNextAction(int inputNextAction);

    Block getMinionType();

    void setMinionType(Block tmp);

    void setReturnItem(Item tmp);

    void setSpeed(int tmp);

    void setBonusItem(HashMap<Item, Float> tmp);

    void setReturnQuanity(int tmp);

    void setAlternatingCells(boolean tmp);

    ArrayList<String> getCurrentSaying();

    void setCurrentSaying(ArrayList<String> tmp);

    long getNextSayingEnd();

    void setNextSayingEnd(long tmp);

    AbstractMinionEntity getChatEntity();

    void setChatEntity(AbstractMinionEntity tmp);
}
