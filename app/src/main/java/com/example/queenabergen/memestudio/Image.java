package com.example.queenabergen.memestudio;

/**
 * Created by yojanasharma on 1/20/17.
 */

public class Image {
    private String imageName;
    private Integer resId;

    public Integer getResId(){
        return resId;
    }

    public String getImageName(){
      return imageName;
    }


    public Image(String imageName, Integer resId){
       this.imageName = imageName;
        this.resId = resId;
    }
}
