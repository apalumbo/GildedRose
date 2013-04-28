package update.strategy;

import base.Item;
import update.UpdateStrategy;

/**
 * Created with IntelliJ IDEA.
 * User: lfoppiano
 * Date: 28/04/13
 * Time: 13:43
 * To change this template use File | Settings | File Templates.
 */
public class BackstagePassesUpdateStrategy implements UpdateStrategy {
    public static final String BACKSTAGE_PASSES_NAME = "Backstage passes to a TAFKAL80ETC concert";

    @Override
    public void update(Item currentItem) {

        if (currentItem.getQuality() < 50) {
            currentItem.setQuality(currentItem.getQuality() + 1);
            if (currentItem.getSellIn() < 11) {
                if (currentItem.getQuality() < 50) {
                    currentItem.setQuality(currentItem.getQuality() + 1);
                }
            }

            if (currentItem.getSellIn() < 6) {
                if (currentItem.getQuality() < 50) {
                    currentItem.setQuality(currentItem.getQuality() + 1);
                }
            }
        }

        currentItem.setSellIn(currentItem.getSellIn() - 1);

        if (currentItem.getSellIn() < 0) {
            currentItem.setQuality(currentItem.getQuality() - currentItem.getQuality());
        }
    }

    @Override
    public String getObjectName() {
        return BACKSTAGE_PASSES_NAME;
    }
}
