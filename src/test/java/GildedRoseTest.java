import base.Item;
import org.junit.Before;
import org.junit.Test;
import update.strategy.*;

import static org.junit.Assert.assertEquals;


public class GildedRoseTest {

    @Before
    public void setUp() {
    }

    @Test
    public void testDexterity() {
        Item item = new Item(DexterityUpdateStrategy.DEXTERITY_VEST_NAME, 10, 20);
        GildedRose.updateCurrentItem(item);

        assertEquals(19, item.getQuality());
        assertEquals(9, item.getSellIn());
    }

    @Test
    public void testDexterityAfterExpired() {
        Item item = new Item(DexterityUpdateStrategy.DEXTERITY_VEST_NAME, 0, 20);
        GildedRose.updateCurrentItem(item);

        assertEquals(18, item.getQuality());
        assertEquals(-1, item.getSellIn());
    }


    @Test
    public void testAgedBrie() {
        Item item = new Item(AgedBrieUpdateStrategy.AGED_BRIE_NAME, 2, 0);
        GildedRose.updateCurrentItem(item);

        assertEquals(1, item.getQuality());
        assertEquals(1, item.getSellIn());
    }

    @Test
    public void testAgedBrieAfterExpired() {
        Item item = new Item(AgedBrieUpdateStrategy.AGED_BRIE_NAME, 0, 0);
        GildedRose.updateCurrentItem(item);

        assertEquals(2, item.getQuality());
        assertEquals(-1, item.getSellIn());
    }

    @Test
    public void testElixir() {
        Item item = new Item(ElixirOfTheMongooseUpdateStrategy.ELIXIR_OF_THE_MONGOOSE_NAME, 5, 7);
        GildedRose.updateCurrentItem(item);

        assertEquals(6, item.getQuality());
        assertEquals(4, item.getSellIn());
    }

    @Test
    public void testElixirAfterExpiration() {
        Item item = new Item(ElixirOfTheMongooseUpdateStrategy.ELIXIR_OF_THE_MONGOOSE_NAME, 0, 7);
        GildedRose.updateCurrentItem(item);

        assertEquals(5, item.getQuality());
        assertEquals(-1, item.getSellIn());
    }


    @Test
    public void testSulfuras() {
        Item item = new Item(SulfurasUpdateStrategy.SULFURAS_NAME, 0, 80);
        GildedRose.updateCurrentItem(item);
        assertEquals(80, item.getQuality());
        assertEquals(0, item.getSellIn());
    }

    @Test
    public void testSulfurasBeforeExpired() {
        Item item = new Item(SulfurasUpdateStrategy.SULFURAS_NAME, 1, 80);
        GildedRose.updateCurrentItem(item);
        assertEquals(80, item.getQuality());
        assertEquals(1, item.getSellIn());
    }

    @Test
    public void testSulfurasAfterExpired() {
        Item item = new Item(SulfurasUpdateStrategy.SULFURAS_NAME, 0, 80);
        GildedRose.updateCurrentItem(item);
        assertEquals(80, item.getQuality());
        assertEquals(0, item.getSellIn());
    }


    @Test
    public void testBackstageMoreThan10DaysBeforeConcert() {
        Item item = new Item(BackstagePassesUpdateStrategy.BACKSTAGE_PASSES_NAME, 15, 20);
        GildedRose.updateCurrentItem(item);
        assertEquals(21, item.getQuality());
        assertEquals(14, item.getSellIn());
    }

    @Test
    public void testBackstageAfterConcert() {
        Item item = new Item(BackstagePassesUpdateStrategy.BACKSTAGE_PASSES_NAME, 0, 20);
        GildedRose.updateCurrentItem(item);
        assertEquals(0, item.getQuality());
        assertEquals(-1, item.getSellIn());
    }

    @Test
    public void testBackstage5DaysBeforeConcert() {
        Item item = new Item(BackstagePassesUpdateStrategy.BACKSTAGE_PASSES_NAME, 8, 20);
        GildedRose.updateCurrentItem(item);
        assertEquals(22, item.getQuality());
        assertEquals(7, item.getSellIn());
    }

    @Test
    public void testBackstage3DaysBeforeConcert() {
        Item item = new Item(BackstagePassesUpdateStrategy.BACKSTAGE_PASSES_NAME, 3, 20);
        GildedRose.updateCurrentItem(item);
        assertEquals(23, item.getQuality());
        assertEquals(2, item.getSellIn());
    }

    @Test
    public void testCojured() {
        Item item = new Item(CojuredUpdateStrategy.CONJURED_MANA_CAKE, 3, 6);
        GildedRose.updateCurrentItem(item);
        assertEquals(4, item.getQuality());
        assertEquals(2, item.getSellIn());
    }

    @Test
    public void testCojuredAfterExpirationDay() {
        Item item = new Item(CojuredUpdateStrategy.CONJURED_MANA_CAKE, 0, 6);
        GildedRose.updateCurrentItem(item);
        assertEquals(2, item.getQuality());
        assertEquals(-1, item.getSellIn());
    }

    @Test
    public void testCojuredNoQualityNotExpired() {
        Item item = new Item(CojuredUpdateStrategy.CONJURED_MANA_CAKE, 1, 0);
        GildedRose.updateCurrentItem(item);
        assertEquals(0, item.getQuality());
        assertEquals(0, item.getSellIn());
    }
}
