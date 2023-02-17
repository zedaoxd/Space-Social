package api.space.dtos;

import lombok.Data;
import api.space.models.Comment;
import java.util.ArrayList;
import java.util.List;

@Data
public class CommentDTO {

    private Long id;
    private String description;
    private UserDTO userDTO;
    private List<CommentDTO> answersDTO;
    private List<UserDTO> likesDTO = new ArrayList<>();

    public CommentDTO(Comment comment) {
        this.id = comment.getId();
        this.description = comment.getDescription();
        this.userDTO = new UserDTO(comment.getAuthor());
        this.answersDTO = comment.getAnswers().stream().map(CommentDTO::new).toList();
        this.likesDTO = comment.getLikes().stream().map(UserDTO::new).toList();
    }

    public Comment toEntity() {
        return new Comment(
                id,
                description,
                userDTO.toEntity(),
                likesDTO.stream().map(UserDTO::toEntity).toList(),
                answersDTO.stream().map(CommentDTO::toEntity).toList());
    }
}
