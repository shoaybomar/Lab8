package com.example.lab8;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Setup your Toolbar and NavigationDrawer here
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.choice1:
                showToast("You clicked on item 1");
                return true;
            case R.id.choice2:
                showToast("You clicked on item 2");
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        // Handle NavigationDrawer item clicks
        switch (item.getItemId()) {
            case R.id.nav_home:
                // Already on MainActivity
                break;
            case R.id.nav_dad_joke:
                startActivity(new Intent(this, DadJokeActivity.class));
                finish();
                break;
            case R.id.nav_exit:
                finishAffinity();
                break;
        }

        // Close the NavigationDrawer after an item is selected
        // DrawerLayout drawer = findViewById(R.id.drawer_layout);
        // drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}