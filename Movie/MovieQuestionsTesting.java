package Movie;

import static org.junit.Assert.*;

import Movie.IMBDMovies;
import Movie_Data.ReadInFiles;
import Questions.BestMovie;
import Questions.ListOfDirectors;
import Questions.YearlyEarnings;
import org.junit.BeforeClass;
import org.junit.Test;

import java.time.Year;
import java.util.ArrayList;

public class MovieQuestionsTesting {

    private static final String RATING_FILE= "Testing_Data/imdb_movies_toprated_test.txt";
    private static final String MOVIE_GROSS_FILE= "Testing_Data/imdb_movies_gross_test.txt";
    private static final String MOVIE_CAST_FILE= "Testing_Data/imdb_movies_cast_test.txt";

    private static ArrayList<IMBDMovies> movieList;

    @BeforeClass
    public static void setUp(){
        movieList=new ReadInFiles().readInMovieFiles(RATING_FILE,MOVIE_GROSS_FILE,MOVIE_CAST_FILE);
    }

    @Test
    public void listOfDirectorsTest(){
        String expectedAnswer="Federico Fellini\n" +
                "John Lasseter\n" +
                "Leonard Nimoy\n" +
                "Clyde Geronimi\n" +
                "Zack Snyder\n" +
                "Roland Emmerich\n" +
                "Stanley Kubrick";
        assertEquals(expectedAnswer, new ListOfDirectors(movieList).answerToQuestion());
    }

    @Test
    public void bestMovieTest(){
        String expectedAnswer="The Avengers";
        String output=new BestMovie(movieList).answerToQuestion();
        assertEquals(expectedAnswer,output);
    }

}
