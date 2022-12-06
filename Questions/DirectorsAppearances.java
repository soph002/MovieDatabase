package Questions;

import Movie.IMBDMovies;

import java.util.ArrayList;
import java.util.HashMap;

public class DirectorsAppearances extends MovieDataUser implements FurtherQuestions,AnswerQuestions{

    int numDirectors;

    public DirectorsAppearances(ArrayList<IMBDMovies> movieList)
    {
        super(movieList);
    }
    @Override
    public String answerToQuestion() {
        furtherQuestions();
        HashMap<String,Integer> directorAppearances=directorsWithNumAppearances();
        return "not complete coded";
    }

    @Override
    public void furtherQuestions() {
        System.out.println("What number of directors that appear the most?");
        numDirectors=Integer.parseInt(input.nextLine());
    }

    public HashMap<String,Integer> directorsWithNumAppearances(){
        HashMap<String,Integer> directorAppearances=new HashMap<>(); //Director name linked to the number of appearances
        for(int i=0;i<movieData.size();i++)
        {
            String currentDirector=movieData.get(i).getDirector();
            if(directorAppearances.containsKey(currentDirector))
            {
                directorAppearances.replace(currentDirector,directorAppearances.get(currentDirector)+1);
            }
            else{
                directorAppearances.put(currentDirector, 1);
            }
        }
        return directorAppearances;
    }
}
