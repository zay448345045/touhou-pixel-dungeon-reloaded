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

package com.touhoupixel.touhoupixeldungeonreloaded.levels;

import com.touhoupixel.touhoupixeldungeonreloaded.Assets;
import com.touhoupixel.touhoupixeldungeonreloaded.Dungeon;
import com.touhoupixel.touhoupixeldungeonreloaded.items.Generator;
import com.touhoupixel.touhoupixeldungeonreloaded.levels.painters.Painter;
import com.touhoupixel.touhoupixeldungeonreloaded.levels.painters.TouhouPainter;
import com.touhoupixel.touhoupixeldungeonreloaded.levels.traps.AlarmTrap;
import com.touhoupixel.touhoupixeldungeonreloaded.levels.traps.AntiMDTrap;
import com.touhoupixel.touhoupixeldungeonreloaded.levels.traps.BalanceTrap;
import com.touhoupixel.touhoupixeldungeonreloaded.levels.traps.BurningTrap;
import com.touhoupixel.touhoupixeldungeonreloaded.levels.traps.ChillingTrap;
import com.touhoupixel.touhoupixeldungeonreloaded.levels.traps.ConfusionTrap;
import com.touhoupixel.touhoupixeldungeonreloaded.levels.traps.OnigiriTrap;
import com.touhoupixel.touhoupixeldungeonreloaded.levels.traps.ExConfusionTrap;
import com.touhoupixel.touhoupixeldungeonreloaded.levels.traps.PoisonDartTrap;
import com.touhoupixel.touhoupixeldungeonreloaded.levels.traps.RockfallTrap;
import com.touhoupixel.touhoupixeldungeonreloaded.levels.traps.SlowTrap;
import com.touhoupixel.touhoupixeldungeonreloaded.levels.traps.SummoningTrap;
import com.touhoupixel.touhoupixeldungeonreloaded.levels.traps.TeleportationTrap;
import com.touhoupixel.touhoupixeldungeonreloaded.tiles.DungeonTilemap;
import com.watabou.noosa.Game;
import com.watabou.noosa.Group;
import com.watabou.noosa.audio.Music;
import com.watabou.noosa.particles.PixelParticle;
import com.watabou.utils.PointF;
import com.watabou.utils.Random;

public class MistyLakeLevel extends RegularLevel {

	{
		viewDistance = 8;

		color1 = 0x534f3e;
		color2 = 0xb9d661;
	}

	@Override
	public void playLevelMusic() {
		Music.INSTANCE.playTracks(
				new String[]{Assets.Music.FLOOR_3, Assets.Music.FLOOR_3, Assets.Music.FLOOR_3},
				new float[]{1, 1, 0.5f},
				false);
	}
	
	@Override
	protected int standardRooms(boolean forceMax) {
		if (forceMax) return 7;
		//6 to 7, average 6.333
		return 6+Random.chances(new float[]{2, 1});
	}
	
	@Override
	protected int specialRooms(boolean forceMax) {
		if (forceMax) return 3;
		//2 to 3, average 2.2
		return 2+Random.chances(new float[]{4, 1});
	}

	@Override
	protected Painter painter() {
		return new TouhouPainter()
				.setWater(feeling == Feeling.WATER ? 0.7f : 0.15f, 5)
				.setGrass(feeling == Feeling.GRASS ? 0.7f : 0.15f, 5)
				.setTraps(nTraps(), trapClasses(), trapChances());
	}

	@Override
	public void create() {
		itemsToSpawn.add( Generator.random(Generator.Category.POTION));
		itemsToSpawn.add( Generator.random(Generator.Category.SCROLL));
		super.create();
	}
	
	@Override
	public String tilesTex() {
		return Assets.Environment.TILES_3;
	}
	
	@Override
	public String waterTex() {
		return Assets.Environment.WATER_3;
	}

	@Override
	protected Class<?>[] trapClasses() {
		return new Class[]{
				ConfusionTrap.class, ChillingTrap.class, TeleportationTrap.class, ExConfusionTrap.class, RockfallTrap.class,
				SlowTrap.class, BalanceTrap.class, AlarmTrap.class, OnigiriTrap.class, PoisonDartTrap.class, AntiMDTrap.class,
				PoisonDartTrap.class, SummoningTrap.class};
	}

	@Override
	protected float[] trapChances() {
		return new float[]{
				2, 2, 2, 2, 2,
				2, 2, 2, 1, 1, 2,
				1, 1};
	}
	
	@Override
	public Group addVisuals() {
		super.addVisuals();
		addCavesVisuals( this, visuals );
		return visuals;
	}
	
	public static void addCavesVisuals( Level level, Group group ) {
		for (int i=0; i < level.length(); i++) {
			if (level.map[i] == Terrain.WALL_DECO) {
				group.add( new Vein( i ) );
			}
		}
	}
	
	private static class Vein extends Group {
		
		private int pos;
		
		private float delay;
		
		public Vein( int pos ) {
			super();
			
			this.pos = pos;
			
			delay = Random.Float( 2 );
		}
		
		@Override
		public void update() {
			
			if (visible = (pos < Dungeon.level.heroFOV.length && Dungeon.level.heroFOV[pos])) {
				
				super.update();

				if ((delay -= Game.elapsed) <= 0) {

					//pickaxe can remove the ore, should remove the sparkling too.
					if (Dungeon.level.map[pos] != Terrain.WALL_DECO){
						kill();
						return;
					}
					
					delay = Random.Float();
					
					PointF p = DungeonTilemap.tileToWorld( pos );
					((Sparkle)recycle( Sparkle.class )).reset(
						p.x + Random.Float( DungeonTilemap.SIZE ),
						p.y + Random.Float( DungeonTilemap.SIZE ) );
				}
			}
		}
	}
	
	public static final class Sparkle extends PixelParticle {
		
		public void reset( float x, float y ) {
			revive();
			
			this.x = x;
			this.y = y;
			
			left = lifespan = 0.5f;
		}
		
		@Override
		public void update() {
			super.update();
			
			float p = left / lifespan;
			size( (am = p < 0.5f ? p * 2 : (1 - p) * 2) * 2 );
		}
	}
}