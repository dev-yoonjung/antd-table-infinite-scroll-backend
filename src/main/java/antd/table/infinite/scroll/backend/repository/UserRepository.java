package antd.table.infinite.scroll.backend.repository;

import antd.table.infinite.scroll.backend.model.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Page<User> findAllByOrderByIdDesc(Pageable pageable);
}
