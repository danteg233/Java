//package com.company;
//
//import java.io.BufferedInputStream;
//import java.io.BufferedReader;
//import java.io.File;
//
//public class FileReader extends AbstractReader {
//
//    private String path;
//
//    public FileReader(String path){
//        this.path = path;
//    }
//
//    public String getPath() {
//        return path;
//    }
//
//    @Override
//    public Salad readInfo(String name) {
//        File file = new File(getPath());
//        BufferedReader br = null;
//        String str = null;
//        Salad salad = null;
//        try{
//            br = new BufferedReader(new java.io.FileReader(file));
//            while((str = br.readLine()) != null){
//                String[] info =
//            }
//        }
//
//    }
//}
