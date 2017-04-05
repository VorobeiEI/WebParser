package ParserWithKeyword;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;

/**
 * Created by JackSparrow on 4/4/2017.
 */
@XmlRootElement
@XmlType(propOrder = {"article", "brend", "name", "price", "discountprice", "description"})
public class Offer {
    private String article;
    private String brend;
    private String name;
    private String price;
    private String discountprice;
    private String description;

    public Offer() {
    }

    public Offer(String article, String brend, String name, String price, String discountprice, String description) {
        this.article = article;
        this.brend = brend;
        this.name = name;
        this.price = price;
        this.discountprice = discountprice;
        this.description = description;
    }

    public String getArticle() {
        return article;
    }
    @XmlElement(name = "article")
    public void setArticle(String article) {
        this.article = article;
    }

    public String getBrend() {
        return brend;
    }
    @XmlElement(name = "brend")
    public void setBrend(String brend) {
        this.brend = brend;
    }

    public String getName() {
        return name;
    }
    @XmlElement(name = "name")
    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }
    @XmlElement(name = "price")
    public void setPrice(String price) {
        this.price = price;
    }

    public String getDiscountprice() {
        return discountprice;
    }
    @XmlElement(name = "discountprice")
    public void setDiscountprice(String discountprice) {
        this.discountprice = discountprice;
    }

    public String getDescription() {
        return description;
    }
    @XmlElement(name = "description")
    public void setDescription(String description) {
        this.description = description;
    }

    public String toString(){
        System.out.println();
        return "ISBN: " + article + "\n" + "Brend: " + brend +
                "\n" + "Name: " + name + "\n" + "Price: " + price + "\n" + "DiscountPrice: " + discountprice
                + "\n" + "Description: " + description;

    }
}
