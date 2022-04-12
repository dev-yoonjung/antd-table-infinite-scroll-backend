package antd.table.infinite.scroll.backend.domain.music.entity;

import antd.table.infinite.scroll.backend.domain.base.BaseEntity;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EqualsAndHashCode(of = {"id"}, callSuper = false)
@ToString
public class Music extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String title;

    @Column(nullable = false, length = 100)
    private String artist;

    @Column(nullable = false, length = 100)
    private String album;

    @Column(columnDefinition = "integer default 0")
    private Integer likeCount;

    @Builder
    public Music(
            String title,
            String artist,
            String album,
            Integer likeCount
    ) {
        this.title = title;
        this.artist = artist;
        this.album = album;
        this.likeCount = likeCount;
    }

    public static Music of(Music music) {
        return Music.builder()
                .title(music.getTitle())
                .artist(music.getArtist())
                .album(music.getAlbum())
                .likeCount(music.getLikeCount())
                .build();
    }

}
