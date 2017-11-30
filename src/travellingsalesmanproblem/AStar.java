/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package travellingsalesmanproblem;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Alcsaw
 */
public class AStar {
    public void findBestPath(int [][] citiesConnections, double [] estimative){
        
        int travels = 0;    //A travels counter
        int bestOption = 0; //Starting from the first city
        double bestEstimative = estimative[citiesConnections[0][0]];
        List<Integer> currentPath = new ArrayList();
        
        while (true){
            travels++;
            
            //tratar caso de não ter pra onde ir em determinado ponto;
                //Nesse caso, voltar até bifurcação anterior e tomar outro rumo
            //
            
            //int currentCity = bestOption;   //The current city in the travel. The city which connections will be analysed below
            currentPath.add(bestOption);
            int currentCity = getLastElement(currentPath);
            for (int i=0; i<citiesConnections[currentCity].length; i++){ //cycles through all possible next cities
                double currentEstimative = estimative[citiesConnections[currentCity][i]];
                if (bestEstimative > currentEstimative){    //and go through the path with smaller estimated distance
                    bestOption = citiesConnections[currentCity][i];     //The bestOption is also the next city to be analysed
                    bestEstimative = currentEstimative;
                }
            }
            if (bestOption == 37){
                //finish
                currentPath.add(bestOption);
                break;
            }
            System.out.println("currentPath: " + currentPath);
        }
        printPath(currentPath);
    }
    
    public int getLastElement(List<Integer> listOfIntegers){
        return listOfIntegers.get(listOfIntegers.size()-1);
    }
    
    public void printPath(List<Integer> path){
        path.forEach((Integer city) -> {
            System.out.print("->" + (city+1));
        });
        System.out.println("");
    }
}
