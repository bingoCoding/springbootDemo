package com.example.activemq.controller;

import com.example.activemq.activemq.Productor;

public class ProductController {


    public static void main(String[] args) {
        Productor productor =new Productor();
        productor.init();

        ProductController productController = new ProductController();
        try {
            Thread.sleep(1000);
        }catch (Exception e){
            e.printStackTrace();
        }

        new Thread(productController.new ProductMq(productor)).start();
        new Thread(productController.new ProductMq(productor)).start();
        new Thread(productController.new ProductMq(productor)).start();
        new Thread(productController.new ProductMq(productor)).start();
        new Thread(productController.new ProductMq(productor)).start();

    }

    private class ProductMq implements Runnable{
        Productor productor;
        public ProductMq(Productor productor){
            this.productor=productor;
        }
        @Override
        public void run() {
            while (true){
                try {
                    productor.sendMessage("distination2");
                    Thread.sleep(10000);
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }
    }
}
