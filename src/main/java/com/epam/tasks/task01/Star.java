package com.epam.tasks.task01;

/**
 * Created by Komarov Vasiliy on 27.09.2017.
 */
public class Star extends HeavenlyBody{
    private SpectralType spectralType;

    public Star(int x, int y, int radius, int gravity, SpectralType spectralType) {
        super(x, y, radius, gravity);
        this.spectralType = spectralType;
    }

    public SpectralType getSpectralType() {
        return spectralType;
    }
}
