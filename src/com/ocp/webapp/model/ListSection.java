package com.ocp.webapp.model;

import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class ListSection extends AbstractSection {
    public static final long serialVersionIID=1L;
    private List<String> items;

    public ListSection() {
    }

    public ListSection(String... items) {
        this(Arrays.asList(items));
    }


    public ListSection(@NotNull List<String> items) {
        Objects.requireNonNull(items, "content must not be null");
        this.items = items;
    }

    public List<String> getItems() {
        return items;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ListSection that = (ListSection) o;

        return items.equals(that.items);
    }

    @Override
    public int hashCode() {
        return items.hashCode();
    }

    @Override
    public String toString() {
//        return items.toString();
        StringBuilder sb = new StringBuilder();
        for (String s : items) {
            sb.append("- " + s + "\n");
        }
        return sb.toString();
    }
}
