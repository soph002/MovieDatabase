package Questions;

import Movie.IMBDMovies;

import java.util.ArrayList;
import java.util.HashSet;

public class ListOfDirectors extends MovieDataUser implements  AnswerQuestions{

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
            if(!movieData.get(i).getDirector().equals("no director listed"))
            {
                directorList.add(movieData.get(i).getDirector());
            }
        }
        return String.join("\n",directorList);
    }
}
