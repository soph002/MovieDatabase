package Movie;// Class to keep track of all the info for each movie

import java.util.ArrayList;

public class IMBDMovies {

    private String title;
    private int year;
    private double rating; //IBMD Rating
    private int earnings=0;
    private String director="no director listed";
    private int ratingRank; //IMBD Rank by Rating
    private int grossingRank; //Rank by grossing money made
    private String castMembers="no cast listed";

    public IMBDMovies(String movieTitle,int yearCreated, double movieRating, int rankRating){
        title=movieTitle;
        year=yearCreated;
        rating=movieRating;
        ratingRank=rankRating;
    }

    public void addMoneyRank(int rank){
        grossingRank =rank;
    }

    public void addEarnings(int movieEarnings){
        earnings=movieEarnings;
    }

    public void addDirector(String theDirector){
        director=theDirector;
    }

    public void addCast(ArrayList<String> cast)
    {
        castMembers=String.join(" ,",cast);
    }

    public String getTitle(){
        return title;
    }

    public String getDirector(){
        return director;
    }

    public int getYear(){
        return year;
    }

    public int getEarnings(){
        return earnings;
    }

    public String getCast(){
        return castMembers;
    }

    public int getRatingRank(){
        return ratingRank;
    }

    public int getGrossingRank(){
        return grossingRank;
    }

}
