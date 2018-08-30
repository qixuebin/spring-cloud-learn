package com.itmuch.cloud.authorization.repository;

import com.itmuch.cloud.authorization.domain.ClientDetailsDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author qixuebin
 * @create 2017-12-18 14:24
 **/
@Repository
public interface UserRepository extends JpaRepository<ClientDetailsDO,String>{


}
