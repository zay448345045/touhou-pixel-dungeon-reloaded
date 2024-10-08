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

package com.touhoupixel.touhoupixeldungeonreloaded.ui;

import com.touhoupixel.touhoupixeldungeonreloaded.Assets;
import com.touhoupixel.touhoupixeldungeonreloaded.Dungeon;
import com.touhoupixel.touhoupixeldungeonreloaded.actors.hero.HeroClass;
import com.touhoupixel.touhoupixeldungeonreloaded.levels.Level;
import com.touhoupixel.touhoupixeldungeonreloaded.scenes.PixelScene;
import com.watabou.noosa.Image;

public enum Icons {

	//title screen icons, variable sizes, spacing for 17x16
	ENTER,
	GOLD,
	RANKINGS,
	BADGES,
	NEWS,
	CHANGES,
	PREFS,
	SHPX,

	//rankings and hero select icons, spacing for 16x16
	STAIRS,
	PLAYERREIMU,
	PLAYERMARISA,
	PLAYERSANAE,
	PLAYERYOUMU,
	PLAYERSAKUYA,

	//grey icons, mainly used for buttons, spacing for 16x16
	EXIT,
	DISPLAY, //2 separate images, changes based on orientation
	DISPLAY_LAND,
	DISPLAY_PORT,
	DATA,
	AUDIO,
	LANGS,
	CONTROLLER,
	KEYBOARD,
	STATS,
	CHALLENGE_OFF,
	CHALLENGE_ON,
	RENAME_OFF,
	RENAME_ON,
	SEED,
	LEFTARROW,
	RIGHTARROW,
	CALENDAR,

	//misc icons, mainly used for buttons, spacing for 16x16 until the smaller icons at the end
	UNCHECKED,
	CHECKED,
	CLOSE,
	PLUS,
	ARROW,
	INFO,
	WARNING,
	BACKPACK_LRG,
	TALENT,
	MAGNIFY,
	BUFFS,
	ENERGY,
	COIN_SML,
	ENERGY_SML,
	BACKPACK,
	SANAE_HOLDER,
    MARISA_HOLDER,
	REIMU_HOLDER,
	REISEN_HOLDER,
	TALISMAN_HOLDER,
	CARD_HOLDER,

	//icons that appear in the game itself, variable spacing
	TARGET,
	SKULL,
	BUSY,
	COMPASS,
	SLEEP,
	ALERT,
	LOST,
	FLOOR,      //floor icons have two variants, for regular and seeded runs
	FLOOR_CHASM,
	FLOOR_WATER,
	FLOOR_GRASS,
	FLOOR_DARK,
	FLOOR_LARGE,
	FLOOR_TRAPS,
	FLOOR_SECRETS,
	CHAL_COUNT,
	SP_CHALLENGE,

	//icons that appear in the about screen, variable spacing
	LIBGDX,
	ALEKS,
	WATA,
	CELESTI,
	KRISTJAN,
	CUBE_CODE,
	PURIGRO,
	ARCNOR,

	// Icon for ActionIndicator
	YOUMU_ABILITY;

	public Image get() {
		return get( this );
	}
	
