package antd.table.infinite.scroll.backend.domain.field.repository;

import antd.table.infinite.scroll.backend.domain.field.entity.Field;
import org.springframework.data.repository.CrudRepository;

public interface FieldRepository extends CrudRepository<Field, Long> {
}
