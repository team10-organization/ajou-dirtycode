package ac.kr.ajou;

import ac.kr.ajou.dirt.DirtySample;
import ac.kr.ajou.dirt.Item;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class ItemTest
{
    @Test
    public void 업데이트퀄리티_아이템이름이test일때_셀린이정상적으로1감소하는지테스트()
    {
        Item[] items = {new Item("test", 50, 50)};
        DirtySample dirtySample = new DirtySample(items);
        dirtySample.updateQuality();
        assertThat(dirtySample.items[0].getSellIn(), is(49));
    }

    @Test
    public void 업데이트퀄리티_아이템이름이test일때_퀄리티가감소하는지테스트()
    {
        Item[] items = {new Item("test", 50, 50)};
        DirtySample dirtySample = new DirtySample(items);
        dirtySample.updateQuality();
        assertThat(dirtySample.items[0].getQuality(), is(49));
    }

    @Test
    public void 업데이트퀄리티_아이템이름이test이고_셀린값이음수일때퀄리티가감소하는지테스트()
    {
        Item[] items = {new Item("test", 50, 50)};
        DirtySample dirtySample = new DirtySample(items);
        dirtySample.updateQuality();
        assertThat(dirtySample.items[0].getQuality(), is(49));
    }

    @Test
    public void 업데이트퀄리티_아이템이름이설퍼라스이고_셀린이마이너스값이고퀄리티가50일때_퀄리티가그대로인지테스트()
    {
        Item[] items = {new Item("Sulfuras, Hand of Ragnaros", -3, 50)};
        DirtySample dirtySample = new DirtySample(items);
        dirtySample.updateQuality();
        assertThat(dirtySample.items[0].getQuality(), is(50));
    }





}
