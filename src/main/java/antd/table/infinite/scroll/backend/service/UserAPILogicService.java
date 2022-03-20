package antd.table.infinite.scroll.backend.service;

import antd.table.infinite.scroll.backend.model.dto.UserResponseDTO;
import antd.table.infinite.scroll.backend.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class UserAPILogicService implements UserService {

    private final UserRepository userRepository;

    @Override
    public Page<UserResponseDTO> find(Pageable pageable) {
        return userRepository.findAllByOrderByIdDesc(pageable).map(user -> UserResponseDTO.builder()
                .id(user.getId())
                .name(user.getName())
                .dept(user.getDept())
                .position(user.getPosition())
                .build());
    }
}
