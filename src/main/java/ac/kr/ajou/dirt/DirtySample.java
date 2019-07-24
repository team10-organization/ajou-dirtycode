package ac.kr.ajou.dirt;

class DirtySample {
    public Item[] items;

    public DirtySample(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {
            switch (items[i].name) {
                case "Sulfuras, Hand of Ragnaros":
                    continue;
                case "Aged Brie":
                    updateBrie(items[i]);
                    break;
                case "Backstage passes to a TAFKAL80ETC concert":
                    updatePasses(items[i]);
                    break;
                default:
                    updateRemain(items[i]);
            }
        }
    }

    private void updateRemain(Item item) {
        if (isZeroQuality(item)) item.lowerQuality();
        item.lowerSellIn();
        if (item.sellIn < 0) {
            if (isZeroQuality(item)) item.lowerQuality();
        }
    }

    private void updatePasses(Item item) {
        if (isNotMaxQuality(item)) {
            item.higherQuality();
            isLeft10Days(item);
            isLeft5Days(item);
        }
        item.lowerSellIn();

        if (isConcertEnd(item)) item.zeroQuality();
    }


    private void updateBrie(Item item) {
        if (isNotMaxQuality(item)) {
            item.higherQuality();
        }
        item.lowerSellIn();

        if (item.sellIn < 0) {
            if (isNotMaxQuality(item)) item.higherQuality();
        }

    }

    private boolean isConcertEnd(Item item) {
        return item.sellIn < 0;
    }

    private void isLeft5Days(Item item) {
        if (item.sellIn < 6) {
            if (isNotMaxQuality(item)) {
                item.quality = item.quality + 1;
            }
        }
    }

    private void isLeft10Days(Item item) {
        if (item.sellIn < 11) {
            if (isNotMaxQuality(item)) {
                item.quality = item.quality + 1;
            }
        }
    }

    private boolean isNotMaxQuality(Item item) {
        return item.quality < 50;
    }

    private boolean isZeroQuality(Item item) {
        return item.quality > 0;
    }
}