package models;

import lombok.Data;

import java.util.List;

@Data
public class AddToCardRequest {
    private List<CardItemsCollection> cartItems;
}
