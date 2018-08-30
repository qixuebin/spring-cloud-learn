package com.itmuch.cloud.repository;

import com.itmuch.cloud.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author qixuebin
 * @create 2017-12-18 14:24
 **/
@Repository
public interface UserRepository  extends JpaRepository<User,Long>{

}
