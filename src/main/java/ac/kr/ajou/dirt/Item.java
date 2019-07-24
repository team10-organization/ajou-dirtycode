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


    public void lowerquality()
    {
        this.quality = this.quality -1;
    }

    public void higherquality()
    {
        this.quality = this.quality + 1;
    }

    public void lowersellln()
    {
        this.sellIn = this.sellIn - 1;
    }

    public void highersellln()
    {
        this.sellIn = this.sellIn - 1;
    }

    public void zeroquality()
    {
        this.quality = this.quality - this.quality;
    }
}