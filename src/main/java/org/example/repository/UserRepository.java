package org.example.repository;

import org.example.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    /*@Query("SELECT a FROM User a JOIN FETCH a.phones WHERE a.id = :id")
    Optional<User> findByIdWithPones(@Param("id") Long id);

    @Query("SELECT a FROM User a JOIN FETCH a.phones")
    List<User> findAllWithPones();*/

    /*@Query("SELECT name , rolename\n" +
            "FROM roles_users ru\n" +
            "JOIN users ON ru.users_id = users.id\n" +
            "JOIN roles ON ru.roles_id = roles.id;")
    List<User> findAllWithRole();*/
}