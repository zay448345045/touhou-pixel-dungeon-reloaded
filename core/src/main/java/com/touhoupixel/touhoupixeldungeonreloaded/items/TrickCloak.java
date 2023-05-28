/*
 * Pixel Dungeon
 * Copyright (C) 2012-2015 Oleg Dolya
 *
 * Shattered Pixel Dungeon
 * Copyright (C) 2014-2021 Evan Debenham
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

package com.touhoupixel.touhoupixeldungeonreloaded.items;

import com.touhoupixel.touhoupixeldungeonreloaded.Dungeon;
import com.touhoupixel.touhoupixeldungeonreloaded.Statistics;
import com.touhoupixel.touhoupixeldungeonreloaded.actors.Char;
import com.touhoupixel.touhoupixeldungeonreloaded.actors.buffs.Bless;
import com.touhoupixel.touhoupixeldungeonreloaded.actors.buffs.Buff;
import com.touhoupixel.touhoupixeldungeonreloaded.actors.buffs.Cripple;
import com.touhoupixel.touhoupixeldungeonreloaded.actors.buffs.CursedBlow;
import com.touhoupixel.touhoupixeldungeonreloaded.actors.buffs.Degrade;
import com.touhoupixel.touhoupixeldungeonreloaded.actors.buffs.Doom;
import com.touhoupixel.touhoupixeldungeonreloaded.actors.buffs.Doublerainbow;
import com.touhoupixel.touhoupixeldungeonreloaded.actors.buffs.Drowsy;
import com.touhoupixel.touhoupixeldungeonreloaded.actors.buffs.ExtremeConfusion;
import com.touhoupixel.touhoupixeldungeonreloaded.actors.buffs.Happy;
import com.touhoupixel.touhoupixeldungeonreloaded.actors.buffs.Haste;
import com.touhoupixel.touhoupixeldungeonreloaded.actors.buffs.Hex;
import com.touhoupixel.touhoupixeldungeonreloaded.actors.buffs.HexCancel;
import com.touhoupixel.touhoupixeldungeonreloaded.actors.buffs.HighStress;
import com.touhoupixel.touhoupixeldungeonreloaded.actors.buffs.Hisou;
import com.touhoupixel.touhoupixeldungeonreloaded.actors.buffs.HomingBlade;
import com.touhoupixel.touhoupixeldungeonreloaded.actors.buffs.Inversion;
import com.touhoupixel.touhoupixeldungeonreloaded.actors.buffs.Invisibility;
import com.touhoupixel.touhoupixeldungeonreloaded.actors.buffs.MagicBuff;
import com.touhoupixel.touhoupixeldungeonreloaded.actors.buffs.Might;
import com.touhoupixel.touhoupixeldungeonreloaded.actors.buffs.Poison;
import com.touhoupixel.touhoupixeldungeonreloaded.actors.buffs.PotionFreeze;
import com.touhoupixel.touhoupixeldungeonreloaded.actors.buffs.RemiliaFate;
import com.touhoupixel.touhoupixeldungeonreloaded.actors.buffs.RouletteStop;
import com.touhoupixel.touhoupixeldungeonreloaded.actors.buffs.Slow;
import com.touhoupixel.touhoupixeldungeonreloaded.actors.buffs.Vertigo;
import com.touhoupixel.touhoupixeldungeonreloaded.actors.buffs.Vulnerable;
import com.touhoupixel.touhoupixeldungeonreloaded.actors.buffs.Weakness;
import com.touhoupixel.touhoupixeldungeonreloaded.actors.hero.Hero;
import com.touhoupixel.touhoupixeldungeonreloaded.actors.mobs.Mob;
import com.touhoupixel.touhoupixeldungeonreloaded.items.scrolls.exotic.ScrollOfTeleportation;
import com.touhoupixel.touhoupixeldungeonreloaded.levels.Terrain;
import com.touhoupixel.touhoupixeldungeonreloaded.messages.Messages;
import com.touhoupixel.touhoupixeldungeonreloaded.sprites.ItemSpriteSheet;
import com.touhoupixel.touhoupixeldungeonreloaded.utils.GLog;
import com.watabou.utils.Random;

import java.util.ArrayList;

public class TrickCloak extends Item {

	private static final String AC_DRINK = "DRINK";

	{
		image = ItemSpriteSheet.TRICK_CLOAK;

		defaultAction = AC_DRINK;

		stackable = true;
		unique = true;
	}

	@Override
	public ArrayList<String> actions(Hero hero) {
		ArrayList<String> actions = super.actions(hero);
		actions.add(AC_DRINK);
		return actions;
	}

	@Override
	public void execute(final Hero hero, String action) {

		super.execute(hero, action);

		if (action.equals(AC_DRINK)) {
			if (Dungeon.level.map[curUser.pos] == Terrain.EMPTY){
				//A safer, low-return bet
				curUser.spendAndNext(1f);
				curItem.detach(curUser.belongings.backpack);
				Buff.prolong(curUser, RouletteStop.class, RouletteStop.DURATION);
				if (Random.Int(2) == 0){
					//bad
					switch (Random.Int(5)) {
						case 0:
						default:
							Buff.prolong(curUser, Weakness.class, Weakness.DURATION);
							GLog.n( Messages.get(this, "bad_1") );
							break;
						case 1:
							Buff.prolong(curUser, Vulnerable.class, Vulnerable.DURATION);
							GLog.n( Messages.get(this, "bad_2") );
							break;
						case 2:
							Buff.prolong(curUser, Hex.class, Hex.DURATION);
							GLog.n( Messages.get(this, "bad_3") );
							break;
						case 3:
							Buff.prolong(curUser, Cripple.class, Cripple.DURATION);
							GLog.n( Messages.get(this, "bad_4") );
							break;
						case 4:
							Buff.prolong(curUser, PotionFreeze.class, PotionFreeze.DURATION);
							GLog.n( Messages.get(this, "bad_5") );
							break;
					}
				} else {
					//good
					switch (Random.Int(5)) {
						case 0:
						default:
							Dungeon.gold += 500;
							Dungeon.energy += 5;
							GLog.p( Messages.get(this, "good_1") );
							break;
						case 1:
							Buff.prolong(curUser, Might.class, Might.DURATION);
							GLog.p( Messages.get(this, "good_2") );
							break;
						case 2:
							Buff.prolong(curUser, Bless.class, Bless.DURATION);
							GLog.p( Messages.get(this, "good_3") );
							break;
						case 3:
							Buff.prolong(curUser, MagicBuff.class, MagicBuff.DURATION);
							GLog.p( Messages.get(this, "good_4") );
							break;
						case 4:
							Buff.prolong(curUser, HexCancel.class, HexCancel.DURATION);
							GLog.p( Messages.get(this, "good_5") );
							break;
					}
				}
			} else if (Dungeon.level.map[curUser.pos] == Terrain.EMPTY_SP){
				//A risky, higher-return bet
				curUser.spendAndNext(1f);
				curItem.detach(curUser.belongings.backpack);
				Buff.prolong(curUser, RouletteStop.class, RouletteStop.DURATION);
				if (Random.Int(2) == 0){
					//bad
					switch (Random.Int(5)) {
						case 0:
						default:
							Dungeon.gold = 0;
							Dungeon.energy = 0;
							GLog.n( Messages.get(this, "bad_6") );
							break;
						case 1:
							Buff.prolong(curUser, ExtremeConfusion.class, ExtremeConfusion.DURATION);
							GLog.n( Messages.get(this, "bad_7") );
							break;
						case 2:
							Buff.prolong(curUser, CursedBlow.class, CursedBlow.DURATION);
							GLog.n( Messages.get(this, "bad_8") );
							break;
						case 3:
							Buff.prolong(curUser, Degrade.class, Degrade.DURATION);
							GLog.n( Messages.get(this, "bad_9") );
							break;
						case 4:
							Buff.prolong(curUser, Inversion.class, Inversion.DURATION);
							GLog.n( Messages.get(this, "bad_10") );
							break;
					}
				} else {
					//good
					switch (Random.Int(5)) {
						case 0:
						default:
							Dungeon.gold += 1500;
							Dungeon.energy += 15;
							GLog.p( Messages.get(this, "good_6") );
							break;
						case 1:
							Buff.prolong(curUser, Hisou.class, Hisou.DURATION);
							GLog.p( Messages.get(this, "good_7") );
							break;
						case 2:
							Buff.prolong(curUser, Doublerainbow.class, Doublerainbow.DURATION);
							GLog.p( Messages.get(this, "good_8") );
							break;
						case 3:
							Buff.prolong(curUser, Haste.class, Haste.DURATION);
							GLog.p( Messages.get(this, "good_9") );
							break;
						case 4:
							Buff.prolong(curUser, HomingBlade.class, HomingBlade.DURATION);
							GLog.p( Messages.get(this, "good_10") );
							break;
					}
				}
			} else {
				GLog.n( Messages.get(this, "no_effect") );
			}
		}
	}

	@Override
	public boolean isUpgradable() {
		return false;
	}

	@Override
	public boolean isIdentified() {
		return true;
	}
}