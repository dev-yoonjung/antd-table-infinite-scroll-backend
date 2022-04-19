package antd.table.infinite.scroll.backend.domain.music.repository;

import antd.table.infinite.scroll.backend.domain.music.entity.Music;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MusicRepository extends CrudRepository<Music, Long> {

    @Query(value = "select " +
            "m.id, m.title, m.artist, m.album, m.like_count, m.create_time, m.update_time " +
            "from (" +
            "select id, title, artist, album, like_count, create_time, update_time, rank() over (order by like_count desc) as 'rank' from music" +
            ") m " +
            "where m.rank > :lastIndex " +
            "order by m.rank",
            countQuery = "select count(id) from music",
            nativeQuery = true)
    List<Music> findOrderByIdDesc(@Param("lastIndex") Long lastIndex, Pageable pageable);

}
