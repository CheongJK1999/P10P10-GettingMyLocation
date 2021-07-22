package sg.edu.rp.c346.id19043996.p10_gettingmylocation;

import java.io.Serializable;

public class Locations implements Serializable {
    private int id;
    private String updates;

    public Locations(int id, String updates) {
        this.id = id;
        this.updates = updates;
    }

    public int getId() {
        return id;
    }

    public String getUpdates() {
        return updates;
    }
}
