package com.company.parser;

import com.company.model.Salad;
import com.company.model.Vegetable;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.LinkedList;

public class SaladParser extends DefaultHandler {

    private Salad salad;
    private LinkedList<Salad> salads = new LinkedList<>();
    private StringBuilder thisElement;
    private Vegetable vegetable;


    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        thisElement = new StringBuilder();
        if (qName.equals("salad")){
             salad = new Salad();
        }

    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        thisElement.append(ch, start,length);
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if(qName.equals("salName")){
            String elementVal = thisElement.toString();
            salad.setName(elementVal);
        }
        else {
            String nameOfClass;
            Class<?> saladClass;
            double weight, calories;
            String elementVal = thisElement.toString();
            if (qName.equals("name")){
                nameOfClass = elementVal;
                try{
                    nameOfClass = "com.company.model." + nameOfClass;
                    saladClass = Class.forName(nameOfClass);
                    Object obj = saladClass.newInstance();
                    vegetable = (Vegetable) obj;
                    salad.addIngredient(vegetable);
                    salads.add(salad);
                }catch (ClassNotFoundException e){
                    System.err.println("Couldn't find a class with name " + nameOfClass);
                    return;
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InstantiationException e) {
                    e.printStackTrace();
                }
            }
            else if(qName.equals("weight")){
                weight = Double.parseDouble(elementVal);
                vegetable.setWeight(weight);
            }
            else if(qName.equals("calories")){
                calories = Double.parseDouble(elementVal);
                vegetable.setCalories(calories);
            }

        }
        thisElement = new StringBuilder();
    }

    public Salad getSaladByName(String name) {
        Salad temp = null;
        for (Salad salad: salads) {
            if (salad.getName().compareTo(name) == 0){
                temp = salad;
            }
        }
        return temp;
    }
}
