package models;

import lombok.Data;

import java.util.List;

@Data
public class GetFavouriteResponse {
    private List<ItemsCollection> items;
    private MetaCollection meta;
}
