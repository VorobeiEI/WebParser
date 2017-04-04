package Parser;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by JackSparrow on 4/3/2017.
 */
public class GetLinksOfCategories {

    private Document doc;
    private List<String> linksOfCategoriesList;
    private Elements goodsCategoriesLinks;

    public void GetLinksOfCategories() throws IOException {

        doc = Jsoup.connect("https://www.aboutyou.de/").get();

        goodsCategoriesLinks = doc.select("a[class^=js-category-accordion-toggle category-item-label " +
                "category-item-label-2]");

        linksOfCategoriesList = new ArrayList<>();

        for (Element e : goodsCategoriesLinks) {
            linksOfCategoriesList.add(e.attr("abs:href"));

        }
    }

    public List<String> getLinksOfCategoriesList() {
        return linksOfCategoriesList;
    }
}
