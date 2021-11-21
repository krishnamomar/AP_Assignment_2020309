package com.Library;

import java.lang.*;
import java.util.Objects;

public class Book {
    private String name;
    private String ISBN_number;
    private Long Bar_Code;

    public void setName(String name){
        this.name = name;
    }

    public void setISBN_number(String ISBN_number) {
        this.ISBN_number = ISBN_number;
    }

    public void setBar_Code(Long bar_Code) {
        Bar_Code = bar_Code;
    }

    public Long getBar_Code() {
        return Bar_Code;
    }

    public String getISBN_number() {
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
}
