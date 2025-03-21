package models;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class AddToFavouriteRequest {
    private String skuId;
}
