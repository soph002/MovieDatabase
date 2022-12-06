package Files;

import Movie.IMBDMovies;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class parseData {

    int rank=0;
    String title=" ";
    int year=0;

    private void parseGeneralData(Scanner lineScan)
    {
        lineScan.useDelimiter("\t"); //https://www.knpcode.com/2021/03/how-to-read-delimited-file-in-java.html
        rank = Integer.parseInt(lineScan.next());
        title = lineScan.next();
        year = Integer.parseInt(lineScan.next());
    }

    public IMBDMovies parseTopRatedData(String s)
    //parses data based on tab
    {
        double rating=0.0;
        Scanner lineScan = new Scanner(s);
        parseGeneralData(lineScan);
        while (lineScan.hasNext()) {
            rating = Double.parseDouble(lineScan.next());
        }
        return new IMBDMovies(title,year,rating,rank);
    }
    public void parseMovieGrossData(HashMap<String, IMBDMovies> imbdMovies, String fileLine) {
        int boxOffice=0;
        Scanner lineScan=new Scanner(fileLine);
        parseGeneralData(lineScan);
        while (lineScan.hasNext()) {
            boxOffice = Integer.parseInt(lineScan.next());
        }
        if(imbdMovies.containsKey(title))
        {
            imbdMovies.get(title).addEarnings(boxOffice);
            imbdMovies.get(title).addMoneyRank(rank);
        }
    }

    public void parseMovieCastData(HashMap<String, IMBDMovies> imbdMovies, String fileLine){
        // Rank	Title	Year	Director	Cast 1	Cast 2	Cast 3	Cast 4	Cast 5
        String director=" ";
        ArrayList<String> top5cast=new ArrayList<>();
        Scanner lineScan=new Scanner(fileLine);
        parseGeneralData(lineScan);
        while (lineScan.hasNext()) {
            director = lineScan.next();
            top5cast.add(lineScan.next());
        }
        if(imbdMovies.containsKey(title))
        {
            imbdMovies.get(title).addDirector(director);
            imbdMovies.get(title).addCast(top5cast);
        }
    }
}
