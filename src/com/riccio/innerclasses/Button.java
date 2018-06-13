package com.riccio.innerclasses;

public class Button {

    private String title;
    private OnClickListener oncClickListener;

    public Button(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setOncClickListener(OnClickListener oncClickListener) {
        this.oncClickListener = oncClickListener;
    }
    public void onClick(){
        this.oncClickListener.onClick(this.title);
    }


    public interface OnClickListener{
        public void onClick(String title);
    }
}
