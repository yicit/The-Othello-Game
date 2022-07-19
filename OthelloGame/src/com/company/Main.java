package com.company;

import java.util.Scanner;

public class Main {

    //MAX min will use for alphabetapluring
    static int MAX = 1000;
    static int MIN = -1000;
    //For generating maxMin Tree
    public static Node rootForTree;
    //It is for node id
    public static int id=0;
    public static void main(String[] args) {
        int xValue,yValue;
	// write your code here
        Board theBoard = new Board();
        theBoard.displayBoard();

        Scanner input1 = new Scanner(System.in);
        System.out.println("1. User-Computer Play");
        System.out.println("2. Computer-Computer Play");
        System.out.println("3. 100 Run Computer-Computer Play");
        System.out.println("Please Select to option");
        int option = input1.nextInt();

        if (option==1){
            while (true) {

                if (isThereAnyPossibilaty('B',theBoard)){
                    Scanner input = new Scanner(System.in);
                    System.out.println("Please enter the x value");
                    xValue = input.nextInt();
                    System.out.println("Please enter the y value");
                    yValue = input.nextInt();
                    if (theBoard.playUser(xValue, yValue, 'B') == false) {

                        System.out.println("Wrong input");
                    }

                    theBoard.displayBoard();
                }
                else {
                    System.out.println("End of the Game! No possible Moves");
                    break;
                }

                if (isThereAnyPossibilaty('W',theBoard)){
                    rootForTree = new Node();
                    rootForTree.copyBoard(theBoard);
                    rootForTree.setDepth(0);

                    //First Round
                    makeMinMaxTree(rootForTree, 'W', 1);

                    //Second Round

                    for (int i = 0; i < rootForTree.getNodeList().size(); i++) {
                        makeMinMaxTree(rootForTree.getNodeList().get(i), 'B', 2);

                    }

                    //Third Round

                    for (int i = 0; i < rootForTree.getNodeList().size(); i++) {

                        for (int j = 0; j < rootForTree.getNodeList().get(i).getNodeList().size(); j++) {
                            makeMinMaxTree(rootForTree.getNodeList().get(i).getNodeList().get(j), 'W', 3);

                        }

                    }

                    int biggest = alphaBetaPluring(true, rootForTree, MIN, MAX);
                    calculateVisitedNodes(rootForTree);

                    for (int i = 0; i < rootForTree.getNodeList().size(); i++) {

                        if (rootForTree.getNodeList().get(i).getHeuValueNumberOfWhite() == biggest) {
                            theBoard.makeEqualBoard(rootForTree.getNodeList().get(i).recentBoard);
                        }
                    }

                    theBoard.displayBoard();
                }
                else {
                    System.out.println("End of the Game! No possible Moves");
                    break;
                }



            }

            winnerPrinter(theBoard);
        }

        else if (option ==2){

                while (true){
                    if (isThereAnyPossibilaty('B',theBoard)){
                        rootForTree = new Node();
                        rootForTree.copyBoard(theBoard);
                        rootForTree.setDepth(0);

                        //First Round
                        makeMinMaxTree(rootForTree, 'B', 1);

                        //Second Round

                        for (int i = 0; i < rootForTree.getNodeList().size(); i++) {
                            makeMinMaxTree(rootForTree.getNodeList().get(i), 'W', 2);

                        }

                        //Third Round

                        for (int i = 0; i < rootForTree.getNodeList().size(); i++) {

                            for (int j = 0; j < rootForTree.getNodeList().get(i).getNodeList().size(); j++) {
                                makeMinMaxTree(rootForTree.getNodeList().get(i).getNodeList().get(j), 'B', 3);

                            }

                        }

                        int biggest = alphaBetaPluringForSecondComputer(true, rootForTree, MIN, MAX);
                        calculateVisitedNodes(rootForTree);

                        for (int i = 0; i < rootForTree.getNodeList().size(); i++) {

                            if (rootForTree.getNodeList().get(i).getSecondheuWhite_Black() == biggest) {
                                theBoard.makeEqualBoard(rootForTree.getNodeList().get(i).recentBoard);
                            }
                        }

                        theBoard.displayBoard();


                    }
                    else {
                        System.out.println("End of the Game! No possible Moves");
                        break;
                    }

                    if (isThereAnyPossibilaty('W',theBoard)){
                        rootForTree = new Node();
                        rootForTree.copyBoard(theBoard);
                        rootForTree.setDepth(0);

                        //First Round
                        makeMinMaxTree(rootForTree, 'W', 1);


                        //Second Round

                        for (int i = 0; i < rootForTree.getNodeList().size(); i++) {
                            makeMinMaxTree(rootForTree.getNodeList().get(i), 'B', 2);

                        }

                        //Third Round

                        for (int i = 0; i < rootForTree.getNodeList().size(); i++) {

                            for (int j = 0; j < rootForTree.getNodeList().get(i).getNodeList().size(); j++) {
                                makeMinMaxTree(rootForTree.getNodeList().get(i).getNodeList().get(j), 'W', 3);

                            }

                        }

                        int biggest = alphaBetaPluring(true, rootForTree, MIN, MAX);
                        calculateVisitedNodes(rootForTree);

                        for (int i = 0; i < rootForTree.getNodeList().size(); i++) {

                            if (rootForTree.getNodeList().get(i).getHeuValueNumberOfWhite() == biggest) {
                                theBoard.makeEqualBoard(rootForTree.getNodeList().get(i).recentBoard);
                            }
                        }
                        theBoard.displayBoard();

                    }
                    else {
                        break;
                    }

                }
                winnerPrinter(theBoard);


        }
        else if(option==3){
            for (int o = 0;o < 100; o++) {
                while (true){
                    if (isThereAnyPossibilaty('B',theBoard)){
                        rootForTree = new Node();
                        rootForTree.copyBoard(theBoard);
                        rootForTree.setDepth(0);

                        //First Round
                        makeMinMaxTree(rootForTree, 'B', 1);

                        //Second Round

                        for (int i = 0; i < rootForTree.getNodeList().size(); i++) {
                            makeMinMaxTree(rootForTree.getNodeList().get(i), 'W', 2);

                        }

                        //Third Round

                        for (int i = 0; i < rootForTree.getNodeList().size(); i++) {

                            for (int j = 0; j < rootForTree.getNodeList().get(i).getNodeList().size(); j++) {
                                makeMinMaxTree(rootForTree.getNodeList().get(i).getNodeList().get(j), 'B', 3);

                            }

                        }

                        int biggest = alphaBetaPluringForSecondComputer(true, rootForTree, MIN, MAX);

                        for (int i = 0; i < rootForTree.getNodeList().size(); i++) {

                            if (rootForTree.getNodeList().get(i).getSecondheuWhite_Black() == biggest) {
                                theBoard.makeEqualBoard(rootForTree.getNodeList().get(i).recentBoard);
                            }
                        }




                    }
                    else {
                        System.out.println("End of the Game! No possible Moves");
                        break;
                    }

                    if (isThereAnyPossibilaty('W',theBoard)){
                        rootForTree = new Node();
                        rootForTree.copyBoard(theBoard);
                        rootForTree.setDepth(0);

                        //First Round
                        makeMinMaxTree(rootForTree, 'W', 1);

                        //Second Round

                        for (int i = 0; i < rootForTree.getNodeList().size(); i++) {
                            makeMinMaxTree(rootForTree.getNodeList().get(i), 'B', 2);

                        }

                        //Third Round

                        for (int i = 0; i < rootForTree.getNodeList().size(); i++) {

                            for (int j = 0; j < rootForTree.getNodeList().get(i).getNodeList().size(); j++) {
                                makeMinMaxTree(rootForTree.getNodeList().get(i).getNodeList().get(j), 'W', 3);

                            }

                        }

                        int biggest = alphaBetaPluring(true, rootForTree, MIN, MAX);

                        for (int i = 0; i < rootForTree.getNodeList().size(); i++) {

                            if (rootForTree.getNodeList().get(i).getHeuValueNumberOfWhite() == biggest) {
                                theBoard.makeEqualBoard(rootForTree.getNodeList().get(i).recentBoard);
                            }
                        }


                    }
                    else {
                        break;
                    }

                }
                winnerPrinter(theBoard);
            }

        }
        else {
            System.out.println("Wrong Input");
        }







    }

