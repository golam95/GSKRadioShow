package com.radio.model;

public class video_Info {
	private int video_id;
	private String videoshow_name;
	private String video_name;
	private String video_duration;
	private String video_select;
	private String video_played;
	private String video_max;
	private String video_min;
	private String video_selectanother;
	private String video_genre;
	private String video_date;
	private String video_dayname;

	public video_Info(int video_id, String videoshow_name, String video_name, String video_duration,
			String video_select, String video_played, String video_max, String video_min, String video_selectanother,
			String video_genre, String video_date, String video_dayname) {
		super();
		this.video_id = video_id;
		this.videoshow_name = videoshow_name;
		this.video_name = video_name;
		this.video_duration = video_duration;
		this.video_select = video_select;
		this.video_played = video_played;
		this.video_max = video_max;
		this.video_min = video_min;
		this.video_selectanother = video_selectanother;
		this.video_genre = video_genre;
		this.video_date = video_date;
		this.video_dayname = video_dayname;
	}

	public String getVideo_selectanother() {
		return video_selectanother;
	}

	public void setVideo_selectanother(String video_selectanother) {
		this.video_selectanother = video_selectanother;
	}

	public int getVideo_id() {
		return video_id;
	}

	public void setVideo_id(int video_id) {
		this.video_id = video_id;
	}

	public String getVideoshow_name() {
		return videoshow_name;
	}

	public void setVideoshow_name(String videoshow_name) {
		this.videoshow_name = videoshow_name;
	}

	public String getVideo_name() {
		return video_name;
	}

	public void setVideo_name(String video_name) {
		this.video_name = video_name;
	}

	public String getVideo_duration() {
		return video_duration;
	}

	public void setVideo_duration(String video_duration) {
		this.video_duration = video_duration;
	}

	public String getVideo_select() {
		return video_select;
	}

	public void setVideo_select(String video_select) {
		this.video_select = video_select;
	}

	public String getVideo_played() {
		return video_played;
	}

	public void setVideo_played(String video_played) {
		this.video_played = video_played;
	}

	public String getVideo_max() {
		return video_max;
	}

	public void setVideo_max(String video_max) {
		this.video_max = video_max;
	}

	public String getVideo_min() {
		return video_min;
	}

	public void setVideo_min(String video_min) {
		this.video_min = video_min;
	}

	public String getVideo_genre() {
		return video_genre;
	}

	public void setVideo_genre(String video_genre) {
		this.video_genre = video_genre;
	}

	public String getVideo_date() {
		return video_date;
	}

	public void setVideo_date(String video_date) {
		this.video_date = video_date;
	}

	public String getVideo_dayname() {
		return video_dayname;
	}

	public void setVideo_dayname(String video_dayname) {
		this.video_dayname = video_dayname;
	}

}
