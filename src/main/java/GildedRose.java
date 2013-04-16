import java.util.ArrayList;
import java.util.List;


public class GildedRose {

    protected static List<Item> items = null;

    public static final String AGED_BRIE_NAME = "Aged Brie";
    public static final String DEXTERITY_VEST_NAME = "+5 Dexterity Vest";
    public static final String ELIXIR_OF_THE_MONGOOSE_NAME = "Elixir of the Mongoose";
    public static final String SULFURAS_NAME = "Sulfuras, Hand of Ragnaros";
    public static final String BACKSTAGE_PASSES_NAME = "Backstage passes to a TAFKAL80ETC concert";
    public static final String CONJURED_MANA_CAKE = "Conjured Mana Cake";

    /**
     * @param args
     */
    public static void main(String[] args) {



        System.out.println("OMGHAI!");

        items = new ArrayList<Item>();
        items.add(new Item(DEXTERITY_VEST_NAME, 10, 20));
        items.add(new Item(AGED_BRIE_NAME, 2, 0));
        items.add(new Item(ELIXIR_OF_THE_MONGOOSE_NAME, 5, 7));
        items.add(new Item(SULFURAS_NAME, 0, 80));
        items.add(new Item(BACKSTAGE_PASSES_NAME, 15, 20));
        items.add(new Item(CONJURED_MANA_CAKE, 3, 6));

        updateQuality();
    }

    public static void updateQuality() {
        for (int i = 0; i < items.size(); i++) {
            Item currentItem = items.get(i);
            updateCurrentItem(currentItem);
        }
    }

    protected static void updateCurrentItem(Item currentItem) {

        if(GildedRose.CONJURED_MANA_CAKE.equals(currentItem.getName())) {
            if(currentItem.getSellIn() <= 0) {
                currentItem.setQuality(currentItem.getQuality() - 4);
            } else {
                if(currentItem.getQuality() > 2) {
                    currentItem.setQuality(currentItem.getQuality() - 2);
                } else {
                    currentItem.setQuality(0);
                }
            }

            currentItem.setSellIn(currentItem.getSellIn() - 1);
            return;

        } else if ((!"Aged Brie".equals(currentItem.getName())) && !"Backstage passes to a TAFKAL80ETC concert".equals(currentItem.getName())) {
            if (currentItem.getQuality() > 0) {
                if (!"Sulfuras, Hand of Ragnaros".equals(currentItem.getName())) {
                    currentItem.setQuality(currentItem.getQuality() - 1);
                }
            }
        } else {

            if (currentItem.getQuality() < 50) {
                currentItem.setQuality(currentItem.getQuality() + 1);

                if ("Backstage passes to a TAFKAL80ETC concert".equals(currentItem.getName())) {
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
            }
        }

        if (!"Sulfuras, Hand of Ragnaros".equals(currentItem.getName())) {
            currentItem.setSellIn(currentItem.getSellIn() - 1);
        }

        if (currentItem.getSellIn() < 0) {
            if (!"Aged Brie".equals(currentItem.getName())) {
                if (!"Backstage passes to a TAFKAL80ETC concert".equals(currentItem.getName())) {
                    if (currentItem.getQuality() > 0) {
                        if (!"Sulfuras, Hand of Ragnaros".equals(currentItem.getName())) {
                            currentItem.setQuality(currentItem.getQuality() - 1);
                        }
                    }
                } else {
                    currentItem.setQuality(currentItem.getQuality() - currentItem.getQuality());
                }
            } else {
                if (currentItem.getQuality() < 50) {
                    currentItem.setQuality(currentItem.getQuality() + 1);
                }
            }
        }
    }

}