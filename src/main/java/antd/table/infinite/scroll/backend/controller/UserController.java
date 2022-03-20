package antd.table.infinite.scroll.backend.controller;

import antd.table.infinite.scroll.backend.model.dto.UserResponseDTO;
import antd.table.infinite.scroll.backend.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/user")
    public ResponseEntity<List<UserResponseDTO>> find(@PageableDefault(size = 15) Pageable pageable) {
        return ResponseEntity.ok(userService.find(pageable).getContent());
    }
}
