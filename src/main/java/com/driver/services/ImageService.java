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
        Image image=new Image();
        image.setId(blogId);
        image.setDescription(description);
        image.setDimensions(dimensions);


        Blog blog=blogRepository2.findById(blogId).get();
        if(blog==null)
        {
            return null;
        }
            List<Image> images;
            if (blog.getImages().isEmpty()) {
                images = new ArrayList<>();
            }
            images = blog.getImages();
            images.add(image);

        blogRepository2.save(blog);
        imageRepository2.save(image);
        return image;
    }

    public void deleteImage(Integer id){
        imageRepository2.deleteById(id);
        Image image= imageRepository2.findById(id).get();

        Blog blog= blogRepository2.findById(id).get();
        blog.getImages().remove(image);
        blogRepository2.save(blog);
    }

    public int countImagesInScreen(Integer id, String screenDimensions) {
        //Find the number of images of given dimensions that can fit in a screen having `screenDimensions`
        Blog blog= blogRepository2.findById(id).get();
        int count=blog.getImages().size();
        return count;
    }
}
