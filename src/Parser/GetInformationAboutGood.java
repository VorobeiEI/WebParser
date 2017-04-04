package Parser;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.List;

/**
 * Created by JackSparrow on 4/3/2017.
 */
public class GetInformationAboutGood {
    private Document doc;
    private String article, brend, name, price, discountprice,description,keyword;

    public void getInformationAboutGood(String good) throws IOException {
         doc = Jsoup.connect(good).get();
         article = doc.select("meta[property=og:isbn]").attr("content");
         brend = doc.select("meta[property=og:brand]").attr("content");
         name = doc.select("meta[property=og:title]").attr("content");
         price = doc.select("meta[property=og:price:standard_amount]").attr("content");
         discountprice = doc.select("meta[property=og:price:amount]").attr("content");
         description = doc.select("meta[name=description]").attr("content");
         keyword = doc.select("meta[name=keywords]").attr("content");

         if(keyword.toLowerCase().contains(UserKeyword.userKeyWord.toLowerCase())){
        System.out.println(toString());}

    }

    public String toString(){
        return "ISBN: " + article + "\n" + "Brend: " + brend +
                "\n" + "Name: " + name + "\n" + "Price: " + price + "\n" + "DiscountPrice: " + discountprice
                + "\n" + "Description: " + description + "\n" + "Keywords: " + keyword + "\n";
    }
}
