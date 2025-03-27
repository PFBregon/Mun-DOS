package dev.patriciafb;

import dev.patriciafb.view.View;

public class App {
    private View view;

    public App(View view) {
        this.view = view;
        this.view.start();
    }
}
