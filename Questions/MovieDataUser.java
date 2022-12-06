package Questions;

import Movie.IMBDMovies;

import java.util.ArrayList;

public abstract class MovieDataUser {

    ArrayList<IMBDMovies> movieData;

    public MovieDataUser(ArrayList<IMBDMovies> movieList)
    {
        movieData=movieList;
    }
}
