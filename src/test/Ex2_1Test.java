package test;

import Ex2_1.Ex2_1;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.Instant;

import static org.junit.jupiter.api.Assertions.*;

class Ex2_1Test {

    @Test
    void createTextFiles() {
        String[] fileNames = Ex2_1.createTextFiles(4,5,10);
        System.out.println("------------------- Number of lines: " + Ex2_1.getNumOfLines(fileNames) + " -------------------");
        int numOfLines = Ex2_1.getNumOfLines(fileNames);
        assertEquals(17, numOfLines);
        Ex2_1.deleteFiles(fileNames); // Delete files.
    }

    @Test
    void getNumOfLines() {
        String[] fileNames = Ex2_1.createTextFiles(4,5,20);
        Instant start = Instant.now(); // Start timer.
        System.out.println("------------------- Number of lines: " + Ex2_1.getNumOfLines(fileNames) + " -------------------");
        Instant end = Instant.now(); // End times.
        System.out.println("(Time): Without Threads: " + Duration.between(start, end) + "\n"); // Calculating execution time for first option.
        Ex2_1.deleteFiles(fileNames); // Delete files.
    }

    @Test
    void getNumOfLinesThreads() throws InterruptedException {
        String[] fileNames = Ex2_1.createTextFiles(4,5,20);
        Instant start = Instant.now();
        System.out.println("------------------- Number of lines: " + Ex2_1.getNumOfLinesThreads(fileNames) + " -------------------");
        Instant end = Instant.now();
        System.out.println("(Time): With Threads: " + Duration.between(start, end) + "\n"); // Calculating execution time for second option.
        Ex2_1.deleteFiles(fileNames); // Delete files.
    }

    @Test
    void getNumOfLinesThreadPool() {
        String[] fileNames = Ex2_1.createTextFiles(4,5,20);
        Instant start = Instant.now();
        System.out.println("------------------- Number of lines: " + Ex2_1.getNumOfLinesThreadPool(fileNames) + " -------------------");
        Instant end = Instant.now();
        System.out.println("(Time): With ThreadPool: " + Duration.between(start, end) + "\n"); // Calculating execution time for third option.
        Ex2_1.deleteFiles(fileNames); // Delete files.
    }
}