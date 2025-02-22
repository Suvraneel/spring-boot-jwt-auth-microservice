package ai.vision.vishnu.repository;

import ai.vision.vishnu.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.NativeQuery;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);

    @NativeQuery("SELECT * FROM users WHERE id = :id and is_active = true")
    User findUserById(Long id);

    @NativeQuery("SELECT * FROM users WHERE name = :name and is_active = true")
    User findUserByName(String name);
}
