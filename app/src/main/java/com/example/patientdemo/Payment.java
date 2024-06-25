//package com.example.patientdemo;
//
//import android.app.Activity;
//import android.content.Intent;
//import android.os.Bundle;
//import android.util.Log;
//import android.view.View;
//import android.widget.Button;
//import android.widget.TextView;
//import android.widget.Toast;
//
//import androidx.appcompat.app.AlertDialog;
//import androidx.appcompat.app.AppCompatActivity;
//
//import com.google.firebase.database.DatabaseReference;
//import com.google.firebase.database.FirebaseDatabase;
//import com.razorpay.Checkout;
//import com.razorpay.PaymentResultListener;
//
//import org.json.JSONObject;
//
//import java.util.Timer;
//import java.util.TimerTask;
//
//public class Payment extends AppCompatActivity implements PaymentResultListener {
//
//    Button Sbtn, Fbtn;
//    TextView PayStatus;
//    private DatabaseReference ref1, ref2;
//
////    Timer timer;
////    String sItem;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_payment);
//
//        Checkout.preload(getApplicationContext());
//
////        sItem = getIntent().getExtras().getString("slot");
////        String msg = getIntent().getExtras().getString("msg");
////        String dr_name = getIntent().getExtras().getString("dr_name");
////        String dr_price = getIntent().getExtras().getString("dr_price");
//
//        Sbtn = findViewById(R.id.complete_payment);
//        Fbtn = findViewById(R.id.cancel_payment);
//        PayStatus = findViewById(R.id.pay_status);
//
//        //payement rozarpay
//        Sbtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                PaymentNow("15000");
//            }
//        });
//// yaha tak changehua
//
//
//
////        ref1 = FirebaseDatabase.getInstance().getReference("barbers").child(dr_name);
////
////        ref2 = FirebaseDatabase.getInstance().getReference("customers").child(CustomerDashboard.UserName).child("active_app");
////
////        Sbtn.setOnClickListener(v -> {
////            ref1.child("slots").child(sItem).setValue("Booked");
////
////            ref1.child("my_app").child(sItem).child("patient").setValue(CustomerDashboard.UserName);
////            ref1.child("my_app").child(sItem).child("remarks").setValue(msg);
////            ref1.child("my_app").child(sItem).child("slot").setValue(sItem);
////
////            ref2.child(dr_name + sItem).child("name").setValue(dr_name);
////            ref2.child(dr_name + sItem).child("time").setValue(sItem);
////            ref2.child(dr_name + sItem).child("price").setValue(dr_price);
////            ref2.child(dr_name + sItem).child("remarks").setValue(msg);
////            //ref2.child(dr_name + sItem).child("image").setValue("https://firebasestorage.googleapis.com/v0/b/my-application-6d359.appspot.com/o/images%2Fkakashi.jpg?alt=media&token=348a2050-641e-44f8-9c3f-80c740c917a3");
////
////            timer.cancel();
////            Toast.makeText(this, "Payment Done", Toast.LENGTH_SHORT).show();
////            Intent intent = new Intent(getApplicationContext(), ActiveAppointments.class);
////            startActivity(intent);
////            finish();
////        });
////
////        Fbtn.setOnClickListener(v -> {
////            onBackPressed();
////        });
////
////        timer = new Timer();
////        timer.schedule(new TimerTask() {
////            @Override
////            public void run() {
////                Intent intent = new Intent(getApplicationContext(), CustomerDashboard.class);
////                intent.putExtra("UserName", CustomerDashboard.UserName);
////                ref1.child("slots").child(sItem).setValue("Available");
////                startActivity(intent);
////                finish();
////            }
////        }, 5000*60);
//    }
//
//    //new
//    private void PaymentNow(String amount){
//        final Activity activity = this;
//
//        Checkout checkout = new Checkout();
//        checkout.setKeyID("rzp_test_W4wxrFkGOp8jgS");
//        checkout.setImage(R.drawable.ic_alert);
//
//        double finalAmount = Float.parseFloat(amount)*100;
//
//        try {
//            JSONObject options = new JSONObject();
//            options.put("name", "Barber");
//            options.put("description", "Reference No. #12345");
//            options.put("image", "H:\\DocOnline-master\\app\\src\\main\\res\\drawable-v24\\home.png");
//            options.put("theme.color", " #000000");
//            options.put("currency", "INR");
//            options.put("prefill.email", "barber.shop@example.com");
//            options.put("prefill.contact", "9110078454");
//
//            checkout.open(activity, options);
//
//        }catch (Exception e){
//            Log.e("TAG", "Error in starting Razorpay",e);
//        }
//    }
//
//    //idhar
//
////    @Override
////    public void onBackPressed() {
////        AlertDialog.Builder dialog = new AlertDialog.Builder(this);
////        dialog.setTitle("Cancel Payment");
////        dialog.setMessage("Do you want to cancel Payment?");
////
////        sItem = getIntent().getExtras().getString("slot");
////        dialog.setPositiveButton("Yes", (dialog1, which) -> {
////            ref1.child("slots").child(sItem).setValue("Available");
////            Intent intent = new Intent(getApplicationContext(), CustomerDashboard.class);
////            intent.putExtra("UserName", CustomerDashboard.UserName);
////            startActivity(intent);
////            finish();
////        });
////
////        dialog.setNegativeButton("No", (dialog12, which) -> {
////        });
////
////        dialog.show();
////    }
//
//    @Override
//    protected void onDestroy() {
//        super.onDestroy();
//    }
//
//
//    // new implement
//    @Override
//    public void onPaymentSuccess(String s) {
//        Toast.makeText(getApplicationContext(), "Payment Success!",Toast.LENGTH_SHORT).show();
//        PayStatus.setText(s);
//    }
//
//    @Override
//    public void onPaymentError(int i, String s) {
//        Toast.makeText(getApplicationContext(), "Payment Failure",Toast.LENGTH_SHORT).show();
//        PayStatus.setText(s);
//    }
//}

