package models;

import lombok.Data;

@Data
public class TotalCardCollection {
    private PriceInCardCollection price;
    private int quantity;
}
