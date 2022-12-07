package Questions;

import Movie.IMBDMovies;

import java.util.ArrayList;

//Determines the best movie from a given year

public class BestMovie extends MovieDataUser implements AnswerQuestions, FurtherQuestions{

    public static final String NO_DATA_FOUND = "No data for given year of ";
    public static final String YEAR_QUESTION = "What year would you like to know the best movie for?";
    int year;

    public BestMovie(ArrayList<IMBDMovies> data)
    {
        super(data);
    }
    public String getAnswerToQuestion(int givenYear)
    {
        year=givenYear;
        return findAnswer();
    }

    @Override
    public String getAnswerToQuestion() {
        furtherQuestions();
        return findAnswer();
    }

    @Override
    public String findAnswer() {
        for(int i=0;i<movieData.size();i++)
        {
            if(movieData.get(i).getYear()==year)
            {
                return movieData.get(i).getTitle();
            }
        }
        return NO_DATA_FOUND +Integer.toString(year);
    }

    @Override
    public void furtherQuestions() {
        System.out.println(YEAR_QUESTION);
        year=Integer.parseInt(input.next());
    }
}
