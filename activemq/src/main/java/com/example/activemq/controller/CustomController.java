package com.example.activemq.controller;

import com.example.activemq.activemq.Customer;

public class CustomController {


    public static void main(String[] args) {
        Customer customer = new Customer();
        customer.init();

        CustomController productController = new CustomController();
        try {
            Thread.sleep(1000);
        }catch (Exception e){
            e.printStackTrace();
        }

        new Thread(productController.new CustomMq(customer)).start();
        new Thread(productController.new CustomMq(customer)).start();
        new Thread(productController.new CustomMq(customer)).start();
        new Thread(productController.new CustomMq(customer)).start();

    }

    private class CustomMq implements Runnable{
        Customer customer;
        public CustomMq(Customer customer){
            this.customer=customer;
        }
        @Override
        public void run() {
            while (true){
                try {
                    customer.getMessage("distination2");
                    Thread.sleep(10000);
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }
    }
}
