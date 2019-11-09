package Maze;
import Main.FileManager;

import java.io.IOException;
import java.util.Formatter;
import java.util.Random;

public class Maze {

    private char[][] maze;
    private int height;
    private int width;

    public Maze(String path, FileManager fm) {
        try {
        maze = fm.readData(path);
        } catch(IOException e) { }

        if(maze == null) {
            System.out.println("Did not read correct maze.");
            System.exit(2);
        }

        height = maze.length;
        width = maze[0].length;
    }

    public Maze(int a, int b) {
        height = 2*a + 1;
        width = 2*b + 1;

        maze = new char[height][width];
        initialize();
        generateInAndOut();
    }

    private void initialize() {
        for(int i = 0; i < height; i++) {
            for(int j = 0; j < width; j++) {
                if(i == 0 || j == 0 || i == height-1 || j == width-1)
                    maze[i][j] = '+';
                else
                    maze[i][j] = '0';
            }
        }
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public char getChar(int i, int j) {
        return maze[i][j];
    }

    public void generate(int xFrom, int xTo, int yFrom, int yTo, boolean isVertical) { // vertical = pionowy
        if(((yTo-yFrom) <= 0) || ((xTo-xFrom) <= 0))
            return;

        Random rand = new Random();
        int wallPos;
        int holePos;
        if(isVertical) {
            wallPos = (rand.nextInt((xTo - xFrom) / 2)) * 2 + xFrom + 1;
            holePos = (rand.nextInt((yTo - yFrom) / 2)) * 2 + yFrom;
            drawWall(wallPos, holePos, yFrom, yTo, true);
            generate(xFrom, wallPos-1, yFrom, yTo, (xTo-wallPos+1) > (yTo-yFrom));
            generate(wallPos+1, xTo, yFrom, yTo, (xTo-wallPos-1) > (yTo-yFrom));
        }
        else {
            wallPos = (rand.nextInt((yTo - yFrom) / 2)) * 2 + yFrom + 1;
            holePos = (rand.nextInt((xTo - xFrom) / 2)) * 2 + xFrom;
            drawWall(wallPos, holePos, xFrom, xTo, false);
            generate(xFrom, xTo, yFrom, wallPos-1, (xTo-xFrom) > (wallPos-1-yFrom));
            generate(xFrom, xTo, wallPos+1, yTo, (xTo-xFrom) > (yTo-wallPos-1));
        }
    }

    private void generateInAndOut() {
        Random rand = new Random();
        int inPos = (rand.nextInt((width-1)/2) * 2) + 1;
        int outPos = (rand.nextInt((width-1)/2) * 2) + 1;

        maze[0][inPos] = '#';
        maze[height-1][outPos] = '*';
    }

    private void drawWall(int pos, int hole, int from, int to, boolean isVertical) {
        if(isVertical) {
            for(int i = from; i <= to; i++)
                if(i != hole)
                    maze[i][pos] = '1';
        }
        else {
            for(int i = from; i <= to; i++)
                if(i != hole)
                    maze[pos][i] = '1';
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < height; i++) {
            for(int j = 0; j < width; j++) {
                sb.append(maze[i][j]);
            }
            sb.append('\n');
        }
        return sb.toString();
    }
}