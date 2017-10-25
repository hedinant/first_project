package com.example.DemoKurs;




////////////////////////////////////////////////////////////
class PredmetTorga {
   float intrinsicPrice; //собственная цена
    float intrinsicPriceUp;
    float intrinsicPriceDown;
    float price;
    float quantity; // Количество
    //String name;

      float calculateValue() { //Price*Quantity
          return  this.price*this.quantity;
    }
}
/////////////////////////////////


public class DemoKurs1 {

    public static void main(String[] args) {

        PredmetTorga futures1=new PredmetTorga();
        futures1.price = 50;
        futures1.quantity = 100;

        float cV = futures1.calculateValue();
        System.out.println (cV);
        System.out.println (futures1.price+" "+futures1.quantity+" "+ futures1.calculateValue());

        futures1.intrinsicPrice = (float)(100*Math.random());

       /* for (int t=1;t<=100;t++) {
            futures1.intrinsicPrice =  futures1.intrinsicPrice + (float) (futures1.intrinsicPrice*0.02*(0.5-(Math.random())));
            futures1.intrinsicPriceUp = futures1.intrinsicPrice + (float) (0.1*futures1.intrinsicPrice * Math.random());
            futures1.intrinsicPriceDown = futures1.intrinsicPrice - (float) (0.1*futures1.intrinsicPrice * Math.random());
            System.out.println(futures1.intrinsicPrice + " " + futures1.intrinsicPriceUp + " " + futures1.intrinsicPriceDown);
        }*/

        float vigoda = 0;
        float komis= (float)(0.05);
        int n=10;
        PredmetTorga futuresBuy[]=new PredmetTorga[n];
        PredmetTorga futuresSale[]=new PredmetTorga[n];
        PredmetTorga optionBuy[]=new PredmetTorga[n];
        PredmetTorga optionSale[]=new PredmetTorga[n];

//Заполнение в начальный момент времени


        for (int i=1;i<=n;i++)
        {
            futuresBuy[i].intrinsicPrice=10;
           // futuresBuy[i].intrinsicPrice=(float)(10*Math.random());
            //futuresBuy[i].name="FirstName";
            //futuresBuy[i].price=(float)3.33;
            //futuresBuy[i].quantity=(float)3;

            futuresSale[i].intrinsicPrice=  (float)(10*Math.random());
           // futuresSale[i].name="FirstName";
            //futuresSale[i].price=(float)3.33;
            //futuresSale[i].quantity=(float)3;

            optionBuy[i].intrinsicPrice=    (float)(10*Math.random());
           // optionBuy[i].name="FirstName";
           // optionBuy[i].price=(float)3.33;
            //optionBuy[i].quantity=(float)3;

            optionSale[i].intrinsicPrice=   (float)(10*Math.random());
            //optionSale[i].name="FirstName";
            //optionSale[i].price=(float)3.33;
            //optionSale[i].quantity=(float)3;

        }

        for (int t=1;t<=100;t++) {
            for (int i=1;i<=n;i++) {
                futuresBuy[i].intrinsicPrice =  futuresBuy[i].intrinsicPrice + (float) (futuresBuy[i].intrinsicPrice*0.02*(0.5-(Math.random())));
                futuresBuy[i].intrinsicPriceUp = futuresBuy[i].intrinsicPrice + (float) (0.1*futuresBuy[i].intrinsicPrice * Math.random());
                futuresBuy[i].intrinsicPriceDown = futuresBuy[i].intrinsicPrice - (float) (0.1*futuresBuy[i].intrinsicPrice * Math.random());

                futuresSale[i].intrinsicPrice =  futuresSale[i].intrinsicPrice + (float) (futuresSale[i].intrinsicPrice*0.02*(0.5-(Math.random())));
                futuresSale[i].intrinsicPriceUp = futuresSale[i].intrinsicPrice + (float) (0.1*futuresSale[i].intrinsicPrice * Math.random());
                futuresSale[i].intrinsicPriceDown = futuresSale[i].intrinsicPrice - (float) (0.1*futuresSale[i].intrinsicPrice * Math.random());

                optionBuy[i].intrinsicPrice =  optionBuy[i].intrinsicPrice + (float) (optionBuy[i].intrinsicPrice*0.02*(0.5-(Math.random())));
                optionBuy[i].intrinsicPriceUp = optionBuy[i].intrinsicPrice + (float) (0.1*optionBuy[i].intrinsicPrice * Math.random());
                optionBuy[i].intrinsicPriceDown = optionBuy[i].intrinsicPrice - (float) (0.1*optionBuy[i].intrinsicPrice * Math.random());

                optionSale[i].intrinsicPrice =  optionSale[i].intrinsicPrice + (float) (optionSale[i].intrinsicPrice*0.02*(0.5-(Math.random())));
                optionSale[i].intrinsicPriceUp = optionSale[i].intrinsicPrice + (float) (0.1*optionSale[i].intrinsicPrice * Math.random());
                optionSale[i].intrinsicPriceDown = optionSale[i].intrinsicPrice - (float) (0.1*optionSale[i].intrinsicPrice * Math.random());

            }

            for (int i=1;i<=n;i++) {
                for (int j=i+1;j<=n;j++) {
                    System.out.println(i +" "+j);

                   float vr1= -futuresBuy[i].intrinsicPriceUp+ futuresBuy[j].intrinsicPriceDown-2*komis;
                   if (vr1>0){
                       vigoda=vigoda+vr1;
                       System.out.println("vr1" + i +" "+j+" "+vr1);
                   }

                    float vr2= -futuresBuy[i].intrinsicPriceUp- futuresSale[j].intrinsicPriceUp-2*komis;
                    if (vr2>0){
                        vigoda=vigoda+vr2;
                        System.out.println("vr2" + i +" "+j+" "+vr2);
                    }

                    float vr3= futuresBuy[i].intrinsicPriceDown+ futuresSale[j].intrinsicPriceDown-2*komis;
                    if (vr3>0){
                        vigoda=vigoda+vr3;
                        System.out.println("vr3" + i +" "+j+" "+vr3);
                    }

                    float vr4= -futuresSale[i].intrinsicPriceUp+ futuresSale[j].intrinsicPriceDown-2*komis;
                    if (vr4>0){
                        vigoda=vigoda+vr4;
                        System.out.println("vr4" + i +" "+j+" "+vr4);
                    }

                    float vr5= futuresBuy[i].intrinsicPriceDown- optionBuy[j].intrinsicPriceUp-2*komis;
                    if (vr5>0){
                        vigoda=vigoda+vr5;
                        System.out.println("vr5" + i +" "+j+" "+vr5);
                    }

                    float vr6= -futuresSale[i].intrinsicPriceUp- optionBuy[j].intrinsicPriceUp-2*komis;
                    if (vr6>0){
                        vigoda=vigoda+vr6;
                        System.out.println("vr6" + i +" "+j+" "+vr6);
                    }

                    float vr7= -optionBuy[i].intrinsicPriceUp+ optionBuy[j].intrinsicPriceDown-2*komis;
                    if (vr7>0){
                        vigoda=vigoda+vr7;
                        System.out.println("vr7" + i +" "+j+" "+vr7);
                    }

                    float vr8= -futuresBuy[i].intrinsicPriceUp- optionSale[j].intrinsicPriceUp-2*komis;
                    if (vr8>0){
                        vigoda=vigoda+vr8;
                        System.out.println("vr8" + i +" "+j+" "+vr8);
                    }

                    float vr9= futuresSale[i].intrinsicPriceDown- optionSale[j].intrinsicPriceUp-2*komis;
                    if (vr9>0){
                        vigoda=vigoda+vr9;
                        System.out.println("vr9" + i +" "+j+" "+vr9);
                    }

                    float vr10= -optionBuy[i].intrinsicPriceUp- optionSale[j].intrinsicPriceUp-2*komis;
                    if (vr10>0){
                        vigoda=vigoda+vr10;
                        System.out.println("vr10" + i +" "+j+" "+vr10);
                    }

                    float vr11= -optionSale[i].intrinsicPriceUp+ optionSale[j].intrinsicPriceDown-2*komis;
                    if (vr11>0){
                        vigoda=vigoda+vr11;
                        System.out.println("vr11" + i +" "+j+" "+vr11);
                    }

                }
            }



        }



    }
}
