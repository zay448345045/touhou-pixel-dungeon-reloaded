package com.touhoupixel.touhoupixeldungeonreloaded.items.talismans;

import com.touhoupixel.touhoupixeldungeonreloaded.Dungeon;
import com.touhoupixel.touhoupixeldungeonreloaded.actors.Actor;
import com.touhoupixel.touhoupixeldungeonreloaded.actors.Char;
import com.touhoupixel.touhoupixeldungeonreloaded.actors.mobs.Mimic;
import com.touhoupixel.touhoupixeldungeonreloaded.actors.mobs.Mob;
import com.touhoupixel.touhoupixeldungeonreloaded.scenes.GameScene;
import com.touhoupixel.touhoupixeldungeonreloaded.sprites.ItemSpriteSheet;

import java.util.ArrayList;

public class ResetTalisman extends Talisman {
    {
        image = ItemSpriteSheet.RESET;
    }

    @Override
    protected void onThrow(int cell) {

        Char ch = Actor.findChar( cell );

        if (ch != null && !(ch instanceof Mimic) && ch != Dungeon.hero && !ch.properties().contains(Char.Property.MINIBOSS) && !ch.properties().contains(Char.Property.BOSS)){
            ArrayList<Mob> mobs = new ArrayList<>();
            Mob mob = Dungeon.level.createMob();
            mob.state = mob.WANDERING;
            mob.pos = ch.pos;
            GameScene.add(mob, 1f);
            mobs.add(mob);
            ch.die(null);
        }
    }
}