package ru.fadedfog.acrosstars.models.enemies;

import ru.fadedfog.acrosstars.config.GameConfig;
import ru.fadedfog.acrosstars.models.enemies.attack_behavior.AttackAimAndShoot;
import ru.fadedfog.acrosstars.models.enemies.attack_behavior.AttackBehavior;
import ru.fadedfog.acrosstars.models.enemies.attack_behavior.AttackUnidirectional;
import ru.fadedfog.acrosstars.models.enemies.attack_behavior.WithoutAttack;
import ru.fadedfog.acrosstars.models.enemies.move_behavior.MoveBehavior;
import ru.fadedfog.acrosstars.models.enemies.move_behavior.MoveChaotic;
import ru.fadedfog.acrosstars.models.enemies.move_behavior.MoveDown;
import ru.fadedfog.acrosstars.models.enemies.move_behavior.MoveKamikaze;

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

		@Override
		public MoveBehavior getMoveBehaviorEShip() {
			return new MoveDown();
		}

		@Override
		public float getHpEnemyShip() {
			return config.getHpShipEPawn();
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
			return new WithoutAttack();
		}

		@Override
		public MoveBehavior getMoveBehaviorEShip() {
			return new MoveKamikaze();
		}

		@Override
		public float getHpEnemyShip() {
			return config.getHpShipEKamikaze();
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

		@Override
		public MoveBehavior getMoveBehaviorEShip() {
			return new MoveChaotic();
		}

		@Override
		public float getHpEnemyShip() {
			return config.getHpShipEBastion();
		}
		
		
	};
	
	protected GameConfig config = GameConfig.getInstance();
	
	public abstract AttackBehavior getAttackBehaviorEShip();
	public abstract MoveBehavior getMoveBehaviorEShip();
	public abstract float[] getAreaEShip();
	public abstract float getHpEnemyShip();
}
