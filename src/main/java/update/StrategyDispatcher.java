package update;

import base.Item;
import update.strategy.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: lfoppiano
 * Date: 28/04/13
 * Time: 13:03
 * To change this template use File | Settings | File Templates.
 */
public class StrategyDispatcher {

    List<UpdateStrategy> strategyList;

    public StrategyDispatcher() {
        strategyList = new ArrayList<UpdateStrategy>();
        strategyList.add(new AgedBrieUpdateStrategy());
        strategyList.add(new CojuredUpdateStrategy());
        strategyList.add(new BackstagePassesUpdateStrategy());
        strategyList.add(new ElixirOfTheMongooseUpdateStrategy());
        strategyList.add(new SulfurasUpdateStrategy());
        strategyList.add(new DexterityUpdateStrategy());
    }

    public void dispatch(Item item) {

        for(UpdateStrategy strategy : strategyList) {
            if(item.getName().equals(strategy.getObjectName())) {
                strategy.update(item);
            }
        }
    }
}
