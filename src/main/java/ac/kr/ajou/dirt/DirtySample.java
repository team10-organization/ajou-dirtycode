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
            updateQualitybyUniqueName(items[i]);
            lowerSelllnfornotSulfuras(items[i]);
            updateQualityForMinusSellln(items[i]);
        }
    }

    private void updateQualityForMinusSellln(Item item) {
        if (item.sellIn < 0)
        {
            if(isBackStage(item)) item.zeroQuality();

            if (!isAged_brie(item))
            {
                if (!isBackStage(item))
                {
                    lowerQualityifPositiveQualityandNotSulfuras(item);
                }
            }
            else
            {
                higherQualitybelow50(item);
            }
        }
    }

    private void higherQualitybelow50(Item item) {
        if (item.quality < 50) {
            item.higherQuality();
        }
    }

    private void updateQualitybyUniqueName(Item item) {
        if (!isBackStage(item) && !isAged_brie(item))
        {
            lowerQualityifPositiveQualityandNotSulfuras(item);
        }

        else
            {
                if (item.quality < 50)
                {
                    item.quality = item.quality + 1;

                    if (isBackStage(item))
                    {
                        higherQualitybySellln(item);
                    }
                }
            }
    }

    private void higherQualitybySellln(Item item) {
        if (item.sellIn < 11)
        {
            higherQualitybelow50(item);
        }

        if (item.sellIn < 6)
       {
           higherQualitybelow50(item);
       }
    }

    private void lowerQualityifPositiveQualityandNotSulfuras(Item item) {
        if (item.quality > 0) {
            if (!isSulfuras(item)) {
                item.lowerQuality();
            }
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

    private void lowerSelllnfornotSulfuras(Item item) {
        if (!isSulfuras(item))
        {
            item.lowerSellln();
        }
    }

    private boolean isNotUniqueName(Item item)
    {
        return !(isBackStage(item)&&isAged_brie(item)&&isSulfuras(item));
    }


}