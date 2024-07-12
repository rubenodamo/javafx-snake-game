package org.snake.controller;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.io.File;

/**
 * <h2>MusicPlayer</h2>
 * The {@code MusicPlayer} class represents a simple music player for playing background music.
 * It utilizes the JavaFX MediaPlayer for playing MP3 files.
 *
 * @author Ruben Odamo - modified
 */
public class MusicPlayer {

	private final String filename;
	private MediaPlayer mediaPlayer;

	/**
	 * Constructs a new {@code MusicPlayer} with the specified filename.
	 *
	 * @param filename The path to the MP3 file to be played.
	 */
	public MusicPlayer(String filename) {
		this.filename = filename;
		initializeMediaPlayer();
	}

	/**
	 * Initialises the MediaPlayer.
	 */
	private void initializeMediaPlayer() {
		Media media = new Media(new File(filename).toURI().toString());
		mediaPlayer = new MediaPlayer(media);
		mediaPlayer.setOnEndOfMedia(() -> mediaPlayer.seek(mediaPlayer.getStartTime()));
	}

	/**
	 * Play the music.
	 */
	public void play() {
		mediaPlayer.play();
	}

	/**
	 * Pause the music.
	 */
	public void pause() {
		mediaPlayer.pause();
	}

	/**
	 * Stop the music.
	 */
	public void stop() {
		mediaPlayer.stop();
	}

	/**
	 * Set the volume of the music.
	 *
	 * @param volume The volume level (0.0 to 1.0).
	 */
	public void setVolume(double volume) {
		mediaPlayer.setVolume(volume);
	}
}

