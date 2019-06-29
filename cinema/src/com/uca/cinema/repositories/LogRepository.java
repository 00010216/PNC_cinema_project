package com.uca.cinema.repositories;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.uca.cinema.domain.LogAction;

@Repository
public interface LogRepository extends JpaRepository<LogAction, Integer>{
	@Query(nativeQuery=true, value="SELECT * FROM log_action l INNER JOIN c_user u ON l.id_user = u.id_user")
	public List<LogAction> getAllByName();
}
