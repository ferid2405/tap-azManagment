package az.millisoft.tapaz.repository;

import az.millisoft.tapaz.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Service
@Repository
public interface CategoryRepository extends JpaRepository<Category,Integer> {
}
