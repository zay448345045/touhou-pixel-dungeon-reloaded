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

package com.touhoupixel.touhoupixeldungeonreloaded;

import com.touhoupixel.touhoupixeldungeonreloaded.items.Item;

public class Difficulty {

	//Some of these internal IDs are outdated and don't represent what these challenges do
	public static final int EASY                = 1;
	public static final int NORMAL              = 2;
	public static final int HARD                = 4;
	public static final int LUNATIC		        = 8;
	public static final int OVERDRIVE           = 16;
	public static final int GENSOKYO_EXTINCTION = 32;

	public static final int MAX_VALUE           = 63;

	public static final String[] NAME_IDS = {
			"easy",
			"normal",
			"hard",
			"lunatic",
			"overdrive",
			"gensokyo_extinction"
	};

	public static final int[] MASKS = {
			EASY, NORMAL, HARD, LUNATIC, OVERDRIVE, GENSOKYO_EXTINCTION
	};
}