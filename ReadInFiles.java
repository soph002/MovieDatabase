import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Scanner;

//reads in movie files and produces an arraylist of movies
public class ReadInFiles {

    private HashMap<String,IMBDMovies> imbdMovies;
    private parseData dataParserForMovies=new parseData();

    public ArrayList<IMBDMovies> readInMovieFiles(String ratingFile, String movieGrossFile, String movieCastFile){
        imbdMovies=new HashMap<>();
        scanRatingFile(ratingFile);
        scanMovieGrossFile(movieGrossFile);
        scanMovieCastFile(movieCastFile);
        Collection<IMBDMovies> list=imbdMovies.values();
        return new ArrayList<>(list);
    }

    //Scans the rating file and adds that data to the imbdMovies list
    public void scanRatingFile(String ratingFile){
        try {
            Scanner rating_file=new Scanner(new File(ratingFile));
            rating_file.nextLine(); //in order to skip past the first line of the file
            while(rating_file.hasNextLine()){ //https://www.knpcode.com/2021/03/how-to-read-delimited-file-in-java.html
                String fileLine=rating_file.nextLine();
                IMBDMovies currentLine=dataParserForMovies.parseTopRatedData(fileLine);
                imbdMovies.put(currentLine.getTitle(),currentLine);
            }
            rating_file.close();
        } catch (IOException exp) {
            exp.printStackTrace();
        }
    }

    //scan the movieGrossFile and update imbdMovies list
    public void scanMovieGrossFile(String movieGrossFile)
    {
        try{
            Scanner movie_gross_file=new Scanner(new File(movieGrossFile));
            movie_gross_file.nextLine();
            while(movie_gross_file.hasNextLine())
            {
                String fileLine=movie_gross_file.nextLine();
                dataParserForMovies.parseMovieGrossData(imbdMovies,fileLine);
            }
            movie_gross_file.close();
        }
        catch (IOException exp) {
        exp.printStackTrace();
        }
    }

    public void scanMovieCastFile(String movieCastFile){
        try{
            Scanner movie_cast_file=new Scanner(new File(movieCastFile));
            movie_cast_file.nextLine();
            while(movie_cast_file.hasNextLine())
            {
                String fileLine=movie_cast_file.nextLine();
                dataParserForMovies.parseMovieCastData(imbdMovies,fileLine);
            }
            movie_cast_file.close();
        }
        catch (IOException exp) {
            exp.printStackTrace();
        }
    }


}
