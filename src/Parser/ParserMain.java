
package Parser;


import Parser.Methods.GetLinksOfCategories;
import Parser.Methods.GetlinksOfGoodsOnEachPage;

import java.io.IOException;

/**
 * Created by JackSparrow on 4/3/2017.
 */
public class ParserMain {


    public static void main(String[] args) throws IOException {

        GetLinksOfCategories categories = new GetLinksOfCategories();
        GetlinksOfGoodsOnEachPage goods = new GetlinksOfGoodsOnEachPage();

        categories.GetLinksOfCategories();
        for (String categ : categories.getLinksOfCategoriesList()){

            try {
                goods.getLinksofGoods(categ );
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
            }
        }
