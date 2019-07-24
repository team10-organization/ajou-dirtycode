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
            else if(isAged_brie(items[i])) caseofbrie(items[i]);
            else if(isBackStage(items[i])) caseofticket(items[i]);
            else caseofremain(items[i]);
        }
    }

    private void caseofremain(Item item)
    {
        if(isZeroQuality(item)) item.lowerQuality();
        item.lowerSellIn();
        if(item.sellIn < 0)
        {
            if(isZeroQuality(item)) item.lowerQuality();
        }
    }

    private boolean isZeroQuality(Item item) {
        return item.quality > 0;
    }

    private void caseofticket(Item item)
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

    private boolean isNotMaxQuality(Item item) {
        return item.quality < 50;
    }

    private void caseofbrie(Item item)
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

//    private void updateQualitybyUniqueName(Item item) {
//        if (!isAged_brie(item) && !isBackStage(item))
//        {
//            lowerQualityifPositiveQualityandNotSulfuras(item);
//        }
//
//        else
//        {
//            if (item.quality < 50)
//            {
//                item.quality = item.quality + 1;
//
//                if (isBackStage(item))
//                {
//                    higherQualitybySellln(item);
//                }
//            }
//        }
//    }
//
//    private void lowerSelllnfornotSulfuras(Item item) {
//        if (!isSulfuras(item))
//        {
//            item.lowerSellIn();
//        }
//    }
//
//    private void updateQualityForMinusSellln(Item item) {
//        if (item.sellIn < 0)
//        {
//            if(isBackStage(item))
//            {
//                item.zeroQuality();
//                return ;
//            }
//            if(isAged_brie(item))
//            {
//                higherQualitybelow50(item);
//                return ;
//            }
//
//            lowerQualityifPositiveQualityandNotSulfuras(item);
//
//
//        }
//    }
//
//    private void higherQualitybelow50(Item item) {
//        if (item.quality < 50) {
//            item.higherQuality();
//        }
//    }
//
//
//
//    private void higherQualitybySellln(Item item) {
//        if (item.sellIn < 11)
//        {
//            higherQualitybelow50(item);
//        }
//
//        if (item.sellIn < 6)
//       {
//           higherQualitybelow50(item);
//       }
//    }
//
//    private void lowerQualityifPositiveQualityandNotSulfuras(Item item) {
//        if (item.quality > 0) {
//            if (!isSulfuras(item)) {
//                item.lowerQuality();
//            }
//        }
//    }
//
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



}