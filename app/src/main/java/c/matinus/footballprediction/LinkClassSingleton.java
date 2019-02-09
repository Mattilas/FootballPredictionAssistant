package c.matinus.footballprediction;

public class LinkClassSingleton {
    private static LinkClassSingleton instance;
    private boolean componentVisibility = false;

    private LinkClassSingleton() {
    }

    public static LinkClassSingleton getInstance() {
        if (instance == null) {
            instance = new LinkClassSingleton();
        }
        return instance;
    }

    public boolean isButtonVisible() {
        return this.componentVisibility;
    }

    public void setButtonVisible(boolean buttonVisible) {
        this.componentVisibility = this.componentVisibility;
    }
}