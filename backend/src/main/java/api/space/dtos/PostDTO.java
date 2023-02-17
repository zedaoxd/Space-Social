package api.space.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import api.space.models.Post;
import java.util.ArrayList;
import java.util.List;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@AllArgsConstructor
@NoArgsConstructor
public class PostDTO {

    @EqualsAndHashCode.Include
    private Long id;
    private String description;
    private String title;
    private UserDTO userDTO;
    private PhotoDTO photoDTO;
    private List<CommentDTO> commentsDTO = new ArrayList<>();

    public PostDTO(Post post) {
        this.id = post.getId();
        this.description = post.getDescription();
        this.title = post.getTitle();
        this.userDTO = new UserDTO(post.getAuthor());
        this.photoDTO = new PhotoDTO(post.getImage());
        this.commentsDTO = post.getComments().stream().map(CommentDTO::new).toList();
    }

    public Post toEntity() {
        return new Post(id, title, description, userDTO.toEntity(), photoDTO.toEntity(),
                commentsDTO.stream().map(CommentDTO::toEntity).toList());
    }
}
