package com.Library;

import java.util.*;

public class BookRack <T>{
    private ArrayList<T> Racks = new ArrayList<T>();
    private Book chk;

    public void addBook(T o){
        this.Racks.add(o);
    }

    public void Sort_(){

        if (chk instanceof Book){
            Book sortedrack[] = new Book[Racks.size()];
            for (int i=0; i< Racks.size(); i++){
                sortedrack[i] = (Book)Racks.get(i);
            }

            for (int i=0; i< Racks.size(); i++){
                for (int j=i; j< Racks.size(); j++){
                    if (sortedrack[i].isGreater(sortedrack[j])){
                        Book x = sortedrack[j];
                        sortedrack[j] = sortedrack[i];
                        sortedrack[i] = x;
                    }
                }
            }

            for (int i=0; i< Racks.size(); i++){
                this.Racks.set(i, (T)sortedrack[i]);
            }

        }

        else {
            //this case never occurs XD
            //Collections.sort(this.Racks);
        }
    }

    public ArrayList<T> getRacks(){
        return Racks;
    }
}
