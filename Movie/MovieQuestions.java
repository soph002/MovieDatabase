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
    private final String ratingFile= "Movie_Data/imdb_movies_toprated.txt";
    private final String movieGrossFile= "Movie_Data/imdb_movies_gross.txt";
    private final String movieCastFile= "Movie_Data/imdb_movies_cast.txt";

    private ArrayList<IMBDMovies> moviesList;

    //Question number correlated to a class that can answer a question
    //used answersquestions instead of moviedatauser since that doesn't necessary answer a question
    private HashMap<Integer, AnswerQuestions> questions=new HashMap<>();

    private String optionsForUser="Enter a number based off the following list of options" +
            "\n 1. Total Earnings for a year " + //year then add up earnings
            "\n 2. List of Directors " + //gives list of directors
            "\n 3. Directors appearing Most " + // number of directors
            "\n 4. Director/Cast information based on Rating or Money Rank" + // director/cast then rating/money rank
            "\n 5. Highest Ranked Movie based on a year"; //year then find highest rank

    public MovieQuestions(){
        moviesList=new ReadInFiles().readInMovieFiles(ratingFile,movieGrossFile,movieCastFile);
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
            System.out.println(optionsForUser);
            int userIn = Integer.parseInt(input.nextLine());
            while(userIn>questions.size())
            {
                System.out.println(INVALID_INPUT_TRY_AGAIN +optionsForUser);
                userIn=Integer.parseInt(input.nextLine());
            }
            System.out.println(questions.get(userIn).answerToQuestion());
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
