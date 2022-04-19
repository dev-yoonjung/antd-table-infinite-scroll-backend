package antd.table.infinite.scroll.backend.api.music.rank.service;

import antd.table.infinite.scroll.backend.api.music.rank.dto.MusicRankDto;
import antd.table.infinite.scroll.backend.domain.music.entity.Music;
import antd.table.infinite.scroll.backend.domain.music.service.MusicService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class RankService {

    private final MusicService musicService;

    public List<MusicRankDto> getRank(Long lastIndex, Pageable pageable) {
        List<Music> musicList = musicService.findByOOrderByIdDesc(lastIndex, pageable);
        AtomicInteger index = new AtomicInteger();

        return musicList.stream()
                .map(music -> MusicRankDto.of(music, index.getAndIncrement()))
                .collect(Collectors.toList());
    }

    public Long getCount() {
        return musicService.count();
    }

}
