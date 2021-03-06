package org.freemars.earth.command;

import org.freemars.model.FreeMarsModel;
import org.freemars.player.FreeMarsPlayer;
import org.freerealm.executor.CommandResult;
import org.freerealm.executor.command.AbstractCommand;

/**
 *
 * @author Deniz ARIKAN
 */
public class SetEarthTaxRateCommand extends AbstractCommand {

    private FreeMarsPlayer freeMarsPlayer;
    private byte earthTaxRate;

    public SetEarthTaxRateCommand(FreeMarsPlayer freeMarsPlayer, byte earthTaxRate) {
        this.freeMarsPlayer = freeMarsPlayer;
        this.earthTaxRate = earthTaxRate;
    }

    public CommandResult execute() {
        byte previousTaxRate = freeMarsPlayer.getEarthTaxRate();
        freeMarsPlayer.setEarthTaxRate(earthTaxRate);
        CommandResult commandResult = new CommandResult(CommandResult.RESULT_OK, "", FreeMarsModel.EARTH_TAX_RATE_CHANGED_UPDATE);
        commandResult.putParameter("previousTaxRate", previousTaxRate);
        commandResult.putParameter("newTaxRate", earthTaxRate);
        return commandResult;
    }
}
