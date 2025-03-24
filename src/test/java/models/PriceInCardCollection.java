package models;

import lombok.Data;

@Data
public class PriceInCardCollection {
    private int priceValue, oldPriceValue, discountPercentValue;
    private String currency;
}
