package com.codebook.algorithm;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;
import javax.imageio.ImageIO;

public class Histogram {

    public static void main(String[] args) {
        calculateRGBHistogramAsync();
//        histogramAsync();
    }

    public static void calculateRGBHistogramAsync() {
        long startTime = System.currentTimeMillis();
        try {
            BufferedImage image =  ImageIO.read(new File("/Users/davidou/Documents/codebook/Algorithm/resources/3005.jpeg"));
            int w = image.getWidth();
            int h = image.getHeight();
            int[] rHistogram = new int[256];
            int[] gHistogram = new int[256];
            int[] bHistogram = new int[256];
            for (int i = 0; i < h; i++)
            {
                for (int j = 0; j < w; j++)
                {
//                    System.out.println("x,y: " + j + ", " + i);
                    int pixel = image.getRGB(j,i);
                    int alpha = (pixel >> 24) & 0xff;
                    int red = (pixel >> 16) & 0xff;
                    int green = (pixel >> 8) & 0xff;
                    int blue = (pixel) & 0xff;

                    rHistogram[red] += 1;
                    gHistogram[green] += 1;
                    bHistogram[blue] += 1;

//                    System.out.println("GOT MY HISTOGRAMS");
                }
            }
        } catch (IOException e) {
            System.out.println("MUFASA");
        }

        long endTime = System.currentTimeMillis();
        System.out.println("histogramSynchronous: " + (endTime - startTime));
    }

    public static void histogramAsync() {
        long startTime = System.currentTimeMillis();
        try {
            final BufferedImage image =  ImageIO.read(new File("/Users/davidou/Documents/codebook/Algorithm/resources/3005.jpeg"));
            final int w = image.getWidth();
            final int h = image.getHeight();
            final int[] rHistogram = new int[256];
            final int[] gHistogram = new int[256];
            final int[] bHistogram = new int[256];

            ForkJoinPool forkJoinPool = new ForkJoinPool(8);
            try {
                forkJoinPool.submit(() ->
                                //parallel task here, for example
                                IntStream.range(0, h).parallel().forEach(i -> {
                                    IntStream.range(0, w).parallel().forEach(j -> {
//                                System.out.println("x,y: " + j + ", " + i);
                                        int pixel = image.getRGB(j, i);
                                        int alpha = (pixel >> 24) & 0xff;
                                        int red = (pixel >> 16) & 0xff;
                                        int green = (pixel >> 8) & 0xff;
                                        int blue = (pixel) & 0xff;

                                        rHistogram[red] += 1;
                                        gHistogram[green] += 1;
                                        bHistogram[blue] += 1;
                                    });
                                })
                ).get(1, TimeUnit.SECONDS);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } catch (IOException e) {
            System.out.println("MUFASA");
        }
        long endTime = System.currentTimeMillis();
        System.out.println("histogramAsync: " + (endTime - startTime));
    }

}
