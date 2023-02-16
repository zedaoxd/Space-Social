package api.space.models;

import java.util.ArrayList;
import java.util.List;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tb_post")
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;

    @Column(name = "title", nullable = false, length = 100)
    private String title;

    @Column(name = "description", nullable = false, columnDefinition = "TEXT")
    private String description;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User author;

    @OneToOne
    @JoinColumn(name = "image_id", referencedColumnName = "id")
    private Image image;

    @OneToMany
    @JoinColumn(name = "post_id", referencedColumnName = "id")
    private List<Comment> comments = new ArrayList<>();

}
