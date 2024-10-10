package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GlidedRoseTest {

    @Test
    void testRegularItemBeforeSellDate() {
        Item[] items = new Item[]{new Item("Regular Item", 10, 20)};
        GlidedRose app = new GlidedRose(items);

        app.updateQuality();

        assertEquals(19, items[0].quality);
        assertEquals(9, items[0].sellIn);
    }

    @Test
    void testRegularItemOnSellDate() {
        Item[] items = new Item[]{new Item("Regular Item", 0, 20)};
        GlidedRose app = new GlidedRose(items);

        app.updateQuality();

        assertEquals(18, items[0].quality);
        assertEquals(-1, items[0].sellIn);
    }

    @Test
    void testRegularItemAfterSellDate() {
        Item[] items = new Item[]{new Item("Regular Item", -1, 20)};
        GlidedRose app = new GlidedRose(items);

        app.updateQuality();

        assertEquals(18, items[0].quality);
        assertEquals(-2, items[0].sellIn);
    }

    @Test
    void testRegularItemWithZeroQuality() {
        Item[] items = new Item[]{new Item("Regular Item", 10, 0)};
        GlidedRose app = new GlidedRose(items);

        app.updateQuality();

        assertEquals(0, items[0].quality);
        assertEquals(9, items[0].sellIn);
    }

    @Test
    void testAgedBrieBeforeSellDate() {
        Item[] items = new Item[]{new Item("Aged Brie", 10, 20)};
        GlidedRose app = new GlidedRose(items);

        app.updateQuality();

        assertEquals(21, items[0].quality);
        assertEquals(9, items[0].sellIn);
    }

    @Test
    void testAgedBrieOnSellDate() {
        Item[] items = new Item[]{new Item("Aged Brie", 0, 20)};
        GlidedRose app = new GlidedRose(items);

        app.updateQuality();

        assertEquals(22, items[0].quality);
        assertEquals(-1, items[0].sellIn);
    }

    @Test
    void testAgedBrieAfterSellDate() {
        Item[] items = new Item[]{new Item("Aged Brie", -1, 20)};
        GlidedRose app = new GlidedRose(items);

        app.updateQuality();

        assertEquals(22, items[0].quality);
        assertEquals(-2, items[0].sellIn);
    }

    @Test
    void testAgedBrieWithMaxQuality() {
        Item[] items = new Item[]{new Item("Aged Brie", 10, 50)};
        GlidedRose app = new GlidedRose(items);

        app.updateQuality();

        assertEquals(50, items[0].quality);
        assertEquals(9, items[0].sellIn);
    }

    @Test
    void testSulfuras() {
        Item[] items = new Item[]{new Item("Sulfuras, Hand of Ragnaros", 10, 80)};
        GlidedRose app = new GlidedRose(items);

        app.updateQuality();

        assertEquals(80, items[0].quality);
        assertEquals(10, items[0].sellIn);
    }

    @Test
    void testBackstagePassesLongBeforeSellDate() {
        Item[] items = new Item[]{new Item("Backstage passes to a TAFKAL80ETC concert", 11, 20)};
        GlidedRose app = new GlidedRose(items);

        app.updateQuality();

        assertEquals(21, items[0].quality);
        assertEquals(10, items[0].sellIn);
    }

    @Test
    void testBackstagePassesMediumCloseToSellDate() {
        Item[] items = new Item[]{new Item("Backstage passes to a TAFKAL80ETC concert", 10, 20)};
        GlidedRose app = new GlidedRose(items);

        app.updateQuality();

        assertEquals(22, items[0].quality);
        assertEquals(9, items[0].sellIn);
    }

    @Test
    void testBackstagePassesVeryCloseToSellDate() {
        Item[] items = new Item[]{new Item("Backstage passes to a TAFKAL80ETC concert", 5, 20)};
        GlidedRose app = new GlidedRose(items);

        app.updateQuality();

        assertEquals(23, items[0].quality);
        assertEquals(4, items[0].sellIn);
    }

    @Test
    void testBackstagePassesOnSellDate() {
        Item[] items = new Item[]{new Item("Backstage passes to a TAFKAL80ETC concert", 0, 20)};
        GlidedRose app = new GlidedRose(items);

        app.updateQuality();

        assertEquals(0, items[0].quality);
        assertEquals(-1, items[0].sellIn);
    }

    @Test
    void testBackstagePassesAfterSellDate() {
        Item[] items = new Item[]{new Item("Backstage passes to a TAFKAL80ETC concert", -1, 20)};
        GlidedRose app = new GlidedRose(items);

        app.updateQuality();

        assertEquals(0, items[0].quality);
        assertEquals(-2, items[0].sellIn);
    }
}