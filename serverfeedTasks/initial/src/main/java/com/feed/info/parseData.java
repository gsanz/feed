package com.feed.info;

import java.util.LinkedList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.example.accessingdatamysql.Feed;
import com.example.accessingdatamysql.FeedRepository;

public class parseData {
	private String url;
	private static Feed save;
	public parseData(String url){
		this.url = url;
	}
		
	public info  obtainData() {		
		info infoData = new info();
		
        try
        {
            DocumentBuilderFactory f = DocumentBuilderFactory.newInstance();
            DocumentBuilder b = f.newDocumentBuilder();
            Document doc = b.parse(url);
            doc.getDocumentElement().normalize();
            NodeList nl = doc.getDocumentElement().getChildNodes();
            int length = nl.getLength();
            System.out.println(length);
            for (int i = 0; i < length; i++) {
                System.out.println(nl.item(i).getNodeType()+"__"+nl.item(i).getNodeName());
                if (nl.item(i).getNodeName().equals("channel")) {               	
                	NodeList nla = nl.item(i).getChildNodes();
                	for (int k = 0; k < nla.getLength(); k++) {
                		if (nla.item(k).getNodeName() == "item") {
                            NodeList nlitems = nla.item(k).getChildNodes();
                			for (int j= 0; j < nlitems.getLength(); j++) {
                				System.out.println(nlitems.item(j).getNodeName());
                				NodeList nlInfo= nlitems.item(j).getChildNodes();				
                				if ((nlitems.item(j).getNodeName() =="title") && (nlitems.item(j).getFirstChild().getNodeValue() != null)){
                					System.out.println("TITULO "+nlitems.item(j).getFirstChild().getNodeValue());
                					infoData.getTitle().add(nlitems.item(j).getFirstChild().getNodeValue());
                				}
                				
                				if ((nlitems.item(j).getNodeName() =="link") && (nlitems.item(j).getTextContent() != null))  {
                					System.out.println("LINK "+nlitems.item(j).getTextContent());
                					infoData.getUrlLink().add(nlitems.item(j).getTextContent());
                				}
                				
                				if ((nlitems.item(j).getNodeName() =="description") && (nlitems.item(j).getTextContent() != null))  {
                					System.out.println("DESCRIPTION "+nlitems.item(j).getTextContent()); 
                                    infoData.getDescription().add(nlitems.item(j).getTextContent());
                				}   				
                				if (nlitems.item(j).getNodeName() =="enclosure") {              					
                					Element el = (Element) nlitems.item(j);             					
                					System.out.println("IMAGEN "+el.getAttribute("type")+ "  URL  "+el.getAttribute("url"));
                				    infoData.getUrlImage().add(el.getAttribute("url"));
                				}

                			}
                			
                		}
                		
                		
                	}
                	
                	
                }
                
                
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

		return infoData;
		
	}
	
	
	
	
	

}
