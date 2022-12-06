package Questions;

import Movie.IMBDMovies;

import java.util.ArrayList;


// Tell the director or cast members who starred in a movie, given the movie’s rating rank or money rank.
// Examples:
//  “Who starred in the third highest-grossing movie?”
//  “Who directed the 100th highest-ranked movie?”
public class InfoBasedOnRank extends MovieDataUser implements FurtherQuestions,AnswerQuestions{

    int rank;
    String moneyOrRating;
    String directorOrCast;

    public InfoBasedOnRank(ArrayList<IMBDMovies> data)
    {
        super(data);
    }

    public String getAnswerToQuestion(int giveRank, String givenTypeOfRank, String givenMember) {
        rank=giveRank;
        moneyOrRating=givenTypeOfRank;
        directorOrCast=givenMember;
        return findAnswer();
    }
    @Override
    public String getAnswerToQuestion() {
        furtherQuestions();
        return findAnswer();
    }

    @Override
    public String findAnswer() {
        boolean foundAnswer=false;
        for(int i=0;i<movieData.size();i++)
        {
            if(movieData.get(i).getRatingRank()==rank && moneyOrRating.equals("rating"))
            {
                foundAnswer=true;
            }
            if(movieData.get(i).getGrossingRank()==rank && moneyOrRating.equals("grossing"))
            {
                foundAnswer=true;
            }
            if(foundAnswer) //so no duplicated code
            {
                if(directorOrCast.equals("director"))
                {
                    return movieData.get(i).getDirector();
                }
                else{
                    return movieData.get(i).getCast();
                }
            }
        }
        return "No "+directorOrCast+" found for movie based on "+moneyOrRating+" at rank "+rank;
    }


    @Override
    public void furtherQuestions() {
        System.out.println("Would you like to look at movies based on grossing or ranking? (Enter: grossing or ranking");
        moneyOrRating=input.nextLine();
        while(!(moneyOrRating.equals("grossing") || moneyOrRating.equals("ranking")))
        {
            System.out.println("Incorrect Entry: (Enter: grossing or ranking");
            moneyOrRating=input.nextLine();
        }
        System.out.println("Would you like to look see the director or the cast? (Enter: director or cast");
        directorOrCast=input.nextLine();
        while(!(directorOrCast.equals("director") || directorOrCast.equals("cast")))
        {
            System.out.println("Incorrect Entry: (Enter: director or cast");
            directorOrCast=input.nextLine();
        }
        System.out.println("What rank would you like to see the "+directorOrCast+" for? (enter a number ex: 5)");
        rank=Integer.parseInt(input.nextLine());
    }



}
