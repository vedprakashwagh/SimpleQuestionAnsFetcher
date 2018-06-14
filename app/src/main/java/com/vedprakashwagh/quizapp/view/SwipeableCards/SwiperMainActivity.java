package com.vedprakashwagh.quizapp.view.SwipeableCards;

import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.budiyev.android.circularprogressbar.CircularProgressBar;
import com.mindorks.placeholderview.SwipeDecor;
import com.mindorks.placeholderview.SwipePlaceHolderView;
import com.vedprakashwagh.quizapp.controller.HttpHandler;
import com.vedprakashwagh.quizapp.R;
import com.vedprakashwagh.quizapp.model.QuestionAnswerModel;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import es.dmoral.toasty.Toasty;

public class SwiperMainActivity extends AppCompatActivity implements View.OnClickListener, SwipeRefreshLayout.OnRefreshListener {
    SwipePlaceHolderView swiper;
    CircularProgressBar progressBar;
    private String url = "https://learncodeonline.in/api/android/datastructure.json";
    int jsonLength = 0;


    SwipeRefreshLayout refresh;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.swiper_main);
        swiper = findViewById(R.id.swiper_view);
        refresh = findViewById(R.id.srl_refresh);
        refresh.setOnRefreshListener(this);
        refresh.setSize(10);
        ImageView ad = findViewById(R.id.iv_ad);
        ad.setOnClickListener(this);
        swiper.getBuilder()
                .setDisplayViewCount(3)
                .setSwipeDecor(new SwipeDecor()
                        .setPaddingTop(20)
                        .setRelativeScale(0.01f)
                        .isAnimateScale(true)
                );
        new GetQuestions().execute();
    }

    @Override
    public void onRefresh() {
        new GetQuestions().execute();
        Log.d("refreshed", "The data was refreshed");
    }


    private class GetQuestions extends AsyncTask<Void, Void, Void> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            progressBar = findViewById(R.id.progress_bar);
        }

        @Override
        protected Void doInBackground(Void... arg0) {
            HttpHandler sh = new HttpHandler();

            String jsonStr = sh.makeServiceCall(url);


            if (jsonStr != null) {
                try {
                    JSONObject jsonObj = new JSONObject(jsonStr);

                    JSONArray questions = jsonObj.getJSONArray("questions");
                    jsonLength = questions.length();
                    for (int i = 0; i < jsonLength; i++) {
                        JSONObject c = questions.getJSONObject(i);

                        String question = c.getString("question");
                        String answer = c.getString("Answer");

                        final QuestionAnswerModel temp = new QuestionAnswerModel();
                        temp.setQuestion(question);
                        temp.setAnswer(answer);
                        Log.d("question_answer", "Question:" + temp.getQuestion() + "Answer:" + temp.getAnswer());
                        runOnUiThread(new Runnable() {

                            @Override
                            public void run() {
                                SwipeableQuestionAnswer tempCard = new SwipeableQuestionAnswer(temp, SwiperMainActivity.this, swiper);
                                swiper.addView(tempCard);
                            }
                        });
                    }
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Toasty.success(getApplicationContext(), "Refreshed!").show();
                        }
                    });
                } catch (final JSONException e) {
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Toasty.error(getApplicationContext(), "JSON parsing error: " + e.getMessage()).show();
                        }
                    });

                }
            } else {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toasty.error(getApplicationContext(), "Couldn't fetch the data from server. Please check your connection!").show();
                    }
                });

            }

            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            super.onPostExecute(result);
            if (refresh.isRefreshing()) {
                refresh.setRefreshing(false);
            }
            progressBar.setAnimateProgress(false);
            progressBar.setVisibility(View.GONE);
        }

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.iv_ad:
                String url = "https://courses.learncodeonline.in";
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
                break;
        }
    }
}
