/*
 * Pixel Dungeon
 * Copyright (C) 2012-2015 Oleg Dolya
 *
 * Shattered Pixel Dungeon
 * Copyright (C) 2014-2022 Evan Debenham
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>
 */

package com.touhoupixel.touhoupixeldungeonreloaded.items.weapon.melee;

import com.touhoupixel.touhoupixeldungeonreloaded.Assets;
import com.touhoupixel.touhoupixeldungeonreloaded.Dungeon;
import com.touhoupixel.touhoupixeldungeonreloaded.actors.Char;
import com.touhoupixel.touhoupixeldungeonreloaded.actors.buffs.Buff;
import com.touhoupixel.touhoupixeldungeonreloaded.actors.buffs.MindVision;
import com.touhoupixel.touhoupixeldungeonreloaded.sprites.ItemSpriteSheet;
import com.watabou.noosa.audio.Sample;
import com.watabou.utils.Random;

public class AkyuuBrush extends MeleeWeapon {

    {
        image = ItemSpriteSheet.AKYUU_BRUSH;
        hitSound = Assets.Sounds.HIT_STRONG;
        hitSoundPitch = 1f;

        maxCharges = charges = 1;

        tier = 3;
    }


    @Override
    public int HumanFactor( Char owner ) {
        return 1;
    }


    @Override
    public int defenseFactor( Char owner ) {
        return Dungeon.heroine.buff(MindVision.class) != null ? 15 : 5;
    }

    @Override
    protected boolean activateAbility() {
        if (!super.activateAbility()) return false;
        Buff.prolong(Dungeon.heroine, MindVision.class, MindVision.DURATION);
        return true;
    }
}