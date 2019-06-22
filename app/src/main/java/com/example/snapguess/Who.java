package com.example.snapguess;

public class Who {
    private final String imageName;
    private boolean isBlanked = false;
    private boolean isChosen = false;
    private final String bitmoji;

    public Who(String imageName, String bitmoji) {
        this.imageName = imageName;
        this.bitmoji = bitmoji;
    }

    public String getImageName() {
        return imageName;
    }

    public boolean getIsChosen() {
        return isChosen;
    }
    public void setIsChosen(boolean isChosen) {
        this.isChosen = isChosen;
    }

    public boolean getIsBlanked() {
        return isBlanked;
    }

    public void toggleBlanked() {
        isBlanked = !isBlanked;
    }

    public String getBitmoji() {
        return bitmoji;
    }
}


