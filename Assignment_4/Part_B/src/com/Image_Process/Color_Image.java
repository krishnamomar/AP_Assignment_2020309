package com.Image_Process;

import java.lang.*;
import java.util.ArrayList;

public class Color_Image {
    private ArrayList<ArrayList<Integer>> matrix;
    private Integer Row;
    private Integer Column;

    public ArrayList<ArrayList<Integer>> getMatrix() {
        return matrix;
    }

    public void setMatrix(ArrayList<ArrayList<Integer>> matrix){
        this.matrix = matrix;
    }

    public Integer getColumn() {
        return Column;
    }

    public Integer getRow() {
        return Row;
    }

    public void setColumn(Integer column) {
        this.Column = column;
    }

    public void setRow(Integer row) {
        this.Row = row;
    }
}
