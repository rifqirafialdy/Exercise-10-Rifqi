package org.Rifqi.entity;

import org.Rifqi.feature.LibraryMaterial;
import java.util.UUID;

public abstract class Material implements LibraryMaterial {
    protected UUID materialId;
    protected String name;
    protected boolean isBorrowed;

    public Material(String name) {
        this.materialId = UUID.randomUUID();
        this.name = name;
        this.isBorrowed = false; // Default: Available
    }

    public UUID getMaterialId() {
        return materialId;
    }

    public String getTitle() {
        return name;
    }

    @Override
    public void displayInfo() {
        System.out.println(getClass().getSimpleName() + " - Title: " + name + ", ID: " + materialId + ", Borrowed: " + (isBorrowed ? "Yes" : "No"));
    }

    @Override
    public boolean isAvailable() {
        return !isBorrowed;
    }

    @Override
    public void borrow() {
        if (!isBorrowed) {
            isBorrowed = true;
            System.out.println("You borrowed: " + name);
        } else {
            System.out.println("This " + name + " is already borrowed.");
        }
    }

    @Override
    public void returnMaterial() {
        if (isBorrowed) {
            isBorrowed = false;
            System.out.println("You returned: " + name);
        } else {
            System.out.println("This " + name+ " was not borrowed.");
        }
    }
}
