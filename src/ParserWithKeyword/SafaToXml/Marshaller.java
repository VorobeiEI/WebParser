package ParserWithKeyword.SafaToXml;

import ParserWithKeyword.Offer;
import ParserWithKeyword.OffersList;
import ParserWithKeyword.WebParser;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import java.io.File;
import java.util.List;

/**
 * Created by JackSparrow on 4/5/2017.
 */
public class Marshaller {
    private OffersList list = new OffersList();
    private List<Offer> list1;

    public Marshaller(List<Offer> list1) {
        this.list1 = list1;
        list.setOfferList(this.list1);
    }

    public void doMarshaling(){

        File file = new File("F:/offers.xml");
        JAXBContext context = null;
        try {
            context = JAXBContext.newInstance(OffersList.class);
            javax.xml.bind.Marshaller marsh = context.createMarshaller();
            marsh.setProperty(javax.xml.bind.Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

                marsh.marshal(list, file);
        } catch (JAXBException e) {
            e.printStackTrace();
        }


    }
}
