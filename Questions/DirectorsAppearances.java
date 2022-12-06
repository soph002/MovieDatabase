package Questions;

import Movie.IMBDMovies;

import java.util.*;

public class DirectorsAppearances extends MovieDataUser implements FurtherQuestions,AnswerQuestions{

    int numDirectors;

    public DirectorsAppearances(ArrayList<IMBDMovies> movieList)
    {
        super(movieList);
    }

    public String getAnswerToQuestion(int givenNum)
    {
        numDirectors=givenNum;
        return findAnswer();
    }
    @Override
    public String getAnswerToQuestion() {
        furtherQuestions();
        return findAnswer();
    }

    @Override
    public String findAnswer() {
        HashMap<String,Integer> directorAppearances=new HashMap<>(); //Director name linked to the number of appearances
        for(int i=0;i<movieData.size();i++) {
            String currentDirector=movieData.get(i).getDirector();
            if(directorAppearances.containsKey(currentDirector)) {
                directorAppearances.replace(currentDirector,directorAppearances.get(currentDirector)+1);
            }
            else{
                directorAppearances.put(currentDirector, 1);
            }
        }
        //create list of all the number of appearances
        Collection<Integer> listOfNumAppearances= directorAppearances.values();
        ArrayList<Integer> listOfValues=new ArrayList<>(listOfNumAppearances);
        Collections.sort(listOfValues);
        String listOfDirectors=" ";
        for(int i=listOfValues.size()-1;i>=0;i--) {
            if(numDirectors>=1) { // idea from https://www.digitalocean.com/community/tutorials/sort-hashmap-by-value-java
                for(Map.Entry<String,Integer> entry : directorAppearances.entrySet()) {
                    if(entry.getValue().equals(listOfValues.get(i)) && !entry.getKey().equals("no director listed")) {
                        listOfDirectors+=entry.getKey()+" with "+entry.getValue()+" appearances \n";
                        numDirectors--;
                        directorAppearances.remove(entry.getKey()); //remove so no repeated names
                        break; //break after adding so it will do correct number of directors
                    }
                }
            }
        }
        return listOfDirectors;
    }

    @Override
    public void furtherQuestions() {
        System.out.println("What number of directors that appear the most?");
        numDirectors=Integer.parseInt(input.nextLine());
    }
}
