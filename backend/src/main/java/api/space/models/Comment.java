package api.space.models;

import java.util.List;
import java.util.ArrayList;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tb_comment")
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;

    @Column(name = "description", nullable = false, columnDefinition = "TEXT")
    private String description;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User author;

    @OneToMany
    @JoinColumn(name = "likes_id", referencedColumnName = "id")
    private List<User> likes = new ArrayList<>();

    @OneToMany
    @JoinColumn(name = "answers_id", referencedColumnName = "id")
    private List<Comment> answers = new ArrayList<>();
}