    //Make min max tree
    public static void makeMinMaxTree(Node rootForTree, char turn, int depth){

       //Look at all cells on tha board
        for (int i = 1; i < 9; i++) {
            for (int j = 1; j < 9; j++) {
                //Create temp node and temp board for tree. Temp board will equal to recent board
               Node tempNode = new Node();
               tempNode.copyBoard(rootForTree.getRecentBoard());
                Board tempBoard = new Board();
                tempBoard.makeEqualBoard(rootForTree.getRecentBoard());

                //This if statement control pawns can be located on that cell or not
                if (tempBoard.playUser(i,j,turn)){
                  //If (i,j) location can be located the algorithm add the node on tree with nessesary attributes
                    tempNode.copyBoard(tempBoard);
                    if (depth==3){
                        id++;
                        tempNode.setId(id);
                        tempNode.countWhite();
                        tempNode.secondHeu();
                    }

                    tempNode.setDepth(depth);
                    tempNode.setMotherNode(rootForTree);
                    rootForTree.addNode(tempNode);

                }


            }
        }
    }

    //This method for the first computer which play White pawns
    static int alphaBetaPluring(Boolean maxOrMin, Node recentNode, int alpha, int beta) {

        //Return until size = 0
        if (recentNode.getNodeList().size()==0){
            recentNode.setVisited(true);
            return recentNode.getHeuValueNumberOfWhite();
        }

        //check according the level of the tree (max or min)
        if (maxOrMin)
        {
            int biggest = MIN;

            for (int i = 0; i < recentNode.getNodeList().size(); i++) {
                //Do calculation recursively
                int val = alphaBetaPluring(false, recentNode.getNodeList().get(i), alpha, beta);
                biggest = Math.max(biggest, val);
                alpha = Math.max(alpha, biggest);

                //If betha is smaller than or equal the alpha pruning the tree
                if (beta <= alpha){
                    break;
                }

            }
            try {
                //Set the calculated value to mother node (one above node)
                recentNode.getMotherNode().setHeuValueNumberOfWhite(biggest);
            }
            catch (Exception e){}

            //return the calculated value
            return biggest;
        }
        else {
            int biggest = MAX;

            for (int i = 0; i < recentNode.getNodeList().size(); i++)
            {
                //Do calculation recursively
                int val = alphaBetaPluring(true, recentNode.getNodeList().get(i), alpha, beta);
                biggest = Math.min(biggest, val);
                beta = Math.min(beta, biggest);

                //If betha is smaller than or equal the alpha pruning the tree
                if (beta <= alpha){
                    break;
                }
            }
            try {
                //Set the calculated value to mother node (one above node)
                recentNode.getMotherNode().setHeuValueNumberOfWhite(biggest);
            }
            catch (Exception e){}
            //return the calculated value
            return biggest;
        }
    }

    //This method for the first computer which play Black pawns
    static int alphaBetaPluringForSecondComputer(Boolean maxOrMin, Node recentNode, int alpha, int beta) {
        //Return until size = 0
        if (recentNode.getNodeList().size()==0){
            return recentNode.getSecondheuWhite_Black();
        }
        //check according the level of the tree (max or min)
        if (maxOrMin)
        {
            int biggest = MIN;

            for (int i = 0; i < recentNode.getNodeList().size(); i++) {
                //Do calculation recursively
                int val = alphaBetaPluringForSecondComputer(false, recentNode.getNodeList().get(i), alpha, beta);
                biggest = Math.max(biggest, val);
                alpha = Math.max(alpha, biggest);
                //If betha is smaller than or equal the alpha pruning the tree
                if (beta <= alpha){
                    break;
                }

            }
            try {
                //Set the calculated value to mother node (one above node)
                recentNode.getMotherNode().setSecondheuWhite_Black(biggest);
            }
            catch (Exception e){}
            //return the calculated value
            return biggest;
        }
        else {
            int biggest = MAX;

            for (int i = 0; i < recentNode.getNodeList().size(); i++)
            {
                //Do calculation recursively
                int val = alphaBetaPluringForSecondComputer(true, recentNode.getNodeList().get(i), alpha, beta);
                biggest = Math.min(biggest, val);
                beta = Math.min(beta, biggest);
                //If betha is smaller than or equal the alpha pruning the tree
                if (beta <= alpha){
                    break;
                }
            }
            try {
                //Set the calculated value to mother node (one above node)
                recentNode.getMotherNode().setSecondheuWhite_Black(biggest);
            }
            catch (Exception e){}
            //return the calculated value
            return biggest;
        }
    }

