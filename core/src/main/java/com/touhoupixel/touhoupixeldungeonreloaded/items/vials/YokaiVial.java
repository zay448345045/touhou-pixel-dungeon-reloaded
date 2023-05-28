package com.touhoupixel.touhoupixeldungeonreloaded.items.vials;

import com.touhoupixel.touhoupixeldungeonreloaded.Dungeon;
import com.touhoupixel.touhoupixeldungeonreloaded.actors.Actor;
import com.touhoupixel.touhoupixeldungeonreloaded.actors.Char;
import com.touhoupixel.touhoupixeldungeonreloaded.actors.buffs.Buff;
import com.touhoupixel.touhoupixeldungeonreloaded.actors.buffs.Might;
import com.touhoupixel.touhoupixeldungeonreloaded.actors.buffs.Slow;
import com.touhoupixel.touhoupixeldungeonreloaded.items.talismans.Talisman;
import com.touhoupixel.touhoupixeldungeonreloaded.plants.Swiftthistle;
import com.touhoupixel.touhoupixeldungeonreloaded.sprites.ItemSpriteSheet;

public class YokaiVial extends Vial {
    {
        image = ItemSpriteSheet.YOKAI_VIAL;
    }

    @Override
    protected void onThrow(int cell) {

        Char ch = Actor.findChar( cell );

        if (ch != null){
            if (ch.properties().contains(Char.Property.YOKAI)) {
                ch.damage(3*(Dungeon.hero.lvl+20), this);
                Buff.affect(curUser, Swiftthistle.TimeBubble.class);
                Buff.prolong(curUser, Might.class, Might.DURATION);
            } else {
                ch.damage(Dungeon.hero.lvl+20, this);
            }
        }
    }
}