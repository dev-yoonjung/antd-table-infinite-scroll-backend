package antd.table.infinite.scroll.backend.api.music.rank.dto;

import antd.table.infinite.scroll.backend.domain.music.entity.Music;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class MusicRankDto {

    private Long id;

    private Integer rank;

    private String title;

    private String artist;

    private String album;

    private Integer likeCount;

    public static MusicRankDto of(Music music, Integer rank) {
        return MusicRankDto.builder()
                .id(music.getId())
                .rank(rank)
                .title(music.getTitle())
                .artist(music.getArtist())
                .album(music.getAlbum())
                .likeCount(music.getLikeCount())
                .build();
    }

}
