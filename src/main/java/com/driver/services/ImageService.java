package com.driver.services;

import com.driver.models.*;
import com.driver.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ImageService {

    @Autowired
    BlogRepository blogRepository2;
    @Autowired
    ImageRepository imageRepository2;

    public Image addImage(Integer blogId, String description, String dimensions){
        //add an image to the blog

        Blog blog=blogRepository2.findById(blogId).get();
        Image image=new Image(description,dimensions,blog);
        blog.getImageList().add(image);
        blogRepository2.save(blog);
        return image;
    }

    public void deleteImage(Integer id){
        imageRepository2.deleteById(id);
    }

    public int countImagesInScreen(Integer id, String screenDimensions) {
        //Find the number of images of given dimensions that can fit in a screen having `screenDimensions`
       String[]scarray= screenDimensions.split("X");
       Image image=imageRepository2.findById(id).get();
       String imagedimension = image.getDimensions();
       String []imagearray=imagedimension.split("X");
       int scrlen = Integer.parseInt(scarray[0]);
       int scrbred = Integer.parseInt(scarray[1]);

        int imglen = Integer.parseInt(imagearray[0]);
        int imgbred = Integer.parseInt(imagearray[1]);
        return imageCount(scrlen,scrbred,imglen,imgbred);
    }
    private int imageCount(int scrlen, int scrbred, int imglen, int imgbred)
    {
        int lenC=scrlen/imglen;
        int lenB=scrbred/imgbred;
        return  lenC*lenB;
    }
}
