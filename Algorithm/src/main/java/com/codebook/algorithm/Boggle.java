package com.codebook.algorithm;

import java.util.Arrays;
import java.util.List;

public class Boggle {

    // ================================================================================
    // Properties
    // ================================================================================

    private int width;
    private int height;

    private List<String> dictionary;

    // ================================================================================
    // Constructors
    // ================================================================================

    public Boggle(int width, int height, List<String> dictionary) {
        this.width = width;
        this.height = height;
        this.dictionary = dictionary;
    }

    // ================================================================================
    // Public Methods
    // ================================================================================

    public static void main(String[] args) {
        char[][] boggle =   {{'G','I','Z'},
                            {'U','E','K'},
                            {'Q','S','E'}};

        System.out.println("Following words of dictionary are present\n");
        new Boggle(boggle.length, boggle[0].length, Arrays.asList("GEEKS", "FOR", "QUIZ", "GO")).findWords(boggle);
    }

    public void findWords(char board[][]) {
        boolean[][] visited =   {{false, false, false},
                                {false, false, false},
                                {false, false, false}};

        for (int i = 0; i < width; i++)
            for (int j = 0; j < height; j++)
                findWords(board, visited, i, j, "");
    }

    // ================================================================================
    // Private Methods
    // ================================================================================

    private void findWords(char[][] board, boolean[][] visited, int row, int col, String currentStr) {
        // Mark current cell as visited and append current character to current
        visited[row][col] = true;
        currentStr += board[row][col];

        // If currentStr is present in the dictionary, then print it
        if (isWord(currentStr)) {
            System.out.println(currentStr);
        }

        // Traverse adjacent cells
        for (int i = row - 1; i <= row + 1; i++) {
            for (int j = col - 1; j <= col + 1; j++) {
                if (i >= 0 && j >= 0 && i < width && j < height && !visited[i][j]) {
                    findWords(board, visited, i, j, currentStr);
                }
            }
        }

        currentStr = currentStr.substring(0, currentStr.length() - 1);
        visited[row][col] = false;
    }

    private boolean isWord(String word) {
        return dictionary.contains(word);
    }

}
