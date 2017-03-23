package com.example.dimitrikeller.tpandroid.Entite;

/**
 * Created by Marianne on 2017-03-22.
 */

public class ImageProfil {

    private int idImage;
    private String ressImage;

    public ImageProfil() {
    }

    public ImageProfil(int idImage, String ressImage) {
        this.idImage = idImage;
        this.ressImage = ressImage;
    }

    public int getIdImage() {
        return idImage;
    }

    public void setIdImage(int idImage) {
        this.idImage = idImage;
    }

    public String getRessImage() {
        return ressImage;
    }

    public void setRessImage(String ressImage) {
        this.ressImage = ressImage;
    }
}
