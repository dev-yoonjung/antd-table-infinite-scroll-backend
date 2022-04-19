package antd.table.infinite.scroll.backend.domain.music.repository;

import antd.table.infinite.scroll.backend.domain.music.entity.Music;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MusicRepository extends CrudRepository<Music, Long> {

    @Query("select m from Music m where m.id > :lastIndex order by m.likeCount desc")
    List<Music> findOrderByIdDesc(@Param("lastIndex") Long lastIndex, Pageable pageable);

}
