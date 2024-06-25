package com.example.patientdemo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Specialist extends AppCompatActivity {

    DrawerLayout drawerLayout;
    public static String UserName;

    RecyclerView docCards;
    RecyclerView.Adapter adapter;
    SpecialistAdapter.RecyclerViewClickListener listener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_specialist);

        drawerLayout = findViewById(R.id.drawer_layout);
        UserName = getIntent().getStringExtra("UserName");

        docCards = findViewById(R.id.docCards);
        docCards();
    }

    private void docCards() {
        docCards.setHasFixedSize(true);
        docCards.setLayoutManager(new LinearLayoutManager(this));

        ArrayList<com.example.patientdemo.SpecialistModel> CardLocations = new ArrayList<>();

        CardLocations.add(new SpecialistModel(R.drawable.cold_fever, "Beard and Eyebrow",
                "For styling your beard and eyebrow", "Trim, Shave, French, Shaping"));
        CardLocations.add(new SpecialistModel(R.drawable.covid, "Facial Specialist",
                "For Glowing and Clear Skin", "Acne, Oil Skin and Brightness Skin"));
        CardLocations.add(new SpecialistModel(R.drawable.cardiology, "Hair, Beard and Facial",
                "For Hair and beard styling", "Haircut, Beard set, Skin care"));
        CardLocations.add(new SpecialistModel(R.drawable.child_development, "Massage Specialist",
                "For make or feel body relax", "Thai, Full body,Stretching"));
        CardLocations.add(new SpecialistModel(R.drawable.ic_ent, "Hair Design specialist",
                "For Treating your Hair and color", "Hair Color, Treatment, Design"));


        listener = (v, position) -> {
            Intent intent = new Intent(getApplicationContext(), BarberList.class);
            intent.putExtra("title", CardLocations.get(position).getTitle());
            intent.putExtra("UserName", UserName);
            startActivity(intent);
        };
        adapter = new SpecialistAdapter(CardLocations, listener);
        docCards.setAdapter(adapter);
    }


    // ---------------------------- NAVIGATION BAR ---------------------------- //
    public void ClickMenu(View view) {
        CustomerDashboard.openDrawer(drawerLayout);
    }

    public void ClickLogo(View view) {
        CustomerDashboard.closeDrawer(drawerLayout);
    }

    public void ClickHome(View view) {
        CustomerDashboard.redirectActivity(this, CustomerDashboard.class);
    }

    public void ClickUpdateProfile(View view) {
        CustomerDashboard.redirectActivity(this, UpdateProfileCustomer.class);
    }

    public void ClickLogout(View view) {
        CustomerDashboard.logout(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        CustomerDashboard.closeDrawer(drawerLayout);
    }
    // ----------------------------------------------------------------------- //
}