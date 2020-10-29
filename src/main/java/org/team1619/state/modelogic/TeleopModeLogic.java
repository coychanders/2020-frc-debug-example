package org.team1619.state.modelogic;

import org.uacr.models.state.State;
import org.uacr.robot.AbstractModeLogic;
import org.uacr.shared.abstractions.InputValues;
import org.uacr.shared.abstractions.RobotConfiguration;
import org.uacr.utilities.logging.LogManager;
import org.uacr.utilities.logging.Logger;

/**
 * Handles the isReady and isDone logic for teleop mode on competition bot
 */

public class TeleopModeLogic extends AbstractModeLogic {

    private static final Logger sLogger = LogManager.getLogger(TeleopModeLogic.class);

    public TeleopModeLogic(InputValues inputValues, RobotConfiguration robotConfiguration) {
        super(inputValues, robotConfiguration);
    }

    @Override
    public void initialize() {
        sLogger.info("***** TELEOP *****");
    }

    @Override
    public void update() {
        if (fSharedInputValues.getBooleanRisingEdge("ipb_operator_left_bumper")) {
            sLogger.debug("left_bumper");
        }
        if (fSharedInputValues.getBooleanRisingEdge("ipb_operator_left_trigger")) {
            sLogger.debug("left_trigger");
        }
        if (fSharedInputValues.getBooleanRisingEdge("ipb_operator_right_trigger")) {
            sLogger.debug("right_trigger");
        }
        if (fSharedInputValues.getBooleanRisingEdge("ipb_operator_right_bumper")) {
            sLogger.debug("right_bumper");
        }
        if (fSharedInputValues.getBooleanRisingEdge("ipb_operator_x")) {
            sLogger.debug("x");
        }
        if (fSharedInputValues.getBooleanRisingEdge("ipb_operator_b")) {
            sLogger.debug("b");
        }
        if (fSharedInputValues.getBooleanRisingEdge("ipb_operator_y")) {
            sLogger.debug("y");
        }
        if (fSharedInputValues.getBooleanRisingEdge("ipb_operator_a")) {
            sLogger.debug("a");
        }
        if (fSharedInputValues.getBooleanRisingEdge("ipb_operator_dpad_down")) {
            sLogger.debug("down");
        }
        if (fSharedInputValues.getBooleanRisingEdge("ipb_operator_dpad_right")) {
            sLogger.debug("right");
        }
        if (fSharedInputValues.getBooleanRisingEdge("ipb_operator_dpad_up")) {
            sLogger.debug("up");
        }

    }

    @Override
    public void dispose() {
    }

    @Override
    public boolean isReady(String name) {
        switch (name) {
            case "pl_protect":
                return fSharedInputValues.getBooleanRisingEdge("ipb_operator_left_bumper");

            case "pl_intake":
                return fSharedInputValues.getBooleanRisingEdge("ipb_operator_left_trigger");

            case "sq_eject_medium":
                return fSharedInputValues.getBooleanRisingEdge("ipb_operator_right_trigger");

            case "sq_eject_high":
                return fSharedInputValues.getBooleanRisingEdge("ipb_operator_right_bumper");

            case "st_arm_extend":
                return fSharedInputValues.getBooleanRisingEdge("ipb_operator_b");

            case "st_arm_retract":
                return fSharedInputValues.getBooleanRisingEdge("ipb_operator_x");

            case "st_collector_intake":
                return fSharedInputValues.getBooleanRisingEdge("ipb_operator_y");

            case "st_collector_eject":
                return fSharedInputValues.getBooleanRisingEdge("ipb_operator_a");

            case "st_elevator_low":
                return fSharedInputValues.getBooleanRisingEdge("ipb_operator_dpad_down");

            case "st_elevator_medium":
                return fSharedInputValues.getBooleanRisingEdge("ipb_operator_dpad_right");

            case "st_elevator_high":
                return fSharedInputValues.getBooleanRisingEdge("ipb_operator_dpad_up");

            default:
                return false;
        }
    }

    @Override
    public boolean isDone(String name, State state) {
        switch (name) {
            default:
                return state.isDone();
        }
    }
}
