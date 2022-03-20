package antd.table.infinite.scroll.backend.model.dto;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class UserResponseDTO {

    private Long id;

    private String name;

    private String imageUrl;

    private String dept;

    private String position;

}
