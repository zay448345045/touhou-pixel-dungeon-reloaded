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
import com.touhoupixel.touhoupixeldungeonreloaded.levels.painters.Painter;
import com.touhoupixel.touhoupixeldungeonreloaded.levels.painters.TouhouPainter;
import com.touhoupixel.touhoupixeldungeonreloaded.levels.traps.AntiSneakTrap;
import com.touhoupixel.touhoupixeldungeonreloaded.levels.traps.BalanceTrap;
import com.touhoupixel.touhoupixeldungeonreloaded.levels.traps.BurningTrap;
import com.touhoupixel.touhoupixeldungeonreloaded.levels.traps.ChillingTrap;
import com.touhoupixel.touhoupixeldungeonreloaded.levels.traps.ConfusionTrap;
import com.touhoupixel.touhoupixeldungeonreloaded.levels.traps.EnchantEraseTrap;
import com.touhoupixel.touhoupixeldungeonreloaded.levels.traps.FlockTrap;
import com.touhoupixel.touhoupixeldungeonreloaded.levels.traps.SlowTrap;
import com.touhoupixel.touhoupixeldungeonreloaded.levels.traps.TeleportationTrap;
import com.touhoupixel.touhoupixeldungeonreloaded.levels.traps.ToxicTrap;
import com.touhoupixel.touhoupixeldungeonreloaded.messages.Messages;
import com.touhoupixel.touhoupixeldungeonreloaded.tiles.DungeonTilemap;
import com.watabou.noosa.Group;
import com.watabou.noosa.audio.Music;
import com.watabou.noosa.particles.Emitter;
import com.watabou.noosa.particles.PixelParticle;
import com.watabou.utils.PointF;
import com.watabou.utils.Random;

public class ForestofMagicLevel extends RegularLevel {

	{
		viewDistance = 8;

		color1 = 0x4b6636;
		color2 = 0xf2f2f2;
	}

	@Override
	public void playLevelMusic() {
		Music.INSTANCE.playTracks(
				new String[]{Assets.Music.FLOOR_4, Assets.Music.FLOOR_4, Assets.Music.FLOOR_4},
				new float[]{1, 1, 0.5f},
				false);
	}

	@Override
	protected int standardRooms(boolean forceMax) {
		if (forceMax) return 8;
		//6 to 8, average 7
		return 6+Random.chances(new float[]{1, 3, 1});
	}
	
	@Override
	protected int specialRooms(boolean forceMax) {
		if (forceMax) return 3;
		//2 to 3, average 2.33
		return 2 + Random.chances(new float[]{2, 1});
	}
	
	@Override
	public String tilesTex() {
		return Assets.Environment.TILES_4;
	}
	
	@Override
	public String waterTex() {
		return Assets.Environment.WATER_4;
	}

	@Override
	protected Painter painter() {
		return new TouhouPainter()
				.setWater(feeling == Feeling.WATER ? 0.85f : 0.25f, 5)
				.setGrass(feeling == Feeling.GRASS ? 0.80f : 0.20f, 4)
				.setSunny(0.20f, 4)
				.setIron(0.20f, 4)
				.setTraps(nTraps(), trapClasses(), trapChances());
	}

	@Override
	public void create() {
		super.create();
	}

	@Override
	protected Class<?>[] trapClasses() {
		return new Class[]{
				EnchantEraseTrap.class, ChillingTrap.class, BurningTrap.class, TeleportationTrap.class, FlockTrap.class,
				SlowTrap.class, BalanceTrap.class, AntiSneakTrap.class, ToxicTrap.class, ConfusionTrap.class};
	}

	@Override
	protected float[] trapChances() {
		return new float[]{
				3, 3, 3, 3, 3,
				2, 2, 2, 2, 2};
	}
	
	@Override
	public Group addVisuals() {
		super.addVisuals();
		addCityVisuals( this, visuals );
		return visuals;
	}

	public static void addCityVisuals( Level level, Group group ) {
		for (int i=0; i < level.length(); i++) {
			if (level.map[i] == Terrain.WALL_DECO) {
				group.add( new Smoke( i ) );
			}
		}
	}
	
	public static class Smoke extends Emitter {
		
		private int pos;

		public static final Factory factory = new Factory() {
			
			@Override
			public void emit( Emitter emitter, int index, float x, float y ) {
				SmokeParticle p = (SmokeParticle)emitter.recycle( SmokeParticle.class );
				p.reset( x, y );
			}
		};
		
		public Smoke( int pos ) {
			super();
			
			this.pos = pos;
			
			PointF p = DungeonTilemap.tileCenterToWorld( pos );
			pos( p.x - 6, p.y - 4, 12, 12 );
			
			pour( factory, 0.2f );
		}
		
		@Override
		public void update() {
			if (visible = (pos < Dungeon.level.heroFOV.length && Dungeon.level.heroFOV[pos])) {
				super.update();
			}
		}
	}
	
	public static final class SmokeParticle extends PixelParticle {
		
		public SmokeParticle() {
			super();
			
			color( 0x000000 );
			speed.set( Random.Float( -2, 4 ), -Random.Float( 3, 6 ) );
		}
		
		public void reset( float x, float y ) {
			revive();
			
			this.x = x;
			this.y = y;
			
			left = lifespan = 2f;
		}
		
		@Override
		public void update() {
			super.update();
			float p = left / lifespan;
			am = p > 0.8f ? 1 - p : p * 0.25f;
			size( 6 - p * 3 );
		}
	}
}