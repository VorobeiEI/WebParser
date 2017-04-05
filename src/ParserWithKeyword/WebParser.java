package ParserWithKeyword;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by JackSparrow on 4/4/2017.
 */
public class WebParser {

    private Element nextpage;
    private String nextpageLink;
    private String keyword ;
    public static List<Offer> offerList = new ArrayList<>();

    public static  void parseWeb(String url) throws IOException {
        ExecutorService pool = Executors.newCachedThreadPool();

        if(url!=null) {
            WebParser parse = new WebParser();
            Document document = Jsoup.connect(url).get();
            Elements offers = document.select("div[class^= product-image]").select("a");
            List<String> goodsLinksList = new ArrayList<>();
            for(Element e: offers){
                goodsLinksList.add(e.attr("abs:href"));
            }
            for(String s : goodsLinksList) {
                pool.execute(()-> {
                     parse.setOffersAttributes(s);
                });
            }
            pool.shutdown();
            try {
                pool.awaitTermination(99999, TimeUnit.DAYS);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            for(int i = 0; i<offerList.size(); i++){
                System.out.println(offerList.get(i));
            }

            url = parse.getNextPageNumber(document);
            System.out.println(parse.getNextPageNumber(document));
            parseWeb(url);
        } else System.out.println("Search is finished");
    }

    public String getKeyWord(){
        Scanner scan = new Scanner(System.in);
        keyword = scan.nextLine();
        return keyword;
    }

    public String getStartPageToParse(String keyword){
        Document doc = null;
        try {
            doc = Jsoup.connect("https://www.aboutyou.de/suche")
                    .data("gender", "female")
                    .data("term", keyword).get();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return doc.location();
    }

    private  String getNextPageNumber(Document doc){
        nextpage = doc.select("li[class=next]").first();
        if(nextpage!=null) {
             nextpageLink = nextpage.select("a").attr("abs:href");
            //System.out.println(nextpageLink);
        }else{
            nextpageLink = null;
        }
        return nextpageLink;
    }

    private void setOffersAttributes(String links){

        Offer offer = new Offer();
        Document docs = null;
        try {
            docs = Jsoup.connect(links).get();
        } catch (IOException e) {
            e.printStackTrace();
        }
        offer.setArticle(docs.select("meta[property=og:isbn]").attr("content"));
        offer.setBrend(docs.select("meta[property=og:brand]").attr("content"));
        offer.setName( docs.select("meta[property=og:title]").attr("content"));
        offer.setPrice(docs.select("meta[property=og:price:standard_amount]").attr("content"));
        offer.setDiscountprice( docs.select("meta[property=og:price:amount]").attr("content"));
        offer.setDescription( docs.select("meta[name=description]").attr("content"));
        offerList.add(offer);


    }
}



