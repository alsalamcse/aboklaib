package com.aboklaib.moaadtaskmanger.data;

public class task
{
    private String key;
    private String title;
    private String sub;
    private String prio;

    public task() {
//llllll
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSub() {
        return sub;
    }

    public void setSub(String sub) {
        this.sub = sub;
    }

    public String getPrio() {
        return prio;
    }

    public void setPrio(String prio) {
        this.prio = prio;
    }

    @Override
    public String toString() {
        return "task{" +
                "key='" + key + '\'' +
                ", title='" + title + '\'' +
                ", sub='" + sub + '\'' +
                ", prio='" + prio + '\'' +
                '}';
    }
}

