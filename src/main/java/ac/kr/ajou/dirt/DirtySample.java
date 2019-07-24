package ac.kr.ajou.dirt;

public class DirtySample {
    public Item[] items;

    public DirtySample(Item[] items) {
        this.items = items;
    }

    public void updateQuality()
    {
        for (int i = 0; i < items.length; i++)
        {
            if(isSulfuras(items[i])) continue;
            else if(isAged_brie(items[i])) updateBrie(items[i]);
            else if(isBackStage(items[i])) updatePasses(items[i]);
            else updateRemain(items[i]);
        }
    }

    private void updateRemain(Item item)
    {
        if(isZeroQuality(item)) item.lowerQuality();
        item.lowerSellIn();
        if(item.sellIn < 0)
        {
            if(isZeroQuality(item)) item.lowerQuality();
        }
    }

    private void updatePasses(Item item)
    {

        if(isNotMaxQuality(item))
        {
            item.higherQuality();

            if (item.sellIn < 11) {
                if (isNotMaxQuality(item)) {
                    item.quality = item.quality + 1;
                }
            }

            if (item.sellIn < 6) {
                if (isNotMaxQuality(item)) {
                    item.quality = item.quality + 1;
                }
            }
        }
        item.lowerSellIn();

        if(item.sellIn < 0) item.zeroQuality();
    }

    private void updateBrie(Item item)
    {
        if(isNotMaxQuality(item)) {
            item.higherQuality();
        }
        item.lowerSellIn();

        if(item.sellIn < 0)
        {
            if(isNotMaxQuality(item)) item.higherQuality();
        }

    }

    private boolean isSulfuras(Item item) {
        return item.name.equals("Sulfuras, Hand of Ragnaros");
    }

    private boolean isAged_brie(Item item) {
        return item.name.equals("Aged Brie");
    }

    private boolean isBackStage(Item item)
    {
        return item.name.equals("Backstage passes to a TAFKAL80ETC concert");
    }

    private boolean isNotMaxQuality(Item item) {
        return item.quality < 50;
    }

    private boolean isZeroQuality(Item item) {
        return item.quality > 0;
    }


}