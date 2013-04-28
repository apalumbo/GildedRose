package update.strategy;

import base.Item;
import update.UpdateStrategy;

/**
 * Created with IntelliJ IDEA.
 * User: lfoppiano
 * Date: 28/04/13
 * Time: 13:38
 * To change this template use File | Settings | File Templates.
 */
public class CojuredUpdateStrategy implements UpdateStrategy {
    public static final String CONJURED_MANA_CAKE = "Conjured Mana Cake";

    @Override
    public void update(Item currentItem) {
        if (currentItem.getSellIn() <= 0) {
            currentItem.setQuality(currentItem.getQuality() - 4);
        } else {
            if (currentItem.getQuality() > 2) {
                currentItem.setQuality(currentItem.getQuality() - 2);
            } else {
                currentItem.setQuality(0);
            }
        }

        currentItem.setSellIn(currentItem.getSellIn() - 1);
    }

    @Override
    public String getObjectName() {
        return CONJURED_MANA_CAKE;
    }
}
