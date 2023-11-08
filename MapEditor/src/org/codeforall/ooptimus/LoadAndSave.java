package org.codeforall.ooptimus;
import org.academiadecodigo.simplegraphics.graphics.Color;

import java.awt.font.FontRenderContext;
import java.io.*;

public class LoadAndSave {
    private Grid grid;
    private String[] arrayOfLine;
    public LoadAndSave(Grid grid) {
        this.grid = grid;
    }


            // Writes the isPainted Array in a file. \\
    public void save() {
        try {
            FileWriter fileWriter = new FileWriter("MapEditor/SaveAndLoadDir/save.txt");
            for (int i = 0; i < grid.getIsPainted().length; i++) {
                if (grid.getIsPainted()[i]) {
                    fileWriter.write("1" + "\n");
                } else {
                    fileWriter.write("0" + "\n");
                }
            }

            fileWriter.close();

        }catch (IOException e) {
            e.printStackTrace();
        }
    }


            // Transcribe to the isPainted array and paint the grid as the isPainted array is at the moment \\
    public void load() {

        String[] placeHolder = readAndOrganize();

        for (int i = 0; i < placeHolder.length; i++) {
            if (placeHolder[i].equals("1")) {
                grid.setIsPainted(i,true);
                grid.getRectanglesArray()[i].fill();
            } else {
                grid.setIsPainted(i,false);
                grid.getRectanglesArray()[i].draw();
            }
        }
    }

            // Reads the file of 0 and 1 and return a String array \\
    public String[] readAndOrganize() {
        try {
            FileReader fileReader = new FileReader("MapEditor/SaveAndLoadDir/save.txt");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            String lineToLoad = "";

            while ((line = bufferedReader.readLine()) != null) {
                lineToLoad += line;
            }

            arrayOfLine = lineToLoad.split("");

            bufferedReader.close();
            fileReader.close();

            return arrayOfLine;

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}