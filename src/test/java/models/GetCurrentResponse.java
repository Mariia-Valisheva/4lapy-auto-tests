package models;

import lombok.Data;

@Data
public class GetCurrentResponse {
    private String id, phone, email, name, lastName, gender, dateEmailConfirmation, birthDate, customerId,
            manzana, externalId, keycloakId, cardNumber;
    private Boolean isElectronicCheckAccepted;
}
