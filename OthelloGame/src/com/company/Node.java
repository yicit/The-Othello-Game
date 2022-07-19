package com.company;

import java.util.ArrayList;
import java.util.List;

public class Node {

    //It is node of the tree, and its attributes. It holds the assumtion of tables and heuristic values etc
    private List<Node> nodeList;
    private int alpha;
    private int betha;
    private int heuValueNumberOfWhite;
    public Board recentBoard;
    private int heuValueNumberOfBlack;
    private int secondheuWhite_Black;
    private int depth;
    private Node motherNode;
    private int id;
    private boolean isVisited;

    public Node() {
        this.alpha= -500;
        this.betha = 500;
        this.recentBoard = new Board();
        this.nodeList = new ArrayList<Node>();
        this.heuValueNumberOfWhite=0;
        this.heuValueNumberOfBlack=0;
        this.secondheuWhite_Black=0;
        this.depth=0;
        this.motherNode = null;
        this.id=0;
        this.isVisited = false; //Not visit
       // recentBoard.makeEqualBoard(this.recentBoard,recentBoard);

    }

    public void copyBoard(Board recentBoard){
        this.recentBoard.makeEqualBoard(recentBoard);
    }
    public void newChildNode(){
        nodeList.add(new Node());
        nodeList.get(nodeList.size()-1).copyBoard(this.recentBoard);
    }

    public List<Node> getNodeList(){
        return nodeList;
    }
    public Board getRecentBoard() {
        return recentBoard;
    }

    public void setNodeList(List<Node> nodeList) {
        this.nodeList = nodeList;
    }

    public void addNode(Node n){
        this.nodeList.add(n);
    }
    public void countWhite(){
        int whiteCounter =0;
        for (int k = 1; k < 9; k++) {
            for (int l = 1; l < 9; l++) {
                if (this.recentBoard.theBoard[k][l]=='W'){
                    whiteCounter++;
                }
            }
        }
        this.setHeuValueNumberOfWhite(whiteCounter);
    }

    public void secondHeu(){
        int sum=0;
        for (int i = 1; i < 9 ; i++) {
            for (int j = 1; j < 9; j++) {
                if (this.recentBoard.theBoard[i][j]=='B'){

                    if(i==1 || i==8 || j==1 || j==8 ){
                        sum = sum+ 3;
                    }
                    else if(i==2 || i==7 || j==2 || j==7 ){
                        sum =sum + 2;
                    }
                    else if(i==3 || i==6 || j==3 || j==6 ){
                        sum =sum + 1;
                    }
                    else {
                        sum =sum + 0;
                    }
                }
            }
        }




        setSecondheuWhite_Black(sum);
    }

    public void countBlack(){
        int blackCounter =0;
        for (int k = 1; k < 9; k++) {
            for (int l = 1; l < 9; l++) {
                if (this.recentBoard.theBoard[k][l]=='B'){
                    blackCounter++;
                }
            }
        }
        this.setHeuValueNumberOfBlack(blackCounter);

    }

    public int getHeuValueNumberOfBlack() {
        return heuValueNumberOfBlack;
    }

    public void setHeuValueNumberOfBlack(int heuValueNumberOfBlack) {
        this.heuValueNumberOfBlack = heuValueNumberOfBlack;
    }

    public int getAlpha() {
        return alpha;
    }

    public void setAlpha(int alpha) {
        this.alpha = alpha;
    }

    public int getBetha() {
        return betha;
    }

    public void setBetha(int betha) {
        this.betha = betha;
    }

    public int getHeuValueNumberOfWhite() {
        return heuValueNumberOfWhite;
    }

    public void setHeuValueNumberOfWhite(int heuValueNumberOfWhite) {
        this.heuValueNumberOfWhite = heuValueNumberOfWhite;
    }

    public void setRecentBoard(Board recentBoard) {
        this.recentBoard = recentBoard;
    }

    public int getDepth() {
        return depth;
    }

    public Node getMotherNode() {
        return motherNode;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setMotherNode(Node motherNode) {
        this.motherNode = motherNode;
    }

    public void setDepth(int depth) {
        this.depth = depth;
    }

    public int getSecondheuWhite_Black() {
        return secondheuWhite_Black;
    }

    public void setSecondheuWhite_Black(int secondheuWhite_Black) {
        this.secondheuWhite_Black = secondheuWhite_Black;
    }

    public boolean isVisited() {
        return isVisited;
    }

    public void setVisited(boolean visited) {
        isVisited = visited;
    }
}
