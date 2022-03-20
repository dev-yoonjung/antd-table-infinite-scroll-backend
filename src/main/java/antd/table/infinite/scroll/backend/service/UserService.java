package antd.table.infinite.scroll.backend.service;

import antd.table.infinite.scroll.backend.model.dto.UserResponseDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UserService {
    public Page<UserResponseDTO> find (Pageable pageable);
}
