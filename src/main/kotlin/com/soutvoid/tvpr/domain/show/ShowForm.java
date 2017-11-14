package com.soutvoid.tvpr.domain.show;

import com.soutvoid.tvpr.domain.genre.Genre;

import java.io.Serializable;
import java.util.List;

public class ShowForm implements Serializable {

    private String name = "";
    private int dayOfWeek = 0;
    private String startTime = "00:00";
    private String hours = "0";
    private String minutes = "0";
    private String genreName = "";

    public ShowForm() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDayOfWeek() {
        return dayOfWeek;
    }

    public void setDayOfWeek(int dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getHours() {
        return hours;
    }

    public void setHours(String hours) {
        this.hours = hours;
    }

    public String getMinutes() {
        return minutes;
    }

    public void setMinutes(String minutes) {
        this.minutes = minutes;
    }

    public String getGenreName() {
        return genreName;
    }

    public void setGenreName(String genreName) {
        this.genreName = genreName;
    }

    public Show getShow(List<Genre> allGenres) {
        Show show = new Show();
        show.setName(name);
        show.setDayOfWeek(dayOfWeek);
        show.setStartTime(getMinutes(startTime));
        show.setDuration(Long.parseLong(hours) * 60 + Long.parseLong(minutes));
        show.setGenre(allGenres.stream().filter(genre -> genre.getName().equals(genreName)).findFirst().get());
        return show;
    }

    public int getMinutes(String time) {
        return Integer.parseInt(time.substring(0, 2)) * 60 + Integer.parseInt(time.substring(3, 5));
    }

}