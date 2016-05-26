package entities;

import java.io.Serializable;

/**
 * Created by Anastasiya on 26.05.2016.
 */
public class Film  implements Serializable {
    //TODO: add id
    String title;
    String description;
    int posterId;


    public Film(String title, String description, int posterId){
        this.title = title;
        this.description = description;
        this.posterId = posterId;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPosterId() {
        return posterId;
    }

    public void setPosterId(int posterId) {
        this.posterId = posterId;
    }
}
