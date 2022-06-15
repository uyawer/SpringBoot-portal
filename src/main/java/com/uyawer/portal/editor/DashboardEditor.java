package com.uyawer.portal.editor;

import com.uyawer.portal.model.screen.DashboardScreen;

public class DashboardEditor {

    public static DashboardScreen convertScreen(String message) {
        DashboardScreen screen = new DashboardScreen();
        screen.setMessage(message);
        return screen;
    }
}
