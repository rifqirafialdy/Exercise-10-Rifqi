package org.Rifqi.libraryMaterials;
import org.Rifqi.entity.Material;

public class Book extends Material {
    private String author;

    public Book(String name, String author) {
        super(name);
        this.author = author;
    }

    @Override
    public void displayInfo() {
        System.out.println("Book - Title: " + name + ", Author: " + author + ", Borrowed: " + (isBorrowed ? "Yes" : "No"));
    }

}
