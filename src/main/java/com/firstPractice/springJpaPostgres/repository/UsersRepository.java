package com.firstPractice.springJpaPostgres.repository;

import com.firstPractice.springJpaPostgres.entity.Users;
import jdk.dynalink.linker.LinkerServices;
import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UsersRepository extends JpaRepository<Users, Long> {
    List<Users> findAllByName(String name);

    @Query("select u from Users u where u.email like '%@gmail.com%'")
    List<User> findWhereEmailIsGmail();

    @Query(value = "select * from users where name like '%smith%'", nativeQuery = true)
    List<Users> findWhereNameStartsFromSmith();
}
