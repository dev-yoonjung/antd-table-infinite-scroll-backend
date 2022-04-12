package antd.table.infinite.scroll.backend.domain.field.entity;

import antd.table.infinite.scroll.backend.domain.base.BaseEntity;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EqualsAndHashCode(of = {"id"}, callSuper = false)
public class Field extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String dataIndex;

    @Column(nullable = false, unique = true)
    private String title;

    @Column
    private Integer width;

}
