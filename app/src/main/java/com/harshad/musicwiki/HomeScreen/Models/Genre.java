package com.harshad.musicwiki.HomeScreen.Models;

public class Genre {
    private String name;
    private long count;
    private long reach;

    @Override
    public String toString() {
        return "Genre{" +
                "name='" + name + '\'' +
                ", count=" + count +
                ", reach=" + reach +
                '}';
    }

    public String getName() {
        return name;
    }

    public long getCount() {
        return count;
    }

    public long getReach() {
        return reach;
    }
}
