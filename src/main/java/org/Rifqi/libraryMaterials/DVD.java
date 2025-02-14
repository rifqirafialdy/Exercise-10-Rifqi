package org.Rifqi.libraryMaterials;
import org.Rifqi.entity.Material;

public class DVD extends Material {
    private String director;

    public DVD(String name, String director) {
        super(name);
        this.director = director;
    }

    @Override
    public void displayInfo() {
        System.out.println("DVD - Title: " + name + ", Director: " + director + ", Borrowed: " + (isBorrowed ? "Yes" : "No"));
    }


}
