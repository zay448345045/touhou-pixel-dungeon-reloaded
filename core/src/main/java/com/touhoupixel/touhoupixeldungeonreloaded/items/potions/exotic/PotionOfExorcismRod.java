package com.touhoupixel.touhoupixeldungeonreloaded.items.potions.exotic;

import com.touhoupixel.touhoupixeldungeonreloaded.Challenges;
import com.touhoupixel.touhoupixeldungeonreloaded.Dungeon;
import com.touhoupixel.touhoupixeldungeonreloaded.actors.buffs.Barkskin;
import com.touhoupixel.touhoupixeldungeonreloaded.actors.buffs.Buff;
import com.touhoupixel.touhoupixeldungeonreloaded.actors.buffs.ReachIncrease;
import com.touhoupixel.touhoupixeldungeonreloaded.actors.hero.Hero;
import com.touhoupixel.touhoupixeldungeonreloaded.sprites.ItemSpriteSheet;

public class PotionOfExorcismRod extends ExoticPotion {

    {
        icon = ItemSpriteSheet.Icons.POTION_DOUBLESPEED;
    }

    @Override
    public void apply( Hero hero ) {
        identify();
        Buff.prolong( hero, ReachIncrease.class, ReachIncrease.DURATION);
    }

}