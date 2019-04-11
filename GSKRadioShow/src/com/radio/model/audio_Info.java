package com.radio.model;

public class audio_Info {
	private int audio_id;
	private String audioshow_name;
	private String audio_name;
	private String audio_duration;
	private String audio_select;
	private String audio_played;
	private String audio_max;
	private String audio_min;
	private String audio_selectanother;
	private String audio_genre;
	private String audio_date;
	private String audio_dayname;

	public int getAudio_id() {
		return audio_id;
	}

	public audio_Info(int audio_id, String audioshow_name, String audio_name, String audio_duration,
			String audio_select, String audio_played, String audio_max, String audio_min, String audio_selectanother,
			String audio_genre, String audio_date, String audio_dayname) {
		super();
		this.audio_id = audio_id;
		this.audioshow_name = audioshow_name;
		this.audio_name = audio_name;
		this.audio_duration = audio_duration;
		this.audio_select = audio_select;
		this.audio_played = audio_played;
		this.audio_max = audio_max;
		this.audio_min = audio_min;
		this.audio_selectanother = audio_selectanother;
		this.audio_genre = audio_genre;
		this.audio_date = audio_date;
		this.audio_dayname = audio_dayname;
	}

	public String getAudio_selectanother() {
		return audio_selectanother;
	}

	public void setAudio_selectanother(String audio_selectanother) {
		this.audio_selectanother = audio_selectanother;
	}

	public void setAudio_id(int audio_id) {
		this.audio_id = audio_id;
	}

	public String getAudioshow_name() {
		return audioshow_name;
	}

	public void setAudioshow_name(String audioshow_name) {
		this.audioshow_name = audioshow_name;
	}

	public String getAudio_name() {
		return audio_name;
	}

	public void setAudio_name(String audio_name) {
		this.audio_name = audio_name;
	}

	public String getAudio_duration() {
		return audio_duration;
	}

	public void setAudio_duration(String audio_duration) {
		this.audio_duration = audio_duration;
	}

	public String getAudio_select() {
		return audio_select;
	}

	public void setAudio_select(String audio_select) {
		this.audio_select = audio_select;
	}

	public String getAudio_played() {
		return audio_played;
	}

	public void setAudio_played(String audio_played) {
		this.audio_played = audio_played;
	}

	public String getAudio_max() {
		return audio_max;
	}

	public void setAudio_max(String audio_max) {
		this.audio_max = audio_max;
	}

	public String getAudio_min() {
		return audio_min;
	}

	public void setAudio_min(String audio_min) {
		this.audio_min = audio_min;
	}

	public String getAudio_genre() {
		return audio_genre;
	}

	public void setAudio_genre(String audio_genre) {
		this.audio_genre = audio_genre;
	}

	public String getAudio_date() {
		return audio_date;
	}

	public void setAudio_date(String audio_date) {
		this.audio_date = audio_date;
	}

	public String getAudio_dayname() {
		return audio_dayname;
	}

	public void setAudio_dayname(String audio_dayname) {
		this.audio_dayname = audio_dayname;
	}

}
