package com.jmurphey.lookify.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.jmurphey.lookify.models.Song;


@Repository
public interface SongRepo extends CrudRepository<Song, Long> {

	List<Song> findAll();
	
	List<Song> findByArtistContaining(String search);
	
	List<Song> findTop10ByOrderByRatingDesc();
	
	Optional<Song> findById(Long id);
	
}


//  *** Didn't Need These *** 
//	List<Song> findByRatingGreaterThan(int number);
//	List<Song> findAllOrderByRating();