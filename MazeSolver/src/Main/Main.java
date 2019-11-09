package Main;

import Maze.Maze;

import java.io.IOException;
import java.util.Scanner;

public class Main {

    static Maze m;

    public static void main(String[] args){
        /*Scanner sc = new Scanner(System.in);
        FileManager fm = new FileManager();
        System.out.println("How to create a maze?");
        System.out.println("1) by size");
        System.out.println("2) by reading from file");
        String answer = sc.next();

        if(answer.equals("1")) {
            System.out.println("What size? (height width)");
            int h = sc.nextInt();
            int w = sc.nextInt();
            m = new Maze(h, w);
            m.generate(1, m.getWidth()-2, 1, m.getHeight()-2, m.getWidth() > m.getHeight());
        }
        else if(answer.equals("2")) {
            System.out.println("Path to the file:");
            String path = sc.next();

            m = new Maze(path, fm);
        }
        else {
            System.out.println("Cannot continue - wrong option!");
            System.exit(1);
        }

        System.out.println("Want to save the maze? (yes/no)");
        answer = sc.next();
        if(answer.equals("yes")) {
            System.out.println("Give path to the file:");
            String path = sc.next();
            try {
                fm.writeData(path, m);
            }
            catch(IOException e) {
                System.out.println("Cannot save to the file!");
                System.exit(3);
            }
            System.out.println("Saved!");
        }*/

        m = new Maze(5, 5);
        m.generate(1, m.getWidth()-2, 1, m.getHeight()-2, m.getWidth() > m.getHeight());
        System.out.println("Your maze looks like this:\n" + m);

    }

}
