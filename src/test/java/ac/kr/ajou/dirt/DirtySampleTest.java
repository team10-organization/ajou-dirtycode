package ac.kr.ajou.dirt;

import org.junit.Assert;
import org.junit.Test;

import static junit.framework.TestCase.assertTrue;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class DirtySampleTest {
    private String brie = "Aged Brie";
    private String tafkal8oetc = "Backstage passes to a TAFKAL80ETC concert";
    private String sulfras = "Sulfuras, Hand of Ragnaros";
    @Test
    public void updateQuality_이름이_TAFKAL80ETC이고_quality가_47이하_sellIn은_6이상_11미만이면_quality_2증가_sellIn_1감소(){
        Item[] items = {new Item(tafkal8oetc , 6, 47)};
        DirtySample dirtySample = new DirtySample(items);
        dirtySample.updateQuality();
        assertThat(items[0].sellIn, is(5));
        assertThat(items[0].quality, is(49));
    }

    @Test
    public void updateQuality_이름이_TAFKAL80ETC이고_quality가_49이하_sellIn은_11이상이면_quality_1증가_sellIn_1감소(){
        Item[] items = {new Item(tafkal8oetc , 11, 49)};
        DirtySample dirtySample = new DirtySample(items);
        dirtySample.updateQuality();
        assertThat(items[0].sellIn, is(10));
        assertThat(items[0].quality, is(50));
    }


    @Test
    public void updateQuality_이름이_셋_다_아니고_quality가_1초과_sellIn은_1미만이면_quality_2감소_sellIn_1감소(){
        Item[] items = {new Item("a" , 0, 3)};
        DirtySample dirtySample = new DirtySample(items);
        dirtySample.updateQuality();
        assertThat(items[0].sellIn, is(-1));
        assertThat(items[0].quality, is(1));
    }

    @Test
    public void updateQuality_이름이_셋_다_아니고_quality가_1이고_sellIn은_1미만이면_quality_1감소_sellIn_1감소(){
        Item[] items = {new Item("a" , 0, 1)};
        DirtySample dirtySample = new DirtySample(items);
        dirtySample.updateQuality();
        assertThat(items[0].sellIn, is(-1));
        assertThat(items[0].quality, is(0));
    }

    @Test
    public void updateQuality_이름이_셋_다_아니고_quality가_0이하면_sellIn_1감소(){
        Item[] items = {new Item("a" , 0, 0)};
        DirtySample dirtySample = new DirtySample(items);
        dirtySample.updateQuality();
        assertThat(items[0].sellIn, is(-1));
        assertThat(items[0].quality, is(0));
    }

    @Test
    public void updateQuality_이름이_셋_다_아니고_quality가_1초과고_sellIn은_1이상이면_quality_1감소_sellIn_1감소(){
        Item[] items = {new Item("a" , 1, 2)};
        DirtySample dirtySample = new DirtySample(items);
        dirtySample.updateQuality();
        assertThat(items[0].sellIn, is(0));
        assertThat(items[0].quality, is(1));
    }

    @Test
    public void updateQuality_이름이_TAFKAL80ETC는_quality가_50이상이면_sellin만_1감소(){
        Item[] items = {new Item(tafkal8oetc, 23, 54)
                , new Item(tafkal8oetc, 64, 103)};
        DirtySample dirtySample = new DirtySample(items);
        dirtySample.updateQuality();
        Assert.assertTrue(items[0].quality == 54 && items[0].sellIn == 22);
        Assert.assertTrue(items[1].quality == 103 && items[1].sellIn == 63);
    }

    @Test
    public void updateQuality_이름이_TAFKAL80ETC는_quality가_49이면_quality_1증가_sellin_1감소(){
        Item[] items = {new Item(tafkal8oetc, 23, 49)
                , new Item(tafkal8oetc, 64, 49)};
        DirtySample dirtySample = new DirtySample(items);
        dirtySample.updateQuality();
        Assert.assertTrue(items[0].quality == 50 && items[0].sellIn == 22);
        Assert.assertTrue(items[1].quality == 50 && items[1].sellIn == 63);
    }

    @Test
    public void updateQuality_이름이_TAFKAL80ETC는_quality가_48이고_sellin이_1이상_11미만이면_quality_2증가_sellin_1감소(){
        Item[] items = {new Item(tafkal8oetc, 1, 48)
                , new Item(tafkal8oetc, 10, 48)};
        DirtySample dirtySample = new DirtySample(items);
        dirtySample.updateQuality();
        Assert.assertTrue(items[0].quality == 50 && items[0].sellIn == 0);
        Assert.assertTrue(items[1].quality == 50 && items[1].sellIn == 9);
    }

    @Test
    public void updateQuality_이름이_TAFKAL80ETC는_quality가_47이하_sellin이_1이상_6미만이면_quality_3증가_sellin_1감소(){
        Item[] items = {new Item(tafkal8oetc, 1, 47)
                , new Item(tafkal8oetc, 5, 12)};
        DirtySample dirtySample = new DirtySample(items);
        dirtySample.updateQuality();
        Assert.assertTrue(items[0].quality == 50 && items[0].sellIn == 0);
        Assert.assertTrue(items[1].quality == 15 && items[1].sellIn == 4);
    }

    @Test
    public void updateQuality_이름이_TAFKAL80ETC는_quality가_47이하_sellin이_6이상_11미만이면_quality_2증가_sellin_1감소(){
        Item[] items = {new Item(tafkal8oetc, 6, 47)
                , new Item(tafkal8oetc, 10, 12)};
        DirtySample dirtySample = new DirtySample(items);
        dirtySample.updateQuality();
        Assert.assertTrue(items[0].quality == 49 && items[0].sellIn == 5);
        Assert.assertTrue(items[1].quality == 14 && items[1].sellIn == 9);
    }
}
