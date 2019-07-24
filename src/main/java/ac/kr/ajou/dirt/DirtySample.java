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
            if (!items[i].name.equals("Aged Brie") && !items[i].name.equals("Backstage passes to a TAFKAL80ETC concert"))
            {
                if (items[i].quality > 0)
                {
                    if (!items[i].name.equals("Sulfuras, Hand of Ragnaros"))
                    {
                        lowerquality(items[i]);
                    }
                }
            }

            else
                {
                    if (items[i].quality < 50)
                    {
                        items[i].quality = items[i].quality + 1;

                        if (items[i].name.equals("Backstage passes to a TAFKAL80ETC concert"))
                        {
                            if (items[i].sellIn < 11)
                            {
                                if (items[i].quality < 50)
                                {
                                    higherquality(items[i]);
                                }
                            }

                             if (items[i].sellIn < 6)
                            {
                                if (items[i].quality < 50)
                                {
                                    higherquality(items[i]);
                                }
                            }
                        }
                    }
                }

            if (!items[i].name.equals("Sulfuras, Hand of Ragnaros"))
            {
                lowersellln(items[i]);
            }

            if (items[i].sellIn < 0)
            {
                if (!items[i].name.equals("Aged Brie"))
                {
                    if (!items[i].name.equals("Backstage passes to a TAFKAL80ETC concert"))
                    {
                        if (items[i].quality > 0) {
                            if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
                                lowerquality(items[i]);
                            }
                        }
                    }
                    else
                    {
                        zeroqulity(items[i]);
                    }
                }
                else
                {
                    if (items[i].quality < 50)
                    {
                        higherquality(items[i]);
                    }
                }
            }
        }
    }

    private void zeroqulity(Item item)
    {
        item.quality = item.quality - item.quality;
    }


    public void lowerquality(Item item)
    {
        item.quality = item.quality - 1;
    }

    public void higherquality(Item item)
    {
        item.quality = item.quality + 1;
    }

    public void lowersellln(Item item)
    {
        item.sellIn = item.sellIn - 1;
    }

    public void highersellln(Item item)
    {
        item.sellIn = item.sellIn - 1;
    }
}