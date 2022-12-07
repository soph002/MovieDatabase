package Questions;

import Movie.IMBDMovies;

import java.util.ArrayList;


// Tell the director or cast members who starred in a movie, given the movie’s rating rank or money rank.
// Examples:
//  “Who starred in the third highest-grossing movie?”
//  “Who directed the 100th highest-ranked movie?”
public class InfoBasedOnRank extends MovieDataUser implements FurtherQuestions,AnswerQuestions{

    public static final String RATING = "rating";
    public static final String GROSSING = "grossing";
    public static final String DIRECTOR = "director";
    public static final String CAST = "cast";
    public static final String INCORRECT_ENTRY_ENTER_DIRECTOR_OR_CAST = "Incorrect Entry: (Enter: director or cast)";
    public static final String INCORRECT_ENTRY_ENTER_GROSSING_OR_RANKING = "Incorrect Entry: (Enter: grossing or rating)";
    public static final String GROSSING_RANKING_QUESTION = "Would you like to look at movies based on grossing or rating? (Enter: grossing or rating)";
    public static final String DIRECTOR_CAST_QUESTION = "Would you like to look see the director or the cast? (Enter: director or cast)";
    public static final String RANK_QUESTION = "What rank would you like to look at? (enter a number ex: 5)";
    public static final String NO_INFO_FOUND = "No information found for the following given options";
    public static final String COMMA = ", ";
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
            if(movieData.get(i).getRatingRank()==rank && moneyOrRating.equals(RATING))
            {
                foundAnswer=true;
            }
            if(movieData.get(i).getGrossingRank()==rank && moneyOrRating.equals(GROSSING))
            {
                foundAnswer=true;
            }
            if(foundAnswer) //so no duplicated code
            {
                if(directorOrCast.equals(DIRECTOR))
                {
                    return movieData.get(i).getDirector();
                }
                else{
                    return movieData.get(i).getCast();
                }
            }
        }
        return NO_INFO_FOUND +moneyOrRating+COMMA+directorOrCast+ COMMA +rank;
    }


    @Override
    public void furtherQuestions() {
        System.out.println(GROSSING_RANKING_QUESTION);
        moneyOrRating=input.nextLine();
        while(!(moneyOrRating.equals(GROSSING) || moneyOrRating.equals(RATING)))
        {
            System.out.println(INCORRECT_ENTRY_ENTER_GROSSING_OR_RANKING);
            moneyOrRating=input.nextLine();
        }
        System.out.println(DIRECTOR_CAST_QUESTION);
        directorOrCast=input.nextLine();
        while(!(directorOrCast.equals(DIRECTOR) || directorOrCast.equals(CAST)))
        {
            System.out.println(INCORRECT_ENTRY_ENTER_DIRECTOR_OR_CAST);
            directorOrCast=input.nextLine();
        }
        System.out.println(RANK_QUESTION);
        rank=Integer.parseInt(input.nextLine());
    }



}
