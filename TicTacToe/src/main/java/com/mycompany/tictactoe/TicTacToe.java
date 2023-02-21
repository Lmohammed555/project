/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.tictactoe;

/**
 *
 * @author loket
 */
import java.util.*;

public class TicTacToe {

    static ArrayList<Integer> playerPositions = new ArrayList<>();
    static ArrayList<Integer> cpuPositions = new ArrayList<>();

    public static void main(String[] args) {
        char[][] gameBoard = {
                {' ', '|', ' ', '|', ' '},
                {'-', '+', '-', '+', '-'},
                {' ', '|', ' ', '|', ' '},
                {'-', '+', '-', '+', '-'},
                {' ', '|', ' ', '|', ' '}
        };
    Methods.printGameBoard(gameBoard);

    while(true) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter your placement (1-9):");
        int playerPos = scan.nextInt();
        while(playerPositions.contains(playerPos) || cpuPositions.contains(playerPos)) {
            System.out.println("position taken! Enter a correct Position");
            playerPos = scan.nextInt();
        }

        Methods.placePiece(gameBoard, playerPos, "player");
        String result = Methods.checkWinner();
        if (result.length() > 0) {
            System.out.println(result);
            break;
        }
        Random rand = new Random();
        int cpuPos = rand.nextInt(9) + 1;
        while(playerPositions.contains(cpuPos) || cpuPositions.contains(cpuPos)) {
            cpuPos = rand.nextInt(9) + 1;
        }
        Methods.placePiece(gameBoard, cpuPos, "cpu");
        Methods.printGameBoard(gameBoard);
        result = Methods.checkWinner();
        if (result.length() > 0) {
            System.out.println(result);
            break;
        }

    }

    }

   
} 
