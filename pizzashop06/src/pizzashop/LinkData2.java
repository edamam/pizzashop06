package pizzashop;
import java.net.URL;
import java.util.Date;

import javax.jdo.annotations.*;
 
@PersistenceCapable(identityType = IdentityType.APPLICATION)
public class LinkData2 {
    @PrimaryKey
    @Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
    private Long id;
     
    @Persistent
    private String title;
    
    @Persistent
    private String comment;

    //増やしたの↓
    @Persistent
    private int price;

    @Persistent
    private String name;
    
    @Persistent
    private String topping;

    public LinkData2(String title,int price, String comment, String topping) {
        super();
        this.title = title;
        this.price = price;
        this.comment = comment;
        this.topping = topping;
    }
/*
    public LinkData2(String title, int price, String comment, String name) {
        super();
        this.title = title;
        this.price = price;
        this.comment = comment;
        this.name=name;
    }*/
    
    public Long getId() {
        return id;
    }
 
    public void setId(Long id) {
        this.id = id;
    }
 
    public String getTitle() {
        return title;
    }
 
    public void setTitle(String title) {
        this.title = title;
    }

    public String getComment() {
        return comment;
    }
 
    public void setComment(String comment) {
        this.comment = comment;
    }
    //増やしたの 
    public int getPrice() {
        return price;
    }
 
    public void setPrice(int price) {
        this.price = price;
    }
    
    public String getTopping() {
        return topping;
    }
 
    public void setTopping(String Topping) {
        this.topping = topping;
    }
/*    できなかった
    public String getName() {
        return name;
    }
 
    public void setName(String name) {
        this.name = name;
    }
    */
}