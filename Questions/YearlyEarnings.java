package Questions;

import Questions.AnswerQuestions;
import Questions.FurtherQuestions;

import java.util.ArrayList;
import Movie.IMBDMovies;

//  Give the total US box office earnings in the database in a single year.
//		Example:  “What is the total earnings listed in 2007?

public class YearlyEarnings extends MovieDataUser implements FurtherQuestions, AnswerQuestions {

    int year;

    public YearlyEarnings(ArrayList<IMBDMovies> data)
    {
        super(data);
    }

    public String getAnswerToQuestion(int givenYear){
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
