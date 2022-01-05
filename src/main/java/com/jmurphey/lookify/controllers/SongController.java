package com.jmurphey.lookify.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jmurphey.lookify.models.Song;
import com.jmurphey.lookify.services.SongService;




@Controller
@RequestMapping("/")
public class SongController {
	
	private final SongService songService;
	public SongController(SongService songService) {
		this.songService = songService;
	}
	
	
	@GetMapping("")
	public String index(@ModelAttribute("song")Song song, Model model) {
		List<Song> songs = songService.allSongs();
		model.addAttribute("songs", songs);
		return "dash.jsp";
	}

//	Had to completely reformat how I thought I would have to do this. although I used a form
//	I had to not make the form a POST method in order to get it work. It also was stating it required a @ModelAttribute and Bindingresult...?
//
//	@PostMapping("")
//	public String findSongsByArtist(@Valid @ModelAttribute("song") Song song, BindingResult result, 
//			@RequestParam(value="artist") String artist) {
//		if(result.hasErrors()) {
//			return "dash.jsp";
//		} else {
//			songService.getArtistSongs(artist);
//			return "redirect:/search";
//		}
//	}
	
	@GetMapping("/search")
	public String showArtist(@RequestParam("artist") String artist, Model model, @ModelAttribute("song") Song song, BindingResult result) {
		
		model.addAttribute("artist", artist);
		model.addAttribute("songs", this.songService.findArtistSongs(artist));
		return "showArtist.jsp";
		
	}
	
	@GetMapping("/topten")
	public String topTen(Model model) {
		model.addAttribute("songs", this.songService.topTenByRating());
		return "topten.jsp";
	}
	
	
	@GetMapping("/songs/{id}")
	public String showSong(@PathVariable("id") Long id, Model model) {
		model.addAttribute("song", this.songService.getSong(id));
		return "song.jsp";
	}
	
	@GetMapping("/songs/new")
	public String newSong(@ModelAttribute("song")Song song) {
		return "new.jsp";
	}
	
	@PostMapping("/songs/new")
	public String create(@Valid @ModelAttribute("song")Song song, BindingResult result) {
		if (result.hasErrors()) {
			return "new.jsp";
		} else { 
			songService.createSong(song);
			return "redirect:/";
		}
	}
	
	
	@GetMapping("/delete/{id}")
	public String destroy(@PathVariable("id") Long id) {
		songService.delete(id);
		return "redirect:/";
				
	}
}
