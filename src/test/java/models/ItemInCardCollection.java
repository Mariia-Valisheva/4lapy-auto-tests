package models;

import lombok.Data;

@Data
public class ItemInCardCollection {
    private int cartItemId, quantity, cutPriceGroupId;
    private String offerId;
}
