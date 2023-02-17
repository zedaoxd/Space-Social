package api.space.dtos;

import lombok.*;
import api.space.models.Address;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class AddressDTO {

    @EqualsAndHashCode.Include
    private Long id;
    private String street;
    private String number;
    private String city;
    private String state;
    private String zip;

    public AddressDTO(Address address) {
        this.id = address.getId();
        this.street = address.getStreet();
        this.number = address.getNumber();
        this.city = address.getCity();
        this.state = address.getState();
        this.zip = address.getZip();
    }

    public Address toEntity() {
        return new Address(id, street, number, city, state, zip);
    }
}
