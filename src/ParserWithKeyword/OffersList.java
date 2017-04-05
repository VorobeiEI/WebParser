package ParserWithKeyword;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by JackSparrow on 4/5/2017.
 */
@XmlRootElement
public class OffersList {

    private List<Offer> offerList1 = new ArrayList<>();
    @XmlElement(name = "offer")
    public void setOfferList(List<Offer> offerList) {
        this.offerList1 = offerList;
    }

    public List<Offer> getOfferList() {
        return offerList1;
    }

}
