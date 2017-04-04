package Parser;

import Parser.OfferPackage.Offer;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by JackSparrow on 4/3/2017.
 */
public class GetInformationAboutGood {
    private Document doc;
    private String article, brend, name, price, discountprice,description,keyword;
    private Offer offer;
    private List<Offer> listoffers;

    public void getInformationAboutGood(String good) throws IOException {
         doc = Jsoup.connect(good).get();
         listoffers = new ArrayList<>();
         offer = new Offer(doc.select("meta[property=og:isbn]").attr("content"),
                doc.select("meta[property=og:brand]").attr("content"),
                doc.select("meta[property=og:title]").attr("content"),
                doc.select("meta[property=og:price:standard_amount]").attr("content"),
                doc.select("meta[property=og:price:amount]").attr("content"),
                doc.select("meta[name=description]").attr("content"),
                doc.select("meta[name=keywords]").attr("content")
        );
         listoffers.add(offer);

           System.out.println(offer);
       }

        //System.out.println(toString());}

    }



