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
import com.touhoupixel.touhoupixeldungeonreloaded.actors.Char;
import com.touhoupixel.touhoupixeldungeonreloaded.sprites.ItemSpriteSheet;

public class SkySword extends MeleeWeapon {

	{
		image = ItemSpriteSheet.SKYSWORD;
		hitSound = Assets.Sounds.HIT_STAB;
		hitSoundPitch = 1.3f;

		tier = 3;
		DLY = 0.5f; //2x speed
	}

	@Override
	public int WarpFactor( Char owner ) {
		return 1;
	}

	@Override
	public int max(int lvl) {
		return  Math.round(3f*(tier+1)) +     //12 base, down from 20
				lvl*Math.round(0.65f*(tier+1));  //+2.6 per level, down from +4
	}
}