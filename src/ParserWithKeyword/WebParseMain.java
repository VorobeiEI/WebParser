package ParserWithKeyword;

import javax.xml.bind.Marshaller;
import java.io.IOException;

/**
 * Created by JackSparrow on 4/5/2017.
 */
public class WebParseMain {
    public static void main(String[] args) {
        WebParser parser = new WebParser();

        try {
         WebParser.parseWeb(parser.getStartPageToParse(parser.getKeyWord()));

        } catch (IOException e) {
            e.printStackTrace();
        }
        ParserWithKeyword.SafaToXml.Marshaller create = new ParserWithKeyword.SafaToXml.Marshaller(WebParser.offerList);
        create.doMarshaling();




    }
}
