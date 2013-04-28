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
public class ElixirOfTheMongooseUpdateStrategy implements UpdateStrategy {
    public static final String ELIXIR_OF_THE_MONGOOSE_NAME = "Elixir of the Mongoose";

    @Override
    public void update(Item currentItem) {
        if (currentItem.getQuality() > 0) {
            currentItem.setQuality(currentItem.getQuality() - 1);
        }

        currentItem.setSellIn(currentItem.getSellIn() - 1);

        if (currentItem.getSellIn() < 0) {
            if (currentItem.getQuality() > 0) {
                currentItem.setQuality(currentItem.getQuality() - 1);
            }
        }
    }

    @Override
    public String getObjectName() {
        return ELIXIR_OF_THE_MONGOOSE_NAME;
    }
}
