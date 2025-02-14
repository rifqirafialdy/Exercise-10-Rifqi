package org.Rifqi.libraryMaterials;
import org.Rifqi.entity.Material;

public class Magazine extends Material {
    private int issueNumber;

    public Magazine(String name, int issueNumber) {
        super(name);
        this.issueNumber = issueNumber;
    }

    @Override
    public void displayInfo() {
        System.out.println("Magazine - Title: " + name + ", Issue No.: " + issueNumber + ", Borrowed: " + (isBorrowed ? "Yes" : "No"));
    }


}
