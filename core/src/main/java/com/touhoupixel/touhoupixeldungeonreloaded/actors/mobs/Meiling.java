package com.touhoupixel.touhoupixeldungeonreloaded.actors.mobs;

import com.touhoupixel.touhoupixeldungeonreloaded.Dungeon;
import com.touhoupixel.touhoupixeldungeonreloaded.Statistics;
import com.touhoupixel.touhoupixeldungeonreloaded.actors.Char;
import com.touhoupixel.touhoupixeldungeonreloaded.actors.buffs.Buff;
import com.touhoupixel.touhoupixeldungeonreloaded.actors.buffs.RegenBlock;
import com.touhoupixel.touhoupixeldungeonreloaded.actors.buffs.Roots;
import com.touhoupixel.touhoupixeldungeonreloaded.items.Generator;
import com.touhoupixel.touhoupixeldungeonreloaded.sprites.MeilingSprite;
import com.watabou.utils.Random;

public class Meiling extends Mob {

    {
        spriteClass = MeilingSprite.class;

        HP = HT = 54;
        defenseSkill = 15;
        EXP = 9;
        maxLvl = 22;

        properties.add(Property.YOKAI);

        loot = Generator.Category.TALISMAN;
        lootChance = 0.15f;
    }

    @Override
    public int damageRoll() {
        return Random.NormalIntRange(5, 9);
    }

    @Override
    public int attackSkill(Char target) {
        return 20;
    }

    @Override
    public int drRoll() {
        return Random.NormalIntRange(0, 2);
    }

    @Override
    public int attackProc(Char hero, int damage) {
        damage = super.attackProc(enemy, damage);
        if (enemy == Dungeon.hero && enemy.alignment != this.alignment && Random.Int(5) == 0){
            if (Statistics.difficulty > 2) {
                Buff.prolong(enemy, RegenBlock.class, RegenBlock.DURATION);
            }
        }
        return damage;
    }
}