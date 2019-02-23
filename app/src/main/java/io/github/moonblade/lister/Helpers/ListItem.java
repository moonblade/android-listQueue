package io.github.moonblade.lister.Helpers;

public class ListItem {
    String title;
    String subTitle;

    public ListItem(String title) {
        this(title, "");
    }

    public ListItem(String title, String subTitle) {
        this.title = title;
        this.subTitle = subTitle;
    }

    public String getSubTitle() {
        return subTitle;
    }

    public String getTitle() {
        return title;
    }

    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        if (subTitle == "")
            return title;
        return title + ": " + subTitle;
    }

    @Override
    public boolean equals(Object object) {
        return this.title.toString().equals(object.toString());
    }
}
