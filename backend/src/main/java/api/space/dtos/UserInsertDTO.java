package api.space.dtos;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

import api.space.models.User;

@Getter
@Setter
public class UserInsertDTO extends UserDTO {

    private String password;
    private AddressDTO addressDTO;

    public UserInsertDTO() {

    }

    public UserInsertDTO(String name, String email, String password, AddressDTO addressDTO) {
        super(name, email);
        this.password = password;
        this.addressDTO = addressDTO;
    }

    public User toEntity() {
        return new User(
                null,
                getName(),
                getEmail(),
                getPassword(),
                getAddressDTO().toEntity(),
                new ArrayList<>(),
                null,
                new ArrayList<>(),
                new ArrayList<>());
    }
}
