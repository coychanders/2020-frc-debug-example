package org.team1619.behavior;

import org.uacr.models.behavior.Behavior;
import org.uacr.shared.abstractions.InputValues;
import org.uacr.shared.abstractions.OutputValues;
import org.uacr.shared.abstractions.RobotConfiguration;
import org.uacr.utilities.Config;
import org.uacr.utilities.Timer;
import org.uacr.utilities.logging.LogManager;
import org.uacr.utilities.logging.Logger;

import java.util.Set;

/**
 * Example behavior to copy for other behaviors
 */

public class Arm_States implements Behavior {

	private static final Logger sLogger = LogManager.getLogger(Arm_States.class);
	private static final Set<String> sSubsystems = Set.of("ss_arm");

	private final InputValues fSharedInputValues;
	private final OutputValues fSharedOutputValues;
	private Timer mTimer;
	private int mTimeDelay;

	public Arm_States(InputValues inputValues, OutputValues outputValues, Config config, RobotConfiguration robotConfiguration) {
		fSharedInputValues = inputValues;
		fSharedOutputValues = outputValues;

		mTimeDelay = 0;
		mTimer = new Timer();
	}

	@Override
	public void initialize(String stateName, Config config) {
		sLogger.debug("Entering state {}", stateName);

		mTimeDelay = config.getInt("time_delay", 0);
		mTimer.start(mTimeDelay);
	}

	@Override
	public void update() {
	}

	@Override
	public void dispose() {

	}

	@Override
	public boolean isDone() {
		return mTimer.isDone();
	}

	@Override
	public Set<String> getSubsystems() {
		return sSubsystems;
	}
}