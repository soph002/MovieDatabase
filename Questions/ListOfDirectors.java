package Questions;

import Movie.IMBDMovies;

import java.util.ArrayList;
import java.util.HashSet;

//  Give a list of all the directors of movies in the database.
//  The list should be in alphabetical order and not list any director twice.

public class ListOfDirectors extends MovieDataUser implements  AnswerQuestions{


    public static final String NEW_LINE_DELIMITER = "\n";

    public ListOfDirectors(ArrayList<IMBDMovies> movieList)
    {
        super(movieList);
    }
    @Override
    public String getAnswerToQuestion() {
        return findAnswer();
    }

    @Override
    public String findAnswer() {
        HashSet<String> directorList=new HashSet<>();
        for(int i=0;i<movieData.size();i++)
        {
            if(!movieData.get(i).getDirector().equals(NO_DIRECTOR_LISTED))
            {
                directorList.add(movieData.get(i).getDirector());
            }
        }
        return String.join(NEW_LINE_DELIMITER,directorList);
    }
}
