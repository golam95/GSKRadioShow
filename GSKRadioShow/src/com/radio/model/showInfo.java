package com.radio.model;

import java.util.Date;

public class showInfo {

	private int show_id;
	private String show_name;
	private String show_Duration;
	private String minuts_advertising;
	private String voiceover;
	private String is_select;
	private String run_perday;
	private String genre;
	private String addshow_Date;
	private String show_dayname;

	public showInfo(int show_id, String show_name, String show_Duration, String minuts_advertising, String voiceover,
			String is_select, String run_perday, String genre, String addshow_Date, String show_dayname) {
		super();
		this.show_id = show_id;
		this.show_name = show_name;
		this.show_Duration = show_Duration;
		this.minuts_advertising = minuts_advertising;
		this.voiceover = voiceover;
		this.is_select = is_select;
		this.run_perday = run_perday;
		this.genre = genre;
		this.addshow_Date = addshow_Date;
		this.show_dayname = show_dayname;
	}

	public String getShow_Duration() {
		return show_Duration;
	}

	public void setShow_Duration(String show_Duration) {
		this.show_Duration = show_Duration;
	}

	public String getShow_dayname() {
		return show_dayname;
	}

	public void setShow_dayname(String show_dayname) {
		this.show_dayname = show_dayname;
	}

	public String getAddshow_Date() {
		return addshow_Date;
	}

	public void setAddshow_Date(String addshow_Date) {
		this.addshow_Date = addshow_Date;
	}

	public int getShow_id() {
		return show_id;
	}

	public void setShow_id(int show_id) {
		this.show_id = show_id;
	}

	public String getShow_name() {
		return show_name;
	}

	public void setShow_name(String show_name) {
		this.show_name = show_name;
	}

	public String getMinuts_advertising() {
		return minuts_advertising;
	}

	public void setMinuts_advertising(String minuts_advertising) {
		this.minuts_advertising = minuts_advertising;
	}

	public String getVoiceover() {
		return voiceover;
	}

	public void setVoiceover(String voiceover) {
		this.voiceover = voiceover;
	}

	public String getIs_select() {
		return is_select;
	}

	public void setIs_select(String is_select) {
		this.is_select = is_select;
	}

	public String getRun_perday() {
		return run_perday;
	}

	public void setRun_perday(String run_perday) {
		this.run_perday = run_perday;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

}
