package antd.table.infinite.scroll.backend.domain.music.service;

import antd.table.infinite.scroll.backend.domain.music.entity.Music;
import antd.table.infinite.scroll.backend.domain.music.repository.MusicRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MusicService {

    private final MusicRepository musicRepository;

    public List<Music> findByOOrderByIdDesc(Long lastIndex, Pageable pageable) {
        return musicRepository.findOrderByIdDesc(lastIndex, pageable);
    }

    public Long count() {
        return musicRepository.count();
    }

}
