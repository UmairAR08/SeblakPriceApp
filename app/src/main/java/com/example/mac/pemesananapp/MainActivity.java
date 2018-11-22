package com.example.mac.pemesananapp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.NumberFormat;

import static android.R.string.no;
import static android.os.Build.VERSION_CODES.N;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {

    int quantity=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void increment(View view){//perintah tombol tambah
        if(quantity==100){
            Toast.makeText(this,"pesanan maximal 100",Toast.LENGTH_SHORT).show();
            return;
        }
        quantity = quantity+1 ;
        display(quantity);
    }
    public void decrement(View view){//perintah tombol tambah
        if (quantity==1){
            Toast.makeText(this,"pesanan minimal 1",Toast.LENGTH_SHORT).show();
            return;
        }
        quantity = quantity -1;
        display(quantity);
    }


    public void Submitorder(View view) {
        EditText nameEditText=(EditText)findViewById(R.id.edt_name);
        String name=nameEditText.getText().toString();
        Log.v("MainActivity","Nama:"+name);

        CheckBox SeblakChekBox= (CheckBox) findViewById(R.id.Seblak_checkbox);
        boolean hasseblak=SeblakChekBox.isChecked();//mengidentifikasi check
        Log.v("MainActivity","has whippedcream:"+hasseblak);

        CheckBox SayuranChekBox= (CheckBox) findViewById(R.id.Sayuran_checkbox);
        boolean hassayuran=SayuranChekBox.isChecked();//mengidentifikasi check
        Log.v("MainActivity","has whippedcream:"+hassayuran);

        CheckBox telurChekBox= (CheckBox) findViewById(R.id.Telur_checkbox);
        boolean hastelur=telurChekBox.isChecked();//mengidentifikasi check
        Log.v("MainActivity","has whippedcream:"+hastelur);

        CheckBox MieChekBox= (CheckBox) findViewById(R.id.Mie_checkbox);
        boolean hasmie=MieChekBox.isChecked();//mengidentifikasi check
        Log.v("MainActivity","has whippedcream:"+hasmie);

        CheckBox BaksoChekBox= (CheckBox) findViewById(R.id.Bakso_checkbox);
        boolean hasbakso=BaksoChekBox.isChecked();//mengidentifikasi check
        Log.v("MainActivity","has whippedcream:"+hassayuran);

        CheckBox SosisChekBox= (CheckBox) findViewById(R.id.Sosis_checkbox);
        boolean hassosis=SosisChekBox.isChecked();//mengidentifikasi check
        Log.v("MainActivity","has whippedcream:"+hassosis);

        CheckBox makaroniChekBox= (CheckBox) findViewById(R.id.Makaroni_checkbox);
        boolean hasmakaroni=makaroniChekBox.isChecked();//mengidentifikasi check
        Log.v("MainActivity","has whippedcream:"+hasmakaroni);

        CheckBox cekerChekBox= (CheckBox) findViewById(R.id.Ceker_checkbox);
        boolean hasceker=cekerChekBox.isChecked();//mengidentifikasi check
        Log.v("MainActivity","has whippedcream:"+hasceker);

        CheckBox KejuChekBox= (CheckBox) findViewById(R.id.Keju_checkbox);
        boolean haskeju=KejuChekBox.isChecked();//mengidentifikasi check
        Log.v("MainActivity","has whippedcream:"+haskeju);


        int price=calculateprice(hasseblak,
                hassayuran,
                hastelur,
                hasmie,
                hasbakso,
                hassosis,
                hasmakaroni,
                hasceker,
                haskeju);
        String pricemessage=createOrderSummary(price,name,hasseblak,
                hassayuran,
                hastelur,
                hasmie,
                hasbakso,
                hassosis,
                hasmakaroni,
                hasceker,
                haskeju);


        displayMessage(pricemessage);

    }
    private int calculateprice(boolean addseblak,
                               boolean addsayuran,
                               boolean addtelur,
                               boolean addmie,
                               boolean addbakso,
                               boolean addsosis,
                               boolean addmakaroni,
                               boolean addceker,
                               boolean addkeju){
        int harga=0;

        if(addseblak){
            harga=harga+6000;
        }

        if (addsayuran){
            harga=harga+2000;
        }

        if (addtelur) {
            harga=harga+3000;
        }

        if (addbakso) {
            harga=harga+2000;
        }

        if (addsosis) {
            harga=harga+2000;
        }

        if (addmie) {
            harga=harga+4000;
        }

        if (addmakaroni) {
            harga=harga+2000;
        }

        if (addkeju) {
            harga=harga+2000;
        }

        if (addceker) {
            harga=harga+2000;
        }


        return quantity * harga;
    }
    private String createOrderSummary(int price, String name,
                                      boolean addCeker,
                                      boolean addTelur,
                                      boolean addBakso,
                                      boolean addSosis,
                                      boolean addSeblak,
                                      boolean addMie,
                                      boolean addMakaroni,
                                      boolean makesayuran,
                                      boolean addKeju) {//hasil pemesanan
        String pricemessage=" Nama ="+name;
        pricemessage+="\n Seblak?"+addSeblak;
        pricemessage+="\n Tambah Sayuran?"+makesayuran;
        pricemessage+="\n Tambah Sosis?"+addSosis;
        pricemessage+="\n Tambah Ceker?"+addCeker;
        pricemessage+="\n Tambah Telur?"+addTelur;
        pricemessage+="\n Tambah Mie?"+addMie;
        pricemessage+="\n Tambah Bakso?"+addBakso;
        pricemessage+="\n Tambah Makaroni?"+addMakaroni;
        pricemessage+="\n Tambah Keju?"+addKeju;
        pricemessage+="\n quantity"+quantity;
        pricemessage+="\n Total Rp"+price;
        pricemessage+="\n Thankyou";
        return  pricemessage;
    }

    //method ini untuk mencetak hasil perintah yang di tampilkan dengan inisial quantity_textview di textview 0
    private void displayMessage(String message) {
        TextView priceTextView = (TextView) findViewById(R.id.price_textview);
        priceTextView.setText(message);
    }
    private void display(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_textview);
        quantityTextView.setText("" + number);
    }
    private void displayPrice(int number) {
        TextView priceTextView = (TextView) findViewById(R.id.price_textview);
        priceTextView.setText(NumberFormat.getCurrencyInstance().format(number));
    }

}
