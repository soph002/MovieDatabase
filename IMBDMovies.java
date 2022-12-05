// Class to keep track of all the info for each movie

import java.util.ArrayList;

public class IMBDMovies {

    private String title;
    private int year;
    private double rating;
    private int earnings;
    private String director;
    private int ratingRank;
    private int moneyRank;
    private ArrayList<String> castMembers;

    public IMBDMovies(String movieTitle,int yearCreated, double movieRating, int rankRating){
        title=movieTitle;
        year=yearCreated;
        rating=movieRating;
        ratingRank=rankRating;
    }

    public void addMoneyRank(int rank){
        moneyRank=rank;
    }

    public void addEarnings(int movieEarnings){
        earnings=movieEarnings;
    }

    public void addDirector(String theDirector){
        director=theDirector;
    }

    public void addCast(ArrayList<String> cast)
    {
        castMembers=cast;
    }

    public String getTitle(){
        return title;
    }

    public String getDirector(){
        return director;
    }


}
