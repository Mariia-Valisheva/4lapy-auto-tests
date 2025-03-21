package models;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class GetFavouriteResponse {
    private ItemsCollection[] items;
    //private ArrayList<ItemsCollection> items;
    private List<MetaCollection> meta;
}
