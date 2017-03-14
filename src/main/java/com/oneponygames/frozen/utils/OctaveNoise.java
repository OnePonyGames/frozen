package com.oneponygames.frozen.utils;

/**
 * Created by Icewind on 14.03.2017.
 */
public class OctaveNoise {

    private final int octaves;
    private final double persistence;
    private final OpenSimplexNoise noise;

    public OctaveNoise(int octaves, double persistence, long seed) {
        this.octaves = octaves;
        this.persistence = persistence;
        this.noise = new OpenSimplexNoise(seed);
    }

    public double[] noise(double[] xin, double[] yin) {
        return this.noise(xin, yin, 1);
    }

    public double[] noise(double[] xin, double[] yin, double startingFrequency) {
        double[] output = new double[xin.length];
        for(int i=0;i<xin.length;i++) {
            output[i] = this.octaveNoise(xin[i], yin[i], startingFrequency);
        }
        return output;
    }

    private double octaveNoise(double x, double y, double startingFrequency) {
        double total = 0;
        double frequency = startingFrequency;
        double amplitude = 1;
        double maxValue = 0;
        for(int i=0;i<octaves;i++) {
            total += this.eval(x * frequency, y * frequency) * amplitude;

            maxValue += amplitude;

            amplitude *= persistence;
            frequency *= 2;
        }

        return total/maxValue;
    }

    private double eval(double x, double y) {
        return (this.noise.eval(x, y) + 1) / 2d;
    }

    public double[] generateLine(int nrValues) {
        double[] xin = new double[nrValues];
        double[] yin = new double[nrValues];

        for(int i=0;i<nrValues;i++) {
            xin[i] = 0.5;
            yin[i] = i / (double)(nrValues-1);
        }

        return this.noise(xin, yin);
    }
}