	public static Image get( Icons type ) {
		Image icon = new Image( Assets.Interfaces.ICONS );
		switch (type) {

			case ENTER:
				icon.frame( icon.texture.uvRectBySize( 0, 0, 16, 16 ) );
				break;
			case GOLD:
				icon.frame( icon.texture.uvRectBySize( 17, 0, 17, 16 ) );
				break;
			case RANKINGS:
				icon.frame( icon.texture.uvRectBySize( 34, 0, 17, 16 ) );
				break;
			case BADGES:
				icon.frame( icon.texture.uvRectBySize( 51, 0, 16, 16 ) );
				break;
			case NEWS:
				icon.frame( icon.texture.uvRectBySize( 68, 0, 16, 15 ) );
				break;
			case CHANGES:
				icon.frame( icon.texture.uvRectBySize( 85, 0, 15, 15 ) );
				break;
			case PREFS:
				icon.frame( icon.texture.uvRectBySize( 102, 0, 14, 14 ) );
				break;
			case SHPX:
				icon.frame( icon.texture.uvRectBySize( 119, 0, 16, 16 ) );
				break;

			case STAIRS:
				icon.frame( icon.texture.uvRectBySize( 0, 16, 13, 16 ) );
				break;
			case PLAYERREIMU:
			case PLAYERMARISA:
			case PLAYERSANAE:
			case PLAYERYOUMU:
			case PLAYERSAKUYA:
				icon.frame( icon.texture.uvRectBySize( 16, 16, 9, 15 ) );
				break;

			case EXIT:
				icon.frame( icon.texture.uvRectBySize( 0, 32, 15, 11 ) );
				break;
			case DISPLAY:
				if (!PixelScene.landscape()){
					return get(DISPLAY_PORT);
				} else {
					return get(DISPLAY_LAND);
				}
			case DISPLAY_PORT:
				icon.frame( icon.texture.uvRectBySize( 16, 32, 12, 16 ) );
				break;
			case DISPLAY_LAND:
				icon.frame( icon.texture.uvRectBySize( 32, 32, 16, 12 ) );
				break;
			case DATA:
				icon.frame( icon.texture.uvRectBySize( 48, 32, 14, 15 ) );
				break;
			case AUDIO:
				icon.frame( icon.texture.uvRectBySize( 64, 32, 14, 14 ) );
				break;
			case LANGS:
				icon.frame( icon.texture.uvRectBySize( 80, 32, 14, 11 ) );
				break;
			case CONTROLLER:
				icon.frame( icon.texture.uvRectBySize( 96, 32, 16, 12 ) );
				break;
			case KEYBOARD:
				icon.frame( icon.texture.uvRectBySize( 112, 32, 15, 12 ) );
				break;
			case STATS:
				icon.frame( icon.texture.uvRectBySize( 128, 32, 16, 13 ) );
				break;
			case CHALLENGE_OFF:
				icon.frame( icon.texture.uvRectBySize( 144, 32, 15, 12 ) );
				break;
			case CHALLENGE_ON:
				icon.frame( icon.texture.uvRectBySize( 160, 32, 15, 12 ) );
				break;
			case RENAME_OFF:
				icon.frame( icon.texture.uvRectBySize( 176, 32, 15, 14 ) );
				break;
			case RENAME_ON:
				icon.frame( icon.texture.uvRectBySize( 192, 32, 15, 14 ) );
				break;
			case SEED:
				icon.frame( icon.texture.uvRectBySize( 208, 32, 15, 10 ) );
				break;
			case LEFTARROW:
				icon.frame( icon.texture.uvRectBySize( 224, 32, 14, 8 ) );
				break;
			case RIGHTARROW:
				icon.frame( icon.texture.uvRectBySize( 240, 32, 14, 8 ) );
				break;
			case CALENDAR:
				icon.frame( icon.texture.uvRectBySize( 240, 16, 15, 12 ) );
				break;

			case UNCHECKED:
				icon.frame( icon.texture.uvRectBySize( 0, 48, 12, 12 ) );
				break;
			case CHECKED:
				icon.frame( icon.texture.uvRectBySize( 16, 48, 12, 12 ) );
				break;
			case CLOSE:
				icon.frame( icon.texture.uvRectBySize( 32, 48, 11, 11 ) );
				break;
			case PLUS:
				icon.frame( icon.texture.uvRectBySize( 48, 48, 11, 11 ) );
				break;
			case ARROW:
				icon.frame( icon.texture.uvRectBySize( 64, 48, 11, 11 ) );
				break;
			case INFO:
				icon.frame( icon.texture.uvRectBySize( 80, 48, 14, 14 ) );
				break;
			case WARNING:
				icon.frame( icon.texture.uvRectBySize( 96, 48, 14, 14 ) );
				break;
			case BACKPACK_LRG:
				icon.frame( icon.texture.uvRectBySize( 112, 48, 16, 16 ) );
				break;
			case TALENT:
				icon.frame( icon.texture.uvRectBySize( 128, 48, 13, 13 ) );
				break;
			case MAGNIFY:
				icon.frame( icon.texture.uvRectBySize( 144, 48, 14, 14 ) );
				break;
			case BUFFS:
				icon.frame( icon.texture.uvRectBySize( 160, 48, 16, 15 ) );
				break;
			case ENERGY:
				icon.frame( icon.texture.uvRectBySize( 176, 48, 16, 16 ) );
				break;
			case COIN_SML:
				icon.frame( icon.texture.uvRectBySize( 192, 48, 7, 7 ) );
				break;
			case ENERGY_SML:
				icon.frame( icon.texture.uvRectBySize( 192, 56, 8, 7 ) );
				break;
			case BACKPACK:
				icon.frame( icon.texture.uvRectBySize( 201, 48, 10, 10 ) );
				break;
			case MARISA_HOLDER:
				icon.frame( icon.texture.uvRectBySize( 211, 48, 10, 10 ) );
				break;
			case SANAE_HOLDER:
				icon.frame( icon.texture.uvRectBySize( 221, 48, 10, 10 ) );
				break;
			case REIMU_HOLDER:
				icon.frame( icon.texture.uvRectBySize( 231, 48, 10, 10 ) );
				break;
			case REISEN_HOLDER:
				icon.frame( icon.texture.uvRectBySize( 241, 48, 10, 10 ) );
				break;
			case TALISMAN_HOLDER:
				icon.frame( icon.texture.uvRectBySize( 201, 58, 10, 10 ) );
				break;
			case CARD_HOLDER:
				icon.frame( icon.texture.uvRectBySize( 211, 58, 10, 10 ) );
				break;


			case TARGET:
				icon.frame( icon.texture.uvRectBySize( 0, 64, 16, 16 ) );
				break;
			case SKULL:
				icon.frame( icon.texture.uvRectBySize( 16, 64, 8, 8 ) );
				break;
			case BUSY:
				icon.frame( icon.texture.uvRectBySize( 24, 64, 8, 8 ) );
				break;
			case COMPASS:
				icon.frame( icon.texture.uvRectBySize( 16, 72, 7, 5 ) );
				break;
			case SLEEP:
				icon.frame( icon.texture.uvRectBySize( 32, 64, 9, 8 ) );
				break;
			case ALERT:
				icon.frame( icon.texture.uvRectBySize( 32, 72, 8, 8 ) );
				break;
			case LOST:
				icon.frame( icon.texture.uvRectBySize( 40, 72, 8, 8 ) );
				break;
			case FLOOR:
				int ofs = Dungeon.daily ? 16 : (!Dungeon.customSeedText.isEmpty() ? 8 : 0);
				icon.frame( icon.texture.uvRectBySize( 48, 64 + ofs, 6, 7 ) );
				break;
			case FLOOR_CHASM:
				ofs = Dungeon.daily ? 16 : (!Dungeon.customSeedText.isEmpty() ? 8 : 0);
				icon.frame( icon.texture.uvRectBySize( 56, 64 + ofs, 7, 7 ) );
				break;
			case FLOOR_WATER:
				ofs = Dungeon.daily ? 16 : (!Dungeon.customSeedText.isEmpty() ? 8 : 0);
				icon.frame( icon.texture.uvRectBySize( 64, 64 + ofs, 7, 7 ) );
				break;
			case FLOOR_GRASS:
				ofs = Dungeon.daily ? 16 : (!Dungeon.customSeedText.isEmpty() ? 8 : 0);
				icon.frame( icon.texture.uvRectBySize( 72, 64 + ofs, 7, 7 ) );
				break;
			case FLOOR_DARK:
				ofs = Dungeon.daily ? 16 : (!Dungeon.customSeedText.isEmpty() ? 8 : 0);
				icon.frame( icon.texture.uvRectBySize( 80, 64 + ofs, 7, 7 ) );
				break;
			case FLOOR_LARGE:
				ofs = Dungeon.daily ? 16 : (!Dungeon.customSeedText.isEmpty() ? 8 : 0);
				icon.frame( icon.texture.uvRectBySize( 88, 64 + ofs, 7, 7 ) );
				break;
			case FLOOR_TRAPS:
				ofs = Dungeon.daily ? 16 : (!Dungeon.customSeedText.isEmpty() ? 8 : 0);
				icon.frame( icon.texture.uvRectBySize( 96, 64 + ofs, 7, 7 ) );
				break;
			case FLOOR_SECRETS:
				ofs = Dungeon.daily ? 16 : (!Dungeon.customSeedText.isEmpty() ? 8 : 0);
				icon.frame( icon.texture.uvRectBySize( 104, 64 + ofs, 7, 7 ) );
				break;
			case CHAL_COUNT:
				icon.frame( icon.texture.uvRectBySize( 112, 64, 7, 7 ) );
				break;
			case SP_CHALLENGE:
				icon.frame( icon.texture.uvRectBySize( 119, 63, 9, 7 ) );
				break;
		
			case LIBGDX:
				icon.frame( icon.texture.uvRectBySize( 0, 96, 16, 13 ) );
				break;
			case ALEKS:
				icon.frame( icon.texture.uvRectBySize( 16, 96, 16, 13 ) );
				break;
			case WATA:
				icon.frame( icon.texture.uvRectBySize( 0, 112, 17, 12 ) );
				break;

			//large icons are scaled down to match game's size
			case CELESTI:
				icon.frame( icon.texture.uvRectBySize( 32, 96, 32, 32 ) );
				icon.scale.set(PixelScene.align(0.49f));
				break;
			case KRISTJAN:
				icon.frame( icon.texture.uvRectBySize( 64, 96, 32, 32 ) );
				icon.scale.set(PixelScene.align(0.49f));
				break;
			case ARCNOR:
				icon.frame( icon.texture.uvRectBySize( 96, 96, 32, 32 ) );
				icon.scale.set(PixelScene.align(0.49f));
				break;
			case PURIGRO:
				icon.frame( icon.texture.uvRectBySize( 128, 96, 32, 32 ) );
				icon.scale.set(PixelScene.align(0.49f));
				break;
			case CUBE_CODE:
				icon.frame( icon.texture.uvRectBySize( 160, 96, 27, 30 ) );
				icon.scale.set(PixelScene.align(0.49f));
				break;
			case YOUMU_ABILITY:
				icon.frame( icon.texture.uvRectBySize( 0, 80, 16, 16 ) );

		}
		return icon;
	}
	
	public static Image get( HeroClass cl ) {
		switch (cl) {
			case PLAYERREIMU:
				return get(PLAYERREIMU);
			case PLAYERMARISA:
				return get(PLAYERMARISA);
			case PLAYERSANAE:
				return get(PLAYERSANAE);
			case PLAYERYOUMU:
				return get(PLAYERYOUMU);
			case PLAYERSAKUYA:
				return get(PLAYERSAKUYA);
		default:
			return null;
		}
	}

	public static Image get(Level.Feeling feeling){
		switch (feeling){
			case NONE: default:
				return get(FLOOR);
			case CHASM:
				return get(FLOOR_CHASM);
			case WATER:
				return get(FLOOR_WATER);
			case GRASS:
				return get(FLOOR_GRASS);
			case DARK:
				return get(FLOOR_DARK);
			case LARGE:
				return get(FLOOR_LARGE);
			case TRAPS:
				return get(FLOOR_TRAPS);
			case SECRETS:
				return get(FLOOR_SECRETS);
		}
	}
}
