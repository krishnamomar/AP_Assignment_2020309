package com.Image_Process;

import java.lang.*;
import java.util.ArrayList;

public class BW_Image implements Image{
    private ArrayList<ArrayList<Integer>> Matrix;
    private Integer Row;
    private Integer Column;
    private String Name;

    public ArrayList<ArrayList<Integer>> getMatrix() {
        return Matrix;
    }

    public void setMatrix(ArrayList<ArrayList<Integer>> matrix){
        this.Matrix = matrix;
    }

    @Override
    public Integer getColumn() {
        return Column;
    }

    @Override
    public Integer getRow() {
        return Row;
    }

    @Override
    public void setColumn(Integer column) {
        this.Column = column;
    }

    @Override
    public void setRow(Integer row) {
        this.Row = row;
    }

    @Override
    public String getName() {
        return Name;
    }

    @Override
    public void setName(String name) {
        this.Name = name;
    }
}
