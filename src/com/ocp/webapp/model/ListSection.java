package com.ocp.webapp.model;

import java.util.List;

public class ListSection extends AbstractSection {
    private List<String> items;

    public ListSection(List<String> items) {
        this.items = items;
    }

    public List<String> getItems() {
        return items;
    }

    public void setItems(List<String> items) {
        this.items = items;
    }
}