package com.example.patientdemo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.razorpay.Checkout;
import com.razorpay.PaymentResultListener;

import org.json.JSONObject;

public class Payment extends AppCompatActivity implements PaymentResultListener {

    Button Sbtn, Fbtn;
    TextView PayStatus;
    private DatabaseReference ref1, ref2;

    String sItem, msg, dr_name, dr_price;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);

        Checkout.preload(getApplicationContext());

        // Retrieve data from intent
        sItem = getIntent().getExtras().getString("slot");
        msg = getIntent().getExtras().getString("msg");
        dr_name = getIntent().getExtras().getString("dr_name");
        dr_price = getIntent().getExtras().getString("dr_price");

        Sbtn = findViewById(R.id.complete_payment);
        Fbtn = findViewById(R.id.cancel_payment);
        PayStatus = findViewById(R.id.pay_status);

        ref1 = FirebaseDatabase.getInstance().getReference("barbers").child(dr_name);
        ref2 = FirebaseDatabase.getInstance().getReference("customers").child(CustomerDashboard.UserName).child("active_app");

        Sbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PaymentNow("50");
            }
        });

        Fbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
    }

    private void PaymentNow(String amount) {
        final Activity activity = this;

        Checkout checkout = new Checkout();
        checkout.setKeyID("rzp_test_W4wxrFkGOp8jgS");
        checkout.setImage(R.drawable.ic_alert);

        double finalAmount = Double.parseDouble(amount) * 100; // Convert to paise

        try {
            JSONObject options = new JSONObject();
            options.put("name", "Barber");
            options.put("description", "Reference No. #12345");
            options.put("image", "https://example.com/your_image_url"); // Use a valid image URL
            options.put("theme.color", "#000000");
            options.put("currency", "INR");
            options.put("amount", finalAmount); // Amount in paise
            options.put("prefill.email", "barber.shop@example.com");
            options.put("prefill.contact", "9110078454");

            checkout.open(activity, options);
        } catch (Exception e) {
            Log.e("PaymentError", "Error in starting Razorpay", e);
        }
    }

    @Override
    public void onPaymentSuccess(String s) {
        Toast.makeText(getApplicationContext(), "Payment Success!", Toast.LENGTH_SHORT).show();
        PayStatus.setText(s);

        // Update Firebase database
        ref1.child("slots").child(sItem).setValue("Booked");
        ref1.child("my_app").child(sItem).child("patient").setValue(CustomerDashboard.UserName);
        ref1.child("my_app").child(sItem).child("remarks").setValue(msg);
        ref1.child("my_app").child(sItem).child("slot").setValue(sItem);

        ref2.child(dr_name + sItem).child("name").setValue(dr_name);
        ref2.child(dr_name + sItem).child("time").setValue(sItem);
        ref2.child(dr_name + sItem).child("price").setValue(dr_price);
        ref2.child(dr_name + sItem).child("remarks").setValue(msg);

        // Navigate to ActiveAppointments
        Intent intent = new Intent(getApplicationContext(), ActiveAppointments.class);
        startActivity(intent);
        finish();
    }

    @Override
    public void onPaymentError(int code, String response) {
        Log.e("PaymentError", "Code: " + code + " | Response: " + response);
        Toast.makeText(getApplicationContext(), "Payment Failure: " + response, Toast.LENGTH_SHORT).show();
        PayStatus.setText(response);
    }
}


