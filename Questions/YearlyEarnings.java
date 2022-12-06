package Questions;

import Questions.AnswerQuestions;
import Questions.FurtherQuestions;

import java.util.ArrayList;
import Movie.IMBDMovies;

public class YearlyEarnings extends MovieDataUser implements FurtherQuestions, AnswerQuestions {

    int year;

    public YearlyEarnings(ArrayList<IMBDMovies> data)
    {
        super(data);
    }
    @Override
    public String answerToQuestion() {
        furtherQuestions();
        int earnings=0;
        for(int i=0;i<movieData.size();i++){
            IMBDMovies currentMovieEntry=movieData.get(i);
            if (currentMovieEntry.getYear()==year)
            {
                earnings+= currentMovieEntry.getEarnings();
            }
        }
        return Integer.toString(earnings);
    }

    @Override
    public void furtherQuestions() {
        System.out.println("Enter a year");
        year=Integer.parseInt(input.nextLine());
    }

}
