package com.coderfaysal.dowa;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {


    RecyclerView recyclerView;
    ArrayList<HashMap<String, String>> arrayList = new ArrayList<>();
    HashMap<String, String> hashMap;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recycleView);


        hashMap = new HashMap<>();
        hashMap.put("title", "ঋণ মুক্তির দোয়া");
        hashMap.put("message", "আরবি উচ্চারণ : আল্লাহুম্মাকফিনি বিহালালিকা আন হারামিকা, ওয়া আগনিনি বিফাদলিকা আম্মান সিওয়াক। \n" +
                "\n" +
                "অর্থ : হে আল্লাহ! তোমার হালাল দ্বারা আমাকে হারাম থেকে দূরে রাখ এবং তোমার দয়ায় তুমি ভিন্ন অপরের মুখাপেক্ষী হওয়া থেকে স্বনির্ভর কর। (তিরমিজি ও বায়হাকি)");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("title", "কঠিন কাজ সহজ হওয়ার দোয়া:");
        hashMap.put("message", "আরবি উচ্চারণ : আল্লাহুম্মা লা-সাহলা ইল্লা মা জায়ালতাহু সাহলান, ওয়া আনতা তাজআলুল হুজনা সাহলান ইজা শিইতা। \n" +
                "\n" +
                "অর্থ : ‘হে আল্লাহ, আপনি যা সহজ করে দেন তা ছাড়া কোনো কিছুই সহজ নেই। আর আপনি চাইলে পেরেশানিযুক্ত কাজও সহজ করে দেন।’ (সহিহ ইবনে হিব্বান: ৯৭৪)");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("title", "অযুর দোয়াঃ");
        hashMap.put("message", "বাংলা উচ্চারণঃ বিসমিল্লাহিল আলিয়্যিল আজীম। ওয়াল হামদুলিল্লাহি আলা দ্বীনিল ইসলাম। আল ইসলামু হাক্কুন। ওয়াল কুফরু বাতিলুন। ওয়াল ইসলামু নুরুন। ওয়াল কুফরু জুলমাত। \n" +
                "\n" +
                "বাংলা অর্থঃ সর্বশ্রেষ্ঠ, সর্বমহান আল্লাহর নামে অজু শুরু করছি।");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("title", "দুই সিজদার মাঝের দোয়া-");
        hashMap.put("message", "উচ্চারণ:- আল্লা-হুম্মাগফিরলী অরহামনী অজবুরনী অরফা’নী অহ্দিনী ওয়া আ-ফিনী অরযুক্বনী। \n" +
                "\n" +
                "অর্থ- হে আল্লাহ! আমাকে ক্ষমা কর, দয়া কর, আমার প্রয়োজন মিটাও, আমাকে উঁচু কর, পথ দেখাও, নিরাপত্তা দাও এবং জীবিকা দান কর। (আবূদাঊদ-৮৫০, তিরমিযী-২৮৪, ইবনে মাজাহ্-৮৯৮,হাকেম, মুস্তাদরাক)\n");
        arrayList.add(hashMap);


        XAdapter xAdapter = new XAdapter();
        recyclerView.setAdapter(xAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));


    }


    private class XAdapter extends RecyclerView.Adapter<XAdapter.XViewHolder>{


        @NonNull
        @Override
        public XViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            LayoutInflater inflater = getLayoutInflater();
            View view = inflater.inflate(R.layout.items, parent, false );
            return new XViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull XViewHolder holder, int position) {

            hashMap = arrayList.get(position);
            String title = hashMap.get("title");
            String message = hashMap.get("message");

            holder.textView.setText(title);

            holder.cardView.setOnClickListener(view -> {
                Details.TITLE = title;
                Details.MESSAGE = message;
                startActivity(new Intent(MainActivity.this, Details.class));
            });


        }

        @Override
        public int getItemCount() {
            return arrayList.size();
        }

        private class XViewHolder extends RecyclerView.ViewHolder{

            TextView textView;
            CardView cardView;

            public XViewHolder(@NonNull View itemView) {
                super(itemView);

                textView = itemView.findViewById(R.id.textView);
                cardView = itemView.findViewById(R.id.cardView);
            }
        }

    }






}