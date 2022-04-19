package antd.table.infinite.scroll.backend.api.music.rank.controller;

import antd.table.infinite.scroll.backend.api.music.rank.dto.MusicRankDto;
import antd.table.infinite.scroll.backend.api.music.rank.service.RankService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/music/rank")
public class RankController {

    private final RankService rankService;

    @GetMapping
    public ResponseEntity<List<MusicRankDto>> getRank(@RequestParam Long lastIndex, @RequestParam Integer size) {
        log.info("Last index: {}, Number to show per page: {}", lastIndex, size);
        List<MusicRankDto> body = rankService.getRank(lastIndex, size);
        return ResponseEntity.ok(body);
    }

    @GetMapping("/count")
    public ResponseEntity<Long> getCount() {
        return ResponseEntity.ok(rankService.getCount());
    }
}
