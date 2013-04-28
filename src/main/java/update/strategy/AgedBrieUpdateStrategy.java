package update.strategy;

import base.Item;
import update.Strategy;
import update.UpdateStrategy;

/**
 * Created with IntelliJ IDEA.
 * User: lfoppiano
 * Date: 28/04/13
 * Time: 13:06
 * To change this template use File | Settings | File Templates.
 */
@Strategy
public class AgedBrieUpdateStrategy implements UpdateStrategy {
    public static final String AGED_BRIE_NAME = "Aged Brie";

    public void update(Item currentItem) {
        if (currentItem.getQuality() < 50) {
            currentItem.setQuality(currentItem.getQuality() + 1);
        }

        currentItem.setSellIn(currentItem.getSellIn() - 1);

        if (currentItem.getSellIn() < 0) {
            if (currentItem.getQuality() < 50) {
                currentItem.setQuality(currentItem.getQuality() + 1);
            }
        }
    }

    @Override
    public String getObjectName() {
        return AgedBrieUpdateStrategy.AGED_BRIE_NAME;
    }

}
