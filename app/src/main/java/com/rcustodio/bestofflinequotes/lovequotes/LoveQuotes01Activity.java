package com.rcustodio.bestofflinequotes.lovequotes;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewStub;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.Toast;
import android.widget.Toolbar;

import com.rcustodio.bestofflinequotes.DashboardHomeActivity;
import com.rcustodio.bestofflinequotes.GridViewAdapter;
import com.rcustodio.bestofflinequotes.ListViewAdapter;
import com.rcustodio.bestofflinequotes.Product;
import com.rcustodio.bestofflinequotes.R;

import java.util.ArrayList;
import java.util.List;

public class LoveQuotes01Activity extends AppCompatActivity {

    private ViewStub stubGrid;
    private ViewStub stubList;
    private ListView listView;
    private GridView gridView;
    private ListViewAdapter listViewAdapter;
    private GridViewAdapter gridViewAdapter;
    private List<Product> productList;
    private int currentViewMode = 0;

    static final int VIEW_MODE_LISTVIEW = 0;
    static final int VIEW_MODE_GRIDVIEW = 1;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_love_quotes01);

        assert getSupportActionBar() != null;   //null check
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);   //show back button

        stubList = findViewById(R.id.stub_list);
        stubGrid = findViewById(R.id.stub_grid);

        stubList.inflate();
        stubGrid.inflate();

        listView = findViewById(R.id.mylistview);
        gridView = findViewById(R.id.mygridview);

        getProductList();

        SharedPreferences sharedPreferences = getSharedPreferences("ViewMode",MODE_PRIVATE);
        currentViewMode = sharedPreferences.getInt("currentViewMode",VIEW_MODE_LISTVIEW);

        listView.setOnItemClickListener(onItemClick);
        gridView.setOnItemClickListener(onItemClick);

        switchView();

    }



    private void switchView(){

        if(VIEW_MODE_LISTVIEW == currentViewMode){
            stubList.setVisibility(View.VISIBLE);
            stubGrid.setVisibility(View.GONE);
        }
        else {
            stubList.setVisibility(View.GONE);
            stubGrid.setVisibility(View.VISIBLE);
        }
        setAdapters();
    }

    public void setAdapters(){

        if(VIEW_MODE_LISTVIEW == currentViewMode){
            listViewAdapter = new ListViewAdapter(this,R.layout.list_item,productList);
            listView.setAdapter(listViewAdapter);
        }
        else {
            gridViewAdapter = new GridViewAdapter(this,R.layout.grid_item,productList);
            gridView.setAdapter(gridViewAdapter);
        }
    }

    public List<Product> getProductList(){

        productList = new ArrayList<>();

        productList.add(new Product(R.drawable.love_01,"True Love has a habit of coming back."));
        productList.add(new Product(R.drawable.love_02,"Hapiness means you"));
        productList.add(new Product(R.drawable.love_03,"I love my life because it gave me you,i love you because you are my life"));
        productList.add(new Product(R.drawable.love_04,"You are the love of my life, and the life of my love"));
        productList.add(new Product(R.drawable.love_05,"I want to be the only hand you ever need to hold"));
        productList.add(new Product(R.drawable.love_06,"You mean the world to me"));
        productList.add(new Product(R.drawable.love_07,"Every single day I love you more"));
        productList.add(new Product(R.drawable.love_08,"Let's meet in our dream tonight"));
        productList.add(new Product(R.drawable.love_09,"Can i borrow a kiss! Promiss i'll give it back"));
        productList.add(new Product(R.drawable.love_10,"I wanted to send you a hug"));

        return productList;
    }

    AdapterView.OnItemClickListener onItemClick = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

            Toast.makeText(getApplicationContext(),productList.get(i).getTitle(),Toast.LENGTH_LONG).show();
        }
    };

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()){
            case R.id.item_menu_1:
                if(VIEW_MODE_LISTVIEW == currentViewMode){
                    currentViewMode=VIEW_MODE_GRIDVIEW;
                }else {
                    currentViewMode=VIEW_MODE_LISTVIEW;
                }
                switchView();

                SharedPreferences sharedPreferences = getSharedPreferences("ViewMode",MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putInt("currentViewMode",currentViewMode);
                editor.commit();
                break;
                //Back button press
            case android.R.id.home:
                onBackPressed();
                break;
        }
        return true;
    }

    //    public void backpressed(View v)
//    {
//        onBackPressed();
//    }
}
