package models;

import lombok.Data;

import java.util.List;

@Data
public class GetCustomerCardResponse {
    private List<ItemInCardCollection> items;
    private TotalCardCollection total;
}
