import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MovieQuestions {

    private final String ratingFile="imdb_movies_toprated.txt";
    private final String movieGrossFile="imdb_movies_gross.txt";
    private final String movieCastFile="imdb_movies_cast.txt";

    private ArrayList<IMBDMovies> moviesList;

    private HashMap<Integer,String> questions=new HashMap<>();

    private String optionsForUser="1. Total Earnings for a year " +
            "\n 2. List of Directors " +
            "\n 3. Directors appearing Most " +
            "\n 4. Director/Cast information based on Rating or Money Rank" +
            "\n 5. Highest Ranked Movie based on a year";


    public MovieQuestions(){
//        ratingFile=ratingFileName;
//        movieGrossFile=movieGrossFileName;
//        movieCastFile=movieCastFileName;
        moviesList=new ReadInFiles().readInMovieFiles(ratingFile,movieGrossFile,movieCastFile);
        questions.put(1,"Look at total earnings for a year");
        questions.put(2,"List of directors");
        questions.put(3,"List of # of directors who appear most");
        questions.put(4,"Give director/cast based on rating/money rank");
        questions.put(5,"Highest Ranked movie based on a year");
    }

    public void runMovieQuestions(){
        Scanner input = new Scanner(System.in);
        boolean cont = true;
        while (cont) { //until player quits
            System.out.println(optionsForUser);
            String userIn = input.nextLine();
        }
    }






}
