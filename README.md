# MovieDatabase

Movie Questions
- interacts with user
- keeps track of each question

IMBD Movies
- contains all the info on each movie

**Questions Package**

Interface: AnswerQuestions
- ability to answer a question

Interface: FurtherQuestions
- ability to ask user further questions

Abstract Class: MovieDataUser
- any class that takes in a list of IMBDMovies

YearlyEarnings extends MovieDataUser implements AnswerQuestions,FurtherQuestions
- asks User for Year
- gives back total earnings

ListOfDirectors extends MovieDataUser implements AnswerQuestions
- List all directors of movies

DirectorAppearances extends MovieDataUser implements AnswerQuestions,FurtherQuestions
- gets how many directors you want to see
- gives back list sorted by number of appearances

InfoBasedOnRank extends MovieDataUser implements AnswerQuestions,FurtherQuestions
- asks grossing/rating, director/cast and for the rank
- gives back movie if one exists that meets criteria

BestMovie extends MovieDataUser implements AnswerQuestions,FurtherQuestions
- asks for a year
- gives a movie that was the best out of that year


