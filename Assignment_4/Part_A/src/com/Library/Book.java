package com.Library;

import java.lang.*;
import java.util.Objects;

public class Book {
    private String name;
    private Long ISBN_number;
    private Long Bar_Code;

    public void setName(String name){
        this.name = name;
    }

    public void setISBN_number(Long ISBN_number) {
        this.ISBN_number = ISBN_number;
    }

    public void setBar_Code(Long bar_Code) {
        Bar_Code = bar_Code;
    }

    public Long getBar_Code() {
        return Bar_Code;
    }

    public Long getISBN_number() {
        return ISBN_number;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return name.equals(book.name) && ISBN_number.equals(book.ISBN_number) && Bar_Code.equals(book.Bar_Code);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, ISBN_number, Bar_Code);
    }

    public boolean isGreater(Book o){
        String n1 = this.name;
        Long is1 = this.ISBN_number;
        Long br1 = this.Bar_Code;
        String n2 = o.getName();
        Long is2 = o.getISBN_number();
        Long br2 = o.getBar_Code();

        if (n1.equals(n2)){
            if (is1.equals(is2)){
                return  (((long) br1) > ((long) br2));
            }

            return (((long) is1) > ((long) is2));
        }

        return (n1.compareTo(n2)>0);

    }

}
