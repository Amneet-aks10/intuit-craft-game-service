package com.amneet.intuitcraftgame.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.amneet.intuitcraftgame.model.Player;

/**
 * @author amneetkaursawhney
 * Repository
 */
@Repository
public interface PlayerRepository extends CrudRepository<Player, Integer> {
	
	//To Find Top Scores & Player Details
	@Query(value = "select * from player where score in (select distinct score from player order by score desc limit :limit) order by score desc", nativeQuery = true)
	List<Player> findTopN(@Param("limit") int limit);


}
