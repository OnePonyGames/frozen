package com.oneponygames.frozen.utils;

/*
 * OpenSimplex Noise sample class.
 */

import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.*;

public class OpenSimplexNoiseTest {

    private static final int WIDTH = 100;
    private static final int HEIGHT = 512;
    private static final double FEATURE_SIZE = 128;

    public static void main(String[] args) throws IOException {

        OctaveNoise noise = new OctaveNoise(4, 0.75, 100);
        BufferedImage image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);

        for (int x = 0; x < WIDTH; x++) {
            for (int y = 0; y < HEIGHT; y++) {
                image.setRGB(x, y, 0xFFFFFF);
            }
        }

        double[] output = noise.generateLine(WIDTH);

        for (int x = 0; x < output.length; x++)
        {
            double value = output[x];
            int y = (int) (value * HEIGHT);
            System.out.println(value);
            int rgb = 0x010101;
            image.setRGB(x, y, rgb);
        }

        ImageIO.write(image, "png", new File("noise.png"));
    }

}
