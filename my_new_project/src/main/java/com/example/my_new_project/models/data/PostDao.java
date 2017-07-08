package com.example.my_new_project.models.data;

import com.example.my_new_project.models.Post;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Natalie on 7/2/2017.
 */
public interface PostDao extends CrudRepository<Post,Integer> {
}