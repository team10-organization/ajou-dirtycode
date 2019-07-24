package ac.kr.ajou;

import ac.kr.ajou.dirt.DirtySample;
import ac.kr.ajou.dirt.Item;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class ItemTest
{
    @Test
    public void 이름이_Aged_Brie이_아니고_Backstage_passes_to_a_TAFKAL80ETC_concert가_아니고_Sulfuras_Hand_of_Ragnaros가_아니고_sellin이_1보다_작고_quality가_1보다_크면_quality_2만큼_감소() {
        Item[] items = {new Item("Brown", 0, 10), new Item("Charlie", -3, 56),
                new Item("Allie", -5, 4)};
        DirtySample dirtySample = new DirtySample(items);
        dirtySample.updateQuality();
        assertTrue(items[0].quality == 8);
        assertTrue(items[1].quality == 54);
        assertTrue(items[2].quality == 2);
    }

    @Test
    public void 이름이_Aged_Brie이_아니고_Backstage_passes_to_a_TAFKAL80ETC_concert가_아니고_Sulfuras_Hand_of_Ragnaros가_아니고_quality가_1이면_quality_1만큼_감소() {
        Item[] items = {new Item("Brown", 0, 1), new Item("Charlie", -3, 1)};
        DirtySample dirtySample = new DirtySample(items);
        dirtySample.updateQuality();
        assertTrue(items[0].quality == 0);
        assertTrue(items[1].quality == 0);
    }

    @Test
    public void 이름이_Aged_Brie이_아니고_Backstage_passes_to_a_TAFKAL80ETC_concert가_아니고_Sulfuras_Hand_of_Ragnaros가_아니고__quality가_1보다_크지만_sellin이_1이상이면_quality_1만큼_감소() {
        Item[] items = {new Item("Brown", 1, 10), new Item("Charlie", 15, 56)};
        DirtySample dirtySample = new DirtySample(items);
        dirtySample.updateQuality();
        assertTrue(items[0].quality == 9);
        assertTrue(items[1].quality == 55);
    }

    @Test
    public void 이름이_Aged_Brie이고_quality가_49보다_작고_sellin이_1보다_작으면_quality_2만큼_증가() {
        Item[] items = {new Item("Aged Brie", 0, 43), new Item("Aged Brie", -3, -4)};
        DirtySample dirtySample = new DirtySample(items);
        dirtySample.updateQuality();
        assertTrue(items[0].quality == 45);
        assertTrue(items[1].quality == -2);
    }

    @Test
    public void 이름이_Aged_Brie이고_quality가_50보다_작고_sellin이_1이상이면_quality_1만큼_증가() {
        Item[] items = {new Item("Aged Brie", 1, 43), new Item("Aged Brie", 15, -4)};
        DirtySample dirtySample = new DirtySample(items);
        dirtySample.updateQuality();
        assertTrue(items[0].quality == 44);
        assertTrue(items[1].quality == -3);
    }

    @Test
    public void 이름이_Aged_Brie이고_quality가_49이면_quality_1만큼_증가() {
        Item[] items = {new Item("Aged Brie", 7, 49), new Item("Aged Brie", -4, 49)};
        DirtySample dirtySample = new DirtySample(items);
        dirtySample.updateQuality();
        assertTrue(items[0].quality == 50);
        assertTrue(items[1].quality == 50);
    }

    @Test
    public void 이름이_Backstage_passes_to_a_TAFKAL80ETC_concert이고_sellin이_1보다_작으면_quality_0됨() {
        Item[] items = {new Item("Backstage passes to a TAFKAL80ETC concert", 0, 43),
                new Item("Backstage passes to a TAFKAL80ETC concert", -3, -4)};
        DirtySample dirtySample = new DirtySample(items);
        dirtySample.updateQuality();
        assertTrue(items[0].quality == 0);
        assertTrue(items[1].quality == 0);
    }

    @Test
    public void 이름이_Backstage_passes_to_a_TAFKAL80ETC_concert이고_quality가_50보다_작고_sellin이_11이상이면_quality_1만큼_증가() {
        Item[] items = {new Item("Backstage passes to a TAFKAL80ETC concert", 11, 43),
                new Item("Backstage passes to a TAFKAL80ETC concert", 106, -4)};
        DirtySample dirtySample = new DirtySample(items);
        dirtySample.updateQuality();
        assertTrue(items[0].quality == 44);
        assertTrue(items[1].quality == -3);
    }

    @Test
    public void 이름이_Backstage_passes_to_a_TAFKAL80ETC_concert이고_quality가_47보다_작으면서_sellin이_1이상이고_6보다_작으면__quality_3만큼_증가() {
        Item[] items = {new Item("Backstage passes to a TAFKAL80ETC concert", 4, 43),
                new Item("Backstage passes to a TAFKAL80ETC concert", 3, -4)};
        DirtySample dirtySample = new DirtySample(items);
        dirtySample.updateQuality();
        assertTrue(items[0].quality == 46);
        assertTrue(items[1].quality == -1);
    }

    @Test
    public void 이름이_Backstage_passes_to_a_TAFKAL80ETC_concert이고_quality가_48이고_sellin이_1이상이고_11보다_작으면__quality_2만큼_증가() {
        Item[] items = {new Item("Backstage passes to a TAFKAL80ETC concert", 3, 48),
                new Item("Backstage passes to a TAFKAL80ETC concert", 10, 48)};
        DirtySample dirtySample = new DirtySample(items);
        dirtySample.updateQuality();
        assertTrue(items[0].quality == 50);
        assertTrue(items[1].quality == 50);
    }

    @Test
    public void 이름이_Backstage_passes_to_a_TAFKAL80ETC_concert이고_quality가_48이하이고_sellin이_6이상이고_11보다_작으면__quality_2만큼_증가() {
        Item[] items = {new Item("Backstage passes to a TAFKAL80ETC concert", 8, 15),
                new Item("Backstage passes to a TAFKAL80ETC concert", 10, 48)};
        DirtySample dirtySample = new DirtySample(items);
        dirtySample.updateQuality();
        assertTrue(items[0].quality == 17);
        assertTrue(items[1].quality == 50);
    }

    @Test
    public void 이름이_Backstage_passes_to_a_TAFKAL80ETC_concert이고_quality가_49이고_sellin이_1이상이면__quality_1만큼_증가() {
        Item[] items = {new Item("Backstage passes to a TAFKAL80ETC concert", 8, 49),
                new Item("Backstage passes to a TAFKAL80ETC concert", 10, 49)};
        DirtySample dirtySample = new DirtySample(items);
        dirtySample.updateQuality();
        assertTrue(items[0].quality == 50);
        assertTrue(items[1].quality == 50);
    }


}
