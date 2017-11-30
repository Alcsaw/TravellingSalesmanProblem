/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package travellingsalesmanproblem;

/**
 *
 * @author Alcsaw
 */
public class TravellingSalesmanProblem {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        /*  Given:
            A list of coordinates (X, Y) of 38 cities and a matrix in which each
            line is the origin city and columns are possible next cities
            (avaliable connections)
            
            Generate:
            An array in which each index is a city and the value is a estimated
            distance (straight) to the destination city (38) calculated by
            Math.sqrt(pow(Xi - Xj, 2) + pow(Yi - Yj, 2))
        
            Compute:
            The best path from city 1 to city 38 using A* algorithm based on the
            mathematic function of evaluation f = g + h', where g is the distance
            already travelled and h' is an estimative for the remaining distance
        */
        
        double [][] citiesCoordinates = {
            {11003.611100, 42102.500000},
            {11108.611100, 42373.888900},
            {11133.333300, 42885.833300},
            {11155.833300, 42712.500000},
            {11183.333300, 42933.333300},
            {11297.500000, 42853.333300},
            {11310.277800, 42929.444400},
            {11416.666700, 42983.333300},
            {11423.888900, 43000.277800},
            {11438.333300, 42057.222200},
            {11461.111100, 43252.777800},
            {11485.555600, 43187.222200},
            {11503.055600, 42855.277800},
            {11511.388900, 42106.388900},
            {11522.222200, 42841.944400},
            {11569.444400, 43136.666700},
            {11583.333300, 43150.000000},
            {11595.000000, 43148.055600},
            {11600.000000, 43150.000000},
            {11690.555600, 42686.666700},
            {11715.833300, 41836.111100},
            {11751.111100, 42814.444400},
            {11770.277800, 42651.944400},
            {11785.277800, 42884.444400},
            {11822.777800, 42673.611100},
            {11846.944400, 42660.555600},
            {11963.055600, 43290.555600},
            {11973.055600, 43026.111100},
            {12058.333300, 42195.555600},
            {12149.444400, 42477.500000},
            {12286.944400, 43355.555600},
            {12300.000000, 42433.333300},
            {12355.833300, 43156.388900},
            {12363.333300, 43189.166700},
            {12372.777800, 42711.388900},
            {12386.666700, 43334.722200},
            {12421.666700, 42895.555600},
            {12645.000000, 42973.333300}
        };
        
        /*int [][] citiesConnections = {
            {2, 4, 10, 15, 17},
            {16, 3, 7, 10, 11},
            {12, 18, 28, 27, 29},
            {11, 19, 22, 13, 14, 6, 16},
            {27, 29, 30},                           //5
            {31, 33, 34, 17, 8},
            {8, 9, 10, 38, 3, 26, 13, 37},
            {4, 7, 15, 17, 25, 29, 28, 34, 35},
            {37, 23, 21, 11},
            {21, 23, 24, 38, 22, 17},               //10
            {5, 4, 2},
            {1, 19, 29, 27, 26, 36, 34},
            {33, 32, 23, 26, 28, 19, 21},
            {7, 6, 3, 2, 9},
            {10, 11, 14},                           //15
            {23},
            {34, 33, 37, 38},
            {21, 20, 19},
            {17, 16, 2, 8},
            {14, 3, 2, 6},                          //20
            {5, 11, 16, 22},
            {28},
            {26},
            {32, 31},
            {27},                                   //25
            {29, 30, 20},
            {10, 22, 23, 7},
            {9, 12, 15},
            {19, 20, 22},
            {11, 23, 29, 12},                       //30
            {23, 33},
            {27, 17, 14, 16},
            {16, 2, 7, 8, 9},
            {10, 9, 15, 28, 38},
            {27, 23, 32, 12, 11, 8},                //35
            {6, 23, 34, 33, 2, 37},
            {25, 23, 12, 9},
            {23, 15, 18, 22,}
        };*/
        int [][] citiesConnections = {
            {1, 3, 9, 14, 16},
            {15, 2, 6, 9, 10},
            {11, 17, 27, 26, 28},
            {10, 18, 21, 12, 13, 5, 15},
            {26, 28, 29},                           //4
            {30, 32, 33, 16, 7},
            {7, 8, 9, 37, 2, 25, 12, 36},
            {3, 6, 14, 16, 24, 28, 27, 33, 34},
            {36, 22, 20, 10},
            {20, 22, 23, 37, 21, 16},               //9
            {4, 3, 1},
            {0, 18, 28, 26, 25, 35, 33},
            {32, 31, 22, 25, 27, 18, 20},
            {6, 5, 2, 1, 8},
            {9, 10, 13},                            //14
            {22},
            {33, 32, 36, 37},
            {20, 19, 18},////
            {16, 15, 1, 7},
            {13, 2, 1, 5},                          //19
            {4, 10, 15, 21},
            {27},
            {25},
            {31, 30},
            {26},                                   //24
            {28, 29, 19},
            {9, 21, 22, 6},
            {8, 11, 14},
            {18, 19, 21},
            {10, 22, 28, 11},                       //29
            {22, 32},
            {26, 16, 13, 15},
            {15, 1, 6, 7, 8},
            {9, 8, 14, 27, 37},
            {26, 22, 31, 11, 10, 7},                //34
            {5, 22, 33, 32, 1, 36},
            {24, 22, 11, 8},
            {22, 14, 17, 21,}
        };
        
        double [] estimative = new double[citiesCoordinates.length];
        
        for (int i=0; i<citiesCoordinates.length-1; i++){
            estimative[i] = Math.sqrt(Math.pow(citiesCoordinates[i][0] - citiesCoordinates[37][0], 2)
                    + Math.pow(citiesCoordinates[i][1] - citiesCoordinates[37][1], 2));
        }
        estimative[37] = 0;
        
        
        
        AStar aStar = new AStar();
        aStar.findBestPath(citiesConnections, estimative);
        
        
    }
    
}
