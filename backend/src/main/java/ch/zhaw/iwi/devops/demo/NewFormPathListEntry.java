package ch.zhaw.iwi.devops.demo;

import java.util.ArrayList;
import java.util.List;

public class NewFormPathListEntry {

    private Key key;
    private String name;
    private String color;
    private String icon;
    private String url;
    private String page;
    private String type;
    private boolean active;
    private String tooltip;
    private List<String> details = new ArrayList<>();
    private float order;
    private Form form;

    public NewFormPathListEntry() {
        this.active = true;
    }

    public Key getKey() {
        return key;
    }

    public void setKey(int id, String name) {
        this.key = new Key(id, name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public List<String> getDetails() {
        return details;
    }

    public void setDetails(List<String> details) {
        this.details = details;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public float getOrder() {
        return order;
    }

    public void setOrder(float order) {
        this.order = order;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }

    public String getTooltip() {
        return tooltip;
    }

    public void setTooltip(String tooltip) {
        this.tooltip = tooltip;
    }

    public String getForm() {
        return form != null ? form.getForm() : null;
    }

    public void setForm(String form) {
        if (form == null) {
            this.form = null;
        } else {
            this.form = new Form(form);
        }
    }


    private static class Key {
        private int id;
        private String name;

        public Key(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }
    }

    private static class Form {
        private String form;

        public Form(String form) {
            this.form = form;
        }

        public String getForm() {
            return form;
        }
    }
}

