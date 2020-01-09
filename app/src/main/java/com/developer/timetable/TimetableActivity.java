package com.developer.timetable;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class TimetableActivity extends AppCompatActivity {

    private RecyclerView recyclerView;

    private List<CardItem> cardItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.hasFixedSize();
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        cardItems = new ArrayList<>();

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        RecyclerView.Adapter adapter = new MyAdapter(cardItems, this);
        recyclerView.setAdapter(adapter);

        addJSON();
    }

    private void addJSON(){
        try {
            String json = readJSONFile();
            JSONArray jsonArray = new JSONArray(json);

            for(int i = 0; i<jsonArray.length(); i++){
                JSONObject obj = jsonArray.getJSONObject(i);

                if(obj.getInt("day") == 1) {
                    String name = obj.getString("name");
                    String teacher = obj.getString("teacher");
                    CardItem cardItem = new CardItem(name, teacher);
                    cardItems.add(cardItem);
                }
            }
        } catch (IOException | JSONException e) {
            Log.e(TimetableActivity.class.getName(), "Unable to process JSON File", e);
        }
    }

    private String readJSONFile() throws IOException{
        InputStream inputStream = null;
        StringBuilder builder = new StringBuilder();

        try {
            String jsonData = null;
            inputStream = getAssets().open("timetable.json");
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
            while((jsonData = bufferedReader.readLine()) != null)
                builder.append(jsonData);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(inputStream != null){
                inputStream.close();
            }
        }

        return new String(builder);

    }
}
