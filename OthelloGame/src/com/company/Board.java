package com.company;


import java.util.ArrayList;
import java.util.List;

public class Board {

    char[][] theBoard;

    public Board() {
        this.theBoard = new char[10][10];

        //We put '*' on the sides because of out pf boundry error
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {

                if (i==0 || i==9){
                    this.theBoard[i][j]= '*';
                }
                else if (j==0 || j==9){
                    this.theBoard[i][j]= '*';
                }
                else{
                    this.theBoard[i][j]= '-';
                }


            }

        }

        //Setting inital pawns
        this.theBoard[4][4]='W';
        this.theBoard[4][5]='B';
        this.theBoard[5][4]='B';
        this.theBoard[5][5]='W';

    }

    //Displaying current board
    public void displayBoard(){
        System.out.println(" 12345678");
        for (int i = 1; i < 9 ; i++) {
            for (int j = 1; j < 9; j++) {
                if(j==1){
                    System.out.print(i);
                }

                System.out.print(theBoard[i][j]);
            }
            System.out.println(" ");
        }
    }

    //Play user it can be computer or human
    public boolean playUser(int x, int y , char turn){
        //If location on board is not - then the pawn cannot be located
        if (this.theBoard[x][y]!='-'){
            this.theBoard[x][y]='-';
            return false;

        }

        //Putting pawn on the board
        this.theBoard[x][y]=turn;
        char otherTurn;
        if (turn == 'B'){
            otherTurn='W';
        }
        else {
            otherTurn = 'B';
        }

        //We control any neighbour is pawn or not. If there is no pawn on the neighbours, return false
        if ((theBoard[x-1][y-1]=='B' || theBoard[x-1][y-1]=='W') &&
                (theBoard[x-1][y]=='B' || theBoard[x-1][y]=='W') &&
                (theBoard[x-1][y+1]=='B' || theBoard[x-1][y+1]=='W') &&
                (theBoard[x][y+1]=='B' || theBoard[x][y+1]=='W' ) &&
                (theBoard[x+1][y+1]=='B' || theBoard[x+1][y+1]=='W') &&
                (theBoard[x+1][y]=='B' || theBoard[x+1][y]=='W') &&
                (theBoard[x+1][y-1]=='B' || theBoard[x+1][y-1]=='W') &&
                ( theBoard[x][y-1]=='B' ||  theBoard[x][y-1]=='W'))

               {

                   this.theBoard[x][y]='-';
                   return false;

        }



        //In this part of the code we look at all dimension and  we control the pawn can eat enemy pawn or not. If it can eat we put
        //temporary T Value
        if (theBoard[x-1][y-1]==otherTurn){

            for (int i = 1; i <9 ; i++) {
                if (this.theBoard[x-i][y-i] == '*' || this.theBoard[x-i][y-i] == '-'){

                    try{
                        for (int j = 1; j < 9; j++) {
                            if (this.theBoard[x-j][y-j]   =='*'){
                                break;
                            }
                            else if (this.theBoard[x-j][y-j] =='T'){
                                theBoard[x-j][y-j] = otherTurn;
                            }
                        }

                        break;
                    }catch (Exception e){
                        break;
                    }


                }
                else if(this.theBoard[x-i][y-i] == turn ){
                    break;
                }
                else if (this.theBoard[x-i][y-i] == otherTurn){
                    this.theBoard[x-i][y-i] = 'T';
                }




            }


        }
        //In this part of the code we look at all dimension and  we control the pawn can eat enemy pawn or not. If it can eat we put
        //temporary T Value
        if (theBoard[x-1][y]==otherTurn){

            for (int i = 1; i <9 ; i++) {
                if (this.theBoard[x-i][y] == '*' || this.theBoard[x-i][y] == '-'){

                    try{
                        for (int j = 1; j < 9; j++) {
                            if (this.theBoard[x-j][y]   =='*'){
                                break;
                            }
                            else if (this.theBoard[x-j][y] =='T'){
                                theBoard[x-j][y]  = otherTurn;
                            }
                        }

                        break;
                    }catch (Exception e){
                        break;
                    }


                }
                else if(this.theBoard[x-i][y] == turn ){
                    break;
                }
                else if (this.theBoard[x-i][y] == otherTurn){
                    this.theBoard[x-i][y] = 'T';
                }



            }

        }
        //In this part of the code we look at all dimension and  we control the pawn can eat enemy pawn or not. If it can eat we put
        //temporary T Value
        if (theBoard[x-1][y+1]==otherTurn){

            for (int i = 1; i <9 ; i++) {
                if ( this.theBoard[x-i][y+i] == '*' || this.theBoard[x-i][y+i] == '-'){
                    try{
                        for (int j = 1; j < 9; j++) {
                            if (this.theBoard[x-j][y+j]   =='*'){
                                break;
                            }
                            else if (this.theBoard[x-j][y+j]  =='T'){
                                theBoard[x-j][y+j]  = otherTurn;
                            }
                        }

                        break;
                    }catch (Exception e){
                        break;
                    }


                }
                else if(this.theBoard[x-i][y+i] == turn ){
                    break;
                }
                else if (this.theBoard[x-i][y+i] == otherTurn){
                    this.theBoard[x-i][y+i] = 'T';
                }


            }

        }
        //In this part of the code we look at all dimension and  we control the pawn can eat enemy pawn or not. If it can eat we put
        //temporary T Value
        if (theBoard[x][y+1]==otherTurn){

            for (int i = 1; i <9 ; i++) {
                if ( this.theBoard[x][y+i] == '*' || this.theBoard[x][y+i] == '-'){
                    try{
                        for (int j = 1; j < 9; j++) {
                            if (this.theBoard[x][y+j]   =='*'){
                                break;
                            }
                            else if (this.theBoard[x][y+j]   =='T'){
                                theBoard[x][y+j]  = otherTurn;
                            }
                        }

                        break;
                    }catch (Exception e){
                        break;
                    }


                }
                else if(this.theBoard[x][y+i] == turn){
                    break;
                }
                else if (this.theBoard[x][y+i] == otherTurn){
                    this.theBoard[x][y+i] = 'T';
                }



            }

        }
        //In this part of the code we look at all dimension and  we control the pawn can eat enemy pawn or not. If it can eat we put
        //temporary T Value
        if (theBoard[x+1][y+1]==otherTurn){

            for (int i = 1; i <9 ; i++) {
                if (this.theBoard[x+i][y+i] == '*' || this.theBoard[x+i][y+i] == '-'){
                    try {
                        for (int j = 1; j < 9; j++) {
                            if (this.theBoard[x+j][y+j]=='*'){
                                break;
                            }
                            else if (this.theBoard[x+j][y+j]  =='T'){
                                theBoard[x+j][y+j]  = otherTurn;
                            }
                        }
                        break;
                    }
                    catch (Exception e){
                        break;
                    }


                }
                else if(this.theBoard[x+i][y+i] == turn ){
                    break;
                }
                else if (this.theBoard[x+i][y+i] == otherTurn){
                    this.theBoard[x+i][y+i] = 'T';
                }


            }


        }
        //In this part of the code we look at all dimension and  we control the pawn can eat enemy pawn or not. If it can eat we put
        //temporary T Value
        if (theBoard[x+1][y]==otherTurn){

            for (int i = 1; i <9 ; i++) {
                if (this.theBoard[x+i][y] == '*' || this.theBoard[x+i][y] == '-'){

                    try{
                        for (int j = 1; j < 9; j++) {
                            if (this.theBoard[x+j][y]  =='*'){
                                break;
                            }
                            else if (this.theBoard[x+j][y]  =='T'){
                                theBoard[x+j][y]  = otherTurn;
                            }
                        }
                        break;
                    }catch (Exception e){
                        break;
                    }

                }
                else if(this.theBoard[x+i][y] == turn ){
                    break;
                }
                else if (this.theBoard[x+i][y] == otherTurn){


                    this.theBoard[x+i][y] = 'T';

                }



            }

        }
        //In this part of the code we look at all dimension and  we control the pawn can eat enemy pawn or not. If it can eat we put
        //temporary T Value
        if (theBoard[x+1][y-1]==otherTurn){

            for (int i = 1; i <9 ; i++) {
                if (this.theBoard[x+i][y-i] == '*' || this.theBoard[x+i][y-i] == '-'){

                    try{
                        for (int j = 1; j < 9; j++) {
                            if (this.theBoard[x+j][y-j]  =='*'){
                                break;
                            }
                            else if (this.theBoard[x+j][y-j]  =='T'){
                                theBoard[x+j][y-j]   = otherTurn;
                            }
                        }
                        break;
                    }catch (Exception e){
                        break;
                    }


                }
                else if(this.theBoard[x+i][y-i] == turn ){
                    break;
                }
                else if (this.theBoard[x+i][y-i] == otherTurn){
                    this.theBoard[x+i][y-i] = 'T';

                }



            }

        }
        //In this part of the code we look at all dimension and  we control the pawn can eat enemy pawn or not. If it can eat we put
        //temporary T Value
        if (theBoard[x][y-1]==otherTurn){

            for (int i = 1; i <9 ; i++) {
                if (this.theBoard[x][y-i] == '*' || this.theBoard[x][y-i] == '-'){

                    try{
                        for (int j = 1; j < 9; j++) {
                            if (this.theBoard[x][y-j] =='*'){
                                break;
                            }
                            else if (this.theBoard[x][y-j]  =='T'){
                                theBoard[x][y-j]   = otherTurn;
                            }
                        }
                        break;
                    }catch (Exception e){
                        break;
                    }

                }
                else if(this.theBoard[x][y-i] == turn ){
                    break;
                }
                else if (this.theBoard[x][y-i] == otherTurn){
                    this.theBoard[x][y-i] = 'T';
                }



            }

        }


        //We control is there ant t value, if there is T value we change the colors with same as player pawn
        boolean isThereTValue=true;
        for (int i = 1; i < 9; i++) {
            for (int j = 1; j < 9; j++) {
                if (this.theBoard[i][j]=='T'){
                    this.theBoard[i][j]=turn;
                    isThereTValue=false;
                }
            }
        }

        //If there is not T value return false
        if (isThereTValue){

            this.theBoard[x][y]='-';
            return false;

        }


        return true;
    }

    public char[][] gettheBoard(){
        return theBoard;
    }

    public void makeEqualBoard(Board board2){
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {

                this.theBoard[i][j] = board2.theBoard[i][j];
            }
        }
    }


}

