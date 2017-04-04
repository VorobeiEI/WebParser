package Parser.OfferPackage;

import java.util.List;

/**
 * Created by JackSparrow on 4/4/2017.
 */
public class Offer {

    private String article, brend, name, price, discountprice,description,keyword;

    public Offer(String article, String brend, String name, String price, String discountprice, String description, String keyword) {
        this.article = article;
        this.brend = brend;
        this.name = name;
        this.price = price;
        this.discountprice = discountprice;
        this.description = description;
        this.keyword = keyword;
    }


    public String getArticle() {
        return article;
    }

    public void setArticle(String article) {
        this.article = article;
    }

    public String getBrend() {
        return brend;
    }

    public void setBrend(String brend) {
        this.brend = brend;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDiscountprice() {
        return discountprice;
    }

    public void setDiscountprice(String discountprice) {
        this.discountprice = discountprice;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public String toString(){
        return "ISBN: " + article + "\n" + "Brend: " + brend +
                "\n" + "Name: " + name + "\n" + "Price: " + price + "\n" + "DiscountPrice: " + discountprice
                + "\n" + "Description: " + description + "\n" + "Keywords: " + keyword + "\n";
    }
}
