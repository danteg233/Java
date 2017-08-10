package com.company.datareaders;

import com.company.model.Salad;
import com.company.parser.SaladParser;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;

public class XMLReader extends AbstractReader {

    String path;

    public XMLReader(String path){
        this.path = path;
    }

    @Override
    public Salad readInfo(String name) {
        Salad salad = null;
        SAXParserFactory spfac = SAXParserFactory.newInstance();
        SAXParser parser;
        SaladParser handler = null;
        try{
            parser = spfac.newSAXParser();
            handler = new SaladParser();
            parser.parse(new File(path), handler);
            salad = handler.getSaladByName(name);
        }catch (ParserConfigurationException e){
            System.err.println("Parsing failing " + e.getMessage());
        }catch (Exception e){
            System.err.println(e.getMessage());
        }
        return salad;
    }
}
