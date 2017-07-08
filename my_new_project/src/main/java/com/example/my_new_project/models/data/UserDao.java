package com.example.my_new_project.models.data;

import com.example.my_new_project.models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Natalie on 7/2/2017.
 */
@Repository
@Transactional
public interface UserDao extends CrudRepository<User,Integer> {
}
