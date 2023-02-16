package api.space.models;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tb_user")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;

    @Column(name = "name", nullable = false, length = 100)
    private String name;

    @Column(name = "email", nullable = false, length = 100)
    private String email;

    @Column(name = "password", nullable = false, length = 100)
    private String password;

    @OneToOne
    @JoinColumn(name = "address_id", referencedColumnName = "id")
    private Address address;

    @OneToMany
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private List<Image> photos = new ArrayList<>();

    @OneToOne
    @JoinColumn(name = "profile_photo_id", referencedColumnName = "id")
    private Image profilePhoto;

    @OneToMany
    @JoinColumn(name = "friend_id", referencedColumnName = "id")
    private List<User> friends = new ArrayList<>();

    @OneToMany(mappedBy = "author")
    private List<Post> posts = new ArrayList<>();

}
