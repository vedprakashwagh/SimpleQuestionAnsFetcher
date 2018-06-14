package com.vedprakashwagh.quizapp.view.SwipeableCards;

import android.content.Context;
import android.util.Log;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.mindorks.placeholderview.SwipePlaceHolderView;
import com.mindorks.placeholderview.annotations.Click;
import com.mindorks.placeholderview.annotations.Layout;
import com.mindorks.placeholderview.annotations.Resolve;
import com.mindorks.placeholderview.annotations.View;
import com.mindorks.placeholderview.annotations.swipe.SwipeCancelState;
import com.mindorks.placeholderview.annotations.swipe.SwipeIn;
import com.mindorks.placeholderview.annotations.swipe.SwipeInDirectional;
import com.mindorks.placeholderview.annotations.swipe.SwipeInState;
import com.mindorks.placeholderview.annotations.swipe.SwipeOutDirectional;
import com.mindorks.placeholderview.annotations.swipe.SwipeOutState;
import com.vedprakashwagh.quizapp.view.BouncyInterpolator;
import com.vedprakashwagh.quizapp.R;
import com.vedprakashwagh.quizapp.model.QuestionAnswerModel;

@Layout(R.layout.swipeable_question_cards)
public class SwipeableQuestionAnswer {
    @View(R.id.tv_question)
    private TextView question;

    @View(R.id.tv_answer)
    private TextView answer;

    @View(R.id.iv_next)
    private ImageView next;


    private QuestionAnswerModel model;
    private Context context;
    private SwipePlaceHolderView swiper;
    Animation myAnim;

    public SwipeableQuestionAnswer(QuestionAnswerModel model, Context context, SwipePlaceHolderView swiper) {
        this.model = model;
        this.context = context;
        this.swiper = swiper;
    }

    @Resolve
    private void onResolved() {

        myAnim = AnimationUtils.loadAnimation(context, R.anim.bounce);
        BouncyInterpolator interpolator = new BouncyInterpolator(0.2, 30);
        myAnim.setInterpolator(interpolator);
        question.setText(model.getQuestion());
        answer.setText(model.getAnswer());
    }

    @Click(R.id.iv_next)
    public void onClick() {

        next.startAnimation(myAnim);
        next.postOnAnimationDelayed(new Runnable() {
            @Override
            public void run() {
                swiper.doSwipe(true);
                next.clearAnimation();
            }
        },1000);
    }

    /*@SwipeOut
    private void onSwipedOut(){
        swiper.addView(this);
    }

    @SwipeIn
    private void onSwipedIn(){
        swiper.addView(this);
    }*/

    @SwipeCancelState
    private void onSwipeCancelState() {
        Log.d("EVENT", "onSwipeCancelState");
    }

    @SwipeIn
    private void onSwipeIn() {
        Log.d("EVENT", "onSwipedIn");
    }

    @SwipeInState
    private void onSwipeInState() {
        Log.d("EVENT", "onSwipeInState");
    }

    @SwipeOutState
    private void onSwipeOutState() {
        Log.d("EVENT", "onSwipeOutState");
    }

    @SwipeInDirectional
    private void onSwipeInDirectional() {

    }

    @SwipeOutDirectional
    private void onSwipeOutDirectional() {

    }
}
