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
            checknameisnotBrieorBackstage(items[i]);
            lowerselllnfornotSulfuras(items[i]);
            isselllnminus(items[i]);
        }
    }

    private void isselllnminus(Item item) {
        if (item.sellIn < 0)
        {
            if (!isAged_brie(item))
            {
                if (!isBackStage(item))
                {
                    if (item.quality > 0) {
                        if (!isSulfuras(item)) {
                            item.lowerquality();
                        }
                    }
                }
                else
                {
                    item.zeroquality();
                }
            }
            else
            {
                if (item.quality < 50)
                {
                    item.higherquality();
                }
            }
        }
    }

    private void checknameisnotBrieorBackstage(Item item) {
        if (!isAged_brie(item) && !isBackStage(item))
        {
            if (item.quality > 0)
            {
                if (!isSulfuras(item))
                {
                    item.lowerquality();
                }
            }
        }

        else
            {
                if (item.quality < 50)
                {
                    item.quality = item.quality + 1;

                    if (isBackStage(item))
                    {
                        if (item.sellIn < 11)
                        {
                            if (item.quality < 50)
                            {
                                item.higherquality();
                            }
                        }

                         if (item.sellIn < 6)
                        {
                            if (item.quality < 50)
                            {
                                item.higherquality();
                            }
                        }
                    }
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

    private void lowerselllnfornotSulfuras(Item item) {
        if (!isSulfuras(item))
        {
            item.lowersellln();
        }
    }


}