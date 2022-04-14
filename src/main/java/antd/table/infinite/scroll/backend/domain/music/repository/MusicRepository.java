package antd.table.infinite.scroll.backend.domain.music.repository;

import antd.table.infinite.scroll.backend.domain.music.entity.Music;
import org.springframework.data.repository.CrudRepository;

public interface MusicRepository extends CrudRepository<Music, Long> {
}
