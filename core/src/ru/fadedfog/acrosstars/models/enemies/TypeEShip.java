package ru.fadedfog.acrosstars.models.enemies;

import ru.fadedfog.acrosstars.config.GameConfig;
import ru.fadedfog.acrosstars.models.enemies.attack_behavior.AttackAimAndShoot;
import ru.fadedfog.acrosstars.models.enemies.attack_behavior.AttackBehavior;
import ru.fadedfog.acrosstars.models.enemies.attack_behavior.AttackKamikaze;
import ru.fadedfog.acrosstars.models.enemies.attack_behavior.AttackUnidirectional;

public enum TypeEShip {
	PAWN {
		@Override
		public float[] getAreaEShip() {
			return new float[] {config.getWidthEPawn(),
								config.getHeightEPawn()};
		}

		@Override
		public AttackBehavior getAttackBehaviorEShip() {
			return new AttackUnidirectional();
		}
	},
	KAMIKAZA {
		@Override
		public float[] getAreaEShip() {
			return new float[] {config.getWidthEKamikaza(),
								config.getHeightEKamikaza()};
		}

		@Override
		public AttackBehavior getAttackBehaviorEShip() {
			return new AttackKamikaze();
		}
	},
	BASTION {
		@Override
		public float[] getAreaEShip() {
			return new float[] {config.getWidthEBastion(),
								config.getHeightEBastion()};
		}

		@Override
		public AttackBehavior getAttackBehaviorEShip() {
			return new AttackAimAndShoot();
		}
	};
	
	protected GameConfig config = GameConfig.getInstance();
	
	public abstract AttackBehavior getAttackBehaviorEShip();
	public abstract float[] getAreaEShip();
}
