package Parser;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


/**
 * Created by JackSparrow on 4/3/2017.
 */
public class GetlinksOfGoodsOnEachPage {

    private Document doc;
    private List<String> goodLinksList;
    private Elements goodLinks;
    private Elements webs;
    private String fornextpage;
    private String nextpage;
    private int m =0;
    GetInformationAboutGood info = new GetInformationAboutGood();
    ExecutorService pool1 = Executors.newCachedThreadPool();

    public void getLinksofGoods (String firstpage) throws IOException, InterruptedException {

        do {
            fornextpage = "?page=" + (m + 1);
            doc = Jsoup.connect(firstpage+fornextpage ).get();
            System.out.println(firstpage+fornextpage);
            goodLinks = doc.select("div[class^=product-image]");
            webs = goodLinks.select("a");
        goodLinksList = new ArrayList<>();
        for (Element test : webs) {
            goodLinksList.add(test.attr("abs:href"));
        }

            try {
                nextpage = doc.select("link[rel=next]").first().attr("href");
            } catch (NullPointerException e1) {
                m = 0;
                break;
            }
            for(String goodinformation: goodLinksList){

                pool1.execute(()-> {
                    try {
                        info.getInformationAboutGood(goodinformation);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                });
            } m++;
        }while (nextpage!=null);

    }

}
