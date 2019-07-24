package ac.kr.ajou.dirt;

import lombok.Data;

@Data
public class Item {

    public String name;

    public int sellIn;

    public int quality;

    public Item(String name, int sellIn, int quality) {
        this.name = name;
        this.sellIn = sellIn;
        this.quality = quality;
    }

    @Override
    public String toString() {
        return this.name + ", " + this.sellIn + ", " + this.quality;
    }


    public void lowerQuality()
    {
        this.quality = this.quality -1;
    }

    public void higherQuality()
    {
        this.quality = this.quality + 1;
    }

    public void lowerSellIn()
    {
        this.sellIn = this.sellIn - 1;
    }

    public void higherSellIn()
    {
        this.sellIn = this.sellIn - 1;
    }

    public void zeroQuality()
    {
        this.quality = this.quality - this.quality;
    }
}