package com.uca.cinema.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.uca.cinema.domain.CUser;

@Repository
public interface UserRepository extends JpaRepository<CUser, Integer>{
	public CUser findFirstByUsernameAndPasswd(String username, String password);
	
	@Modifying
	@Query("update CUser u set u.loggedin = ?1 where u.idUser = ?2")
	public void setUserInfoById(boolean logged, Integer userId);
	
}
