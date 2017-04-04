
package Parser;


import javax.jws.soap.SOAPBinding;
import java.io.IOException;
import java.util.Scanner;

/**
 * Created by JackSparrow on 4/3/2017.
 */
public class ParserMain {


    public static void main(String[] args) throws IOException {

        UserKeyword.userKeyWord();

        GetLinksOfCategories categories = new GetLinksOfCategories();
        GetlinksOfGoodsOnEachPage goods = new GetlinksOfGoodsOnEachPage();


        categories.GetLinksOfCategories();

        for (String categ : categories.getLinksOfCategoriesList()){
            System.out.println(categ);
                goods.getLinksofGoods(categ );

                }
            }
        }
