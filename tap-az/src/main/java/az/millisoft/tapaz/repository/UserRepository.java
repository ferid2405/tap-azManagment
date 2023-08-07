package az.millisoft.tapaz.repository;

import az.millisoft.tapaz.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
@Repository
public interface UserRepository extends JpaRepository<User,Integer> {

    Optional<User> findUserByEmail(String email);

}
