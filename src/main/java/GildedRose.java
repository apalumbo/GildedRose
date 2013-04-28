import base.Item;
import update.StrategyDispatcher;
import update.strategy.*;

import java.util.ArrayList;
import java.util.List;


public class GildedRose {
    public static StrategyDispatcher strategyDispatcher = new StrategyDispatcher();
    protected static List<Item> items = null;

    /**
     * @param args
     */
    public static void main(String[] args) {

        System.out.println("OMGHAI!");

        items = new ArrayList<Item>();
        items.add(new Item(DexterityUpdateStrategy.DEXTERITY_VEST_NAME, 10, 20));
        items.add(new Item(AgedBrieUpdateStrategy.AGED_BRIE_NAME, 2, 0));
        items.add(new Item(ElixirOfTheMongooseUpdateStrategy.ELIXIR_OF_THE_MONGOOSE_NAME, 5, 7));
        items.add(new Item(SulfurasUpdateStrategy.SULFURAS_NAME, 0, 80));
        items.add(new Item(BackstagePassesUpdateStrategy.BACKSTAGE_PASSES_NAME, 15, 20));
        items.add(new Item(CojuredUpdateStrategy.CONJURED_MANA_CAKE, 3, 6));

        updateQuality();
    }

    public static void updateQuality() {
        for (int i = 0; i < items.size(); i++) {
            Item currentItem = items.get(i);
            updateCurrentItem(currentItem);
        }
    }

    protected static void updateCurrentItem(Item currentItem) {
        strategyDispatcher.dispatch(currentItem);
    }

}