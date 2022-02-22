package com.example.nvz;

public class RssItem {
    public String title;
    public String description;
    public String pubDate;
    public String link;

    public RssItem(String title) {
        this.title = title;
    }

    public RssItem() {

    }

    @Override
    public String toString() {
        return title;
    }
}
