package ohtu;

import java.util.List;

public class Submission {
    private int week;
	private int hours;
	private List<Integer> exercises;
	private int maxEx;

    public void setWeek(int week) {
        this.week = week;
    }

	public void setHours(int hours) {
		this.hours = hours;
	}

	public void setExcercises(List<Integer> exercises) {
		this.exercises = exercises;
	}

	public void setMaxEx(int maxEx) {
		this.maxEx = maxEx;
	}

    public int getWeek() {
        return week;
    }
	
	public int getHours() {
		return hours;
	}

	public List<Integer> getExercises() {
		return exercises;
	}
	
	public int getMaxEx() {
		return maxEx;
	}

    @Override
    public String toString() {
        return " Viikko " + week + ":\n tehtyjä tehtäviä yhteensä " + exercises.size() + " (Maksimi  "+ maxEx +"), aikaa kului yhteensä " + hours + " tuntia, tehdyt tehtävät: " + exercises.toString();
    }
    
}
