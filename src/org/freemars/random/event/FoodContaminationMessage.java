package org.freemars.random.event;

import org.freerealm.player.SettlementRelatedMessage;
import java.text.DecimalFormat;

/**
 * @author Deniz ARIKAN
 */
public class FoodContaminationMessage extends SettlementRelatedMessage {

    private int amountLost;

    @Override
    public StringBuffer getText() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("A contamination causes the loss of ");
        stringBuffer.append(new DecimalFormat().format(getAmountLost()));
        stringBuffer.append(" food in ");
        stringBuffer.append(getSettlement().getName());
        return stringBuffer;
    }

    public int getAmountLost() {
        return amountLost;
    }

    public void setAmountLost(int amountLost) {
        this.amountLost = amountLost;
    }
}
