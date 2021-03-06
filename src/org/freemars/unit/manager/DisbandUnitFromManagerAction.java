package org.freemars.unit.manager;

import org.freemars.controller.FreeMarsController;
import java.awt.event.ActionEvent;
import org.freemars.controller.action.DisbandUnitAction;
import org.freemars.unit.UnitsTableHelper;
import org.freerealm.unit.Unit;

/**
 *
 * @author Deniz ARIKAN
 */
public class DisbandUnitFromManagerAction extends DisbandUnitAction {

    private FreeMarsController freeMarsController;
    private UnitManagerDialog unitManagerDialog;

    public DisbandUnitFromManagerAction(FreeMarsController freeMarsController, UnitManagerDialog unitManagerDialog, Unit unit) {
        super(freeMarsController, unit);
        this.freeMarsController = freeMarsController;
        this.unitManagerDialog = unitManagerDialog;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        super.actionPerformed(e);
        new UnitsTableHelper(freeMarsController, unitManagerDialog).updateUnitsTable();
        new UnitsTableHelper(freeMarsController, unitManagerDialog).updateUnitTypeCounts();
    }
}
