package Movie;

import static org.junit.Assert.*;

import Movie_Data.ReadInFiles;
import Questions.BestMovie;
import Questions.InfoBasedOnRank;
import Questions.ListOfDirectors;
import Questions.YearlyEarnings;
import org.junit.BeforeClass;
import org.junit.Test;

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
        assertEquals(expectedAnswer, new ListOfDirectors(movieList).getAnswerToQuestion());
    }

    @Test
    public void bestMovieTest(){
        String expectedAnswer="The Avengers";
        String output=new BestMovie(movieList).getAnswerToQuestion(2012);
        assertEquals(expectedAnswer,output);
    }

    @Test
    public void bestMovieBadYearTest(){
        String expectedAnswer="No data for given year of 6009";
        assertEquals(expectedAnswer,new BestMovie(movieList).getAnswerToQuestion(6009));
    }

    @Test
    public void infoBasedOnRankTestDirector(){
        // should give the avengers director
        String expectedAnswer="Leonard Nimoy";
        assertEquals(expectedAnswer,new InfoBasedOnRank(movieList).getAnswerToQuestion(3,"grossing","director"));
    }

    @Test
    public void infoBasedOnRankTestCast(){
        //should give back dark knight rises cast
        String expectedAnswer="Marcello Mastroianni ,Claudia Cardinale ,Anouk Aimée ,Sandra Milo ,Rossella Falk";
        assertEquals(expectedAnswer,new InfoBasedOnRank(movieList).getAnswerToQuestion(12,"rating","cast"));
    }

    @Test
    public void infoBasedOnRankBadTest(){
        //Method should catch bad input with error statement
        String expectedAnswer="No cast found for movie based on rating at rank 120";
        assertEquals(expectedAnswer,new InfoBasedOnRank(movieList).getAnswerToQuestion(120,"rating","cast"));
    }

    @Test
    public void yearlyEarningsTest(){
        //tests with good input to make sure it is adding up the earnings correctly
        String expectedAnswer="1071410189";
        assertEquals(expectedAnswer,new YearlyEarnings(movieList).getAnswerToQuestion(2012));
    }

    @Test
    public void yearlyEarningsBadTest(){
        //bad input test
        String expectedAnswer="0";
        assertEquals(expectedAnswer, new YearlyEarnings(movieList).getAnswerToQuestion(7000));
    }

}
