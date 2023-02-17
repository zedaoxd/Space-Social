package api.space.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import java.util.ArrayList;
import java.util.List;
import api.space.models.User;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class UserDTO {

    @EqualsAndHashCode.Include
    private Long id;
    private String name;
    private String email;
    private AddressDTO addressDTO;
    private List<PhotoDTO> photosDTO = new ArrayList<>();
    private PhotoDTO profilePhotoDTO;

    private List<UserDTO> friendsDTO = new ArrayList<>();
    private List<PostDTO> postsDTO = new ArrayList<>();

    public UserDTO(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public UserDTO(User user) {
        this.id = user.getId();
        this.name = user.getName();
        this.email = user.getEmail();
        this.addressDTO = new AddressDTO(user.getAddress());

        if (user.getProfilePhoto() != null)
            this.profilePhotoDTO = new PhotoDTO(user.getProfilePhoto());

        this.photosDTO = user.getPhotos().stream().map(PhotoDTO::new).toList();
        this.friendsDTO = user.getFriends().stream().map(UserDTO::new).toList();
        this.postsDTO = user.getPosts().stream().map(PostDTO::new).toList();
    }

    public User toEntity() {
        User user = new User();
        user.setId(id);
        user.setName(name);
        user.setEmail(email);
        user.setProfilePhoto(profilePhotoDTO.toEntity());
        user.setPhotos(photosDTO.stream().map(PhotoDTO::toEntity).toList());
        user.setFriends(friendsDTO.stream().map(UserDTO::toEntity).toList());
        user.setPosts(postsDTO.stream().map(PostDTO::toEntity).toList());
        return user;
    }
}
