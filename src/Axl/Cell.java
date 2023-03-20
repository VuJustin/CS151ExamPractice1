package Axl;

import java.util.LinkedList;
import java.util.List;

public class Cell{
    private double value;
    List<Cell> feeder;
    public Cell(){
        value = 0;
        feeder = new LinkedList<Cell>();
    }
    public void addFeeder(Cell feed){
        feeder.add(feed);
    }
}
