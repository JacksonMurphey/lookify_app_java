package com.jmurphey.lookify.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.jmurphey.lookify.models.Song;
import com.jmurphey.lookify.repositories.SongRepo;

@Service
public class SongService {
	
	private final SongRepo repo;
	
	public SongService(SongRepo repo) {
		this.repo = repo;
	}

	// Create
	public Song createSong(Song song) {
			return repo.save(song);
		}
		
	
	// Get All 
	public List<Song> allSongs(){
		return repo.findAll();
	}
	
	
	// Get one
	public Song findSong(Long id) {
		Optional<Song> optionalSong = repo.findById(id);
		if(optionalSong.isPresent()) {
			return optionalSong.get();
		} else {
			return null;
		}
	}
		// for the above method, If I didnt make it Optional<Song> in my Repo, 
		// I could have written it as follows:
		//	public Song findSong(Long id) {
		//		return repo.findById(id).orElse(null);
		//	}
	
	
	// This method calls my findSong() method. 
	public Song getSong(Long id) {
		return this.findSong(id);
	}
	
	
	// Delete one
	public void delete(Long id) {
		repo.deleteById(id);
	}
	
	
	// Get Songs by Artist 
	public List<Song> findArtistSongs(String artist){
		return repo.findByArtistContaining(artist);
	}
	
	// Get your Top Ten Songs
	public List<Song> topTenByRating(){
		return repo.findTop10ByOrderByRatingDesc();
	}
	
}



// *** Didn't Need These ** 

//	// Get Songs with rating greater than
//	public List<Song> getSongsGreaterThan(int rating){
//		return repo.findByRatingGreaterThan(rating);
//	}

//	// Get all, order by rating
//	public List<Song> allSongsOrdered(){
//		return repo.findAllOrderByRating();
//	}