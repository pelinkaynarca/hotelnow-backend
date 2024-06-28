package com.tobeto.java4a.hotelnow.core.services;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.w3c.dom.CharacterData;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.tobeto.java4a.hotelnow.core.enums.Currency;

@Service
public class CurrencyService {

	@Value("${currency.tcmb.endpoint}")
	private String TCMB_CURRENCY_ENDPOINT_URL;

	public Double calculateForeignCurrencyEquivalentOfTLAmount(double tlAmount, Currency currency) {
		Double calculatedAmount = null;
		Double currentExchangeRate = getTurkishLiraEquivalentOfForeignCurrency(currency);
		if (currentExchangeRate != null) {
			calculatedAmount = tlAmount / currentExchangeRate;
		}
		return calculatedAmount;
	}

	/**
	 * converts foreign currency to turkish lira according to the current exchange rates of
	 * the central bank of the republic of turkey.
	 * 
	 * @param currency (i.e. USD, EUR)
	 * @return tl equivalent
	 */
	public Double getTurkishLiraEquivalentOfForeignCurrency(Currency currency) {
		URL xmlURL;
		try {
			xmlURL = new URL(TCMB_CURRENCY_ENDPOINT_URL);

			InputStream xml = xmlURL.openStream();
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder db = dbf.newDocumentBuilder();
			Document doc = db.parse(xml);
			doc.getDocumentElement().normalize();

			NodeList nodes = doc.getElementsByTagName("Currency");
			for (int i = 0; i < nodes.getLength(); i++) {
				Element element = (Element) nodes.item(i);
				if (element.getAttribute("CurrencyCode").equalsIgnoreCase(currency.name())) {
					return Double.parseDouble(getValueofElement(element, "BanknoteSelling"));
//					getValueofElement(element, "BanknoteBuying");
				}
			}
			xml.close();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		}
		return null;
	}

	private String getValueofElement(Element parentElement, String label) {
		String returnValue = "";
		Element requiredElement = (Element) parentElement.getElementsByTagName(label).item(0);

		try {
			Node child = requiredElement.getFirstChild();
			if (child instanceof CharacterData) {
				CharacterData cd = (CharacterData) child;
				returnValue = cd.getData();
			}
		} catch (Exception ex) {
		}

		return returnValue;
	}
}
