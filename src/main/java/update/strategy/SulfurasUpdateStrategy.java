package update.strategy;

import base.Item;
import update.UpdateStrategy;

/**
 * Created with IntelliJ IDEA.
 * User: lfoppiano
 * Date: 28/04/13
 * Time: 13:44
 * To change this template use File | Settings | File Templates.
 */
public class SulfurasUpdateStrategy implements UpdateStrategy {
    public static final String SULFURAS_NAME = "Sulfuras, Hand of Ragnaros";

    @Override
    public void update(Item currentItem) {
        //nothing
    }

    @Override
    public String getObjectName() {
        return SULFURAS_NAME;
    }
}
