package sofyuni.sfworkshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sofyuni.sfworkshop.model.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, String> {


}
