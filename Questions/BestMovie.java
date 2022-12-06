package Questions;

import Movie.IMBDMovies;

import java.util.ArrayList;

public class BestMovie extends MovieDataUser implements AnswerQuestions, FurtherQuestions{

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
        return "No data for given year of "+Integer.toString(year);
    }

    @Override
    public void furtherQuestions() {
        System.out.println("What year would you like to know the best movie for?");
        year=Integer.parseInt(input.next());
    }
}