    //This method control the there is posiblty for putting pawn to any location for spesific color of pawn
    static boolean isThereAnyPossibilaty(char turn, Board theBoard) {
        //We control all of the cell and looking can be put pawn on that location
        for (int i = 1; i < 9; i++) {
            for (int j = 1; j < 9; j++) {


                Board tempBoard = new Board();
                tempBoard.makeEqualBoard(theBoard);

                if (tempBoard.playUser(i, j, turn)) {


                    return true;
                }


            }
        }

        return false;
    }

    //Print the winner (Black or White)
    static void winnerPrinter(Board theBoard){
        int whiteNumber=0;
        int blackNumber=0;
        for (int i = 1; i < 9; i++) {
            for (int j = 1; j < 9; j++) {
                if (theBoard.theBoard[i][j]=='B'){
                    blackNumber++;
                }
                else if ((theBoard.theBoard[i][j]=='W')){
                    whiteNumber ++;
                }
            }
        }

        System.out.println("White number: " + whiteNumber);
        System.out.println("Black number: " + blackNumber);

        if (whiteNumber>blackNumber){
            System.out.println("White one win");
        }
        else if (whiteNumber<blackNumber){
            System.out.println("Black one win");
        }
        else {
            System.out.println("Both of black and white win");
        }
    }


    static void calculateVisitedNodes( Node rootForTree){
    //It travel all nodes of the tree and print number of visited node after alpha beta pluring

        int counter=0;
        int nodeSize=0;
        for (int i = 0; i < rootForTree.getNodeList().size(); i++) {
            nodeSize++;
            if (rootForTree.getNodeList().get(i).isVisited()){
                counter++;
            }
        }


        for (int i = 0; i < rootForTree.getNodeList().size(); i++) {

            for (int j = 0; j < rootForTree.getNodeList().get(i).getNodeList().size(); j++) {

                nodeSize++;
                if (rootForTree.getNodeList().get(i).getNodeList().get(j).isVisited()){
                    counter++;
                }
            }

        }


        for (int i = 0; i < rootForTree.getNodeList().size(); i++) {

            for (int j = 0; j < rootForTree.getNodeList().get(i).getNodeList().size(); j++) {


                for (int k = 0; k <rootForTree.getNodeList().get(i).getNodeList().get(j).getNodeList().size() ; k++) {
                    nodeSize++;
                    if (rootForTree.getNodeList().get(i).getNodeList().get(j).getNodeList().get(k).isVisited()){
                        counter++;
                    }
                }

            }

        }

        System.out.println("Total node number: " + nodeSize);
        System.out.println("Visited Node Number: " + counter);
    }

}

