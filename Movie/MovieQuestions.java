package Movie;

import Movie_Data.ReadInFiles;
import Questions.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;


public class MovieQuestions {

    public static final String INVALID_INPUT_TRY_AGAIN = "Invalid Input, Try again";
    public static final String NO = "No";
    public static final String YES = "Yes";
    public static final String MORE_QUESTIONS = "Would you like to ask another question? (Enter Yes/No)";
    public static final String RATING_FILE = "Movie_Data/imdb_movies_toprated.txt";
    public static final String MOVIE_GROSS_FILE = "Movie_Data/imdb_movies_gross.txt";
    public static final String MOVIE_CAST_FILE = "Movie_Data/imdb_movies_cast.txt";
    public static final String OPTIONS_FOR_USER = "Enter a number based off the following list of options" +
            "\n 1. Total Earnings for a year " + //year then add up earnings
            "\n 2. List of Directors " + //gives list of directors
            "\n 3. Directors appearing Most " + // number of directors
            "\n 4. Director/Cast information based on Rating or Money Rank" + // director/cast then rating/money rank
            "\n 5. Highest Ranked Movie based on a year";

    private final ArrayList<IMBDMovies> moviesList;

    //Question number correlated to a class that can answer a question
    //used answersquestions instead of moviedatauser since that doesn't necessary answer a question
    private final HashMap<Integer, AnswerQuestions> questions=new HashMap<>();
    public MovieQuestions(){
        moviesList=new ReadInFiles().readInMovieFiles(RATING_FILE, MOVIE_GROSS_FILE, MOVIE_CAST_FILE);
        questions.put(1,new YearlyEarnings(moviesList));
        questions.put(2,new ListOfDirectors(moviesList));
        questions.put(3,new DirectorsAppearances(moviesList));
        questions.put(4,new InfoBasedOnRank(moviesList));
        questions.put(5,new BestMovie(moviesList));
    }

    public void runMovieQuestions(){
        Scanner input = new Scanner(System.in);
        boolean cont = true;
        while (cont) { //until player quits
            System.out.println(OPTIONS_FOR_USER); //asks user for question input
            int userIn = Integer.parseInt(input.nextLine());
            while(userIn>questions.size()) //validates number
            {
                System.out.println(INVALID_INPUT_TRY_AGAIN + OPTIONS_FOR_USER);
                userIn=Integer.parseInt(input.nextLine());
            }
            System.out.println(questions.get(userIn).getAnswerToQuestion());
            System.out.println(MORE_QUESTIONS);
            String choice=input.nextLine();
            while(!(choice.equals(YES) || choice.equals(NO))){
                System.out.println(INVALID_INPUT_TRY_AGAIN);
                choice=input.nextLine();
            }
            if(choice.equals(NO))
            {
                cont=false;
            }
        }
    }






}
