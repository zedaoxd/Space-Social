package api.space.dtos;

import lombok.Data;
import api.space.models.Photo;

@Data
public class PhotoDTO {
    private Long id;
    private String title;
    private String url;

    public PhotoDTO(Photo photo) {
        this.id = photo.getId();
        this.title = photo.getTitle();
        this.url = photo.getUrl();
    }

    public Photo toEntity() {
        return new Photo(id, title, url);
    }
}
