package com.restaurant;

import java.util.List;

public class Section {

    List<Table> tables;
    int waiterId;

    public Section(List<Table> tables, int waiterId) {
        this.tables = tables;
        this.waiterId = waiterId;
    }

    @Override
    public String toString() {
        return "Section{" +
                "tables=" + tables +
                ", waiterId=" + waiterId +
                '}';
    }
}
