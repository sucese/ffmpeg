package com.guoxiaoxing.recyclerview.swipeable;

import android.annotation.TargetApi;
import android.os.Build;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.guoxiaoxing.recyclerview.swipeable.action.SwipeResultAction;
import com.guoxiaoxing.recyclerview.swipeable.adapter.BaseSwipeableItemAdapter;
import com.guoxiaoxing.recyclerview.swipeable.adapter.SwipeableItemAdapter;

public class SwipeableHelper {

    @TargetApi(Build.VERSION_CODES.KITKAT)
    public static void clearViewPropertyAnimatorUpdateListener(View view) {
        view.animate().setUpdateListener(null);
    }

    @SuppressWarnings("unchecked")
    public static SwipeResultAction invokeOnSwipeItem(
            BaseSwipeableItemAdapter<?> adapter, RecyclerView.ViewHolder holder, int position, int result) {
        return ((SwipeableItemAdapter) adapter).onSwipeItem(holder, position, result);
    }

    @SuppressWarnings("PointlessBitwiseExpression")
    public static int extractLeftReaction(int type) {
        return ((type >>> SwipeableInternalConstants.BIT_SHIFT_AMOUNT_LEFT) & SwipeableInternalConstants.REACTION_CAPABILITY_MASK);
    }

    public static int extractUpReaction(int type) {
        return ((type >>> SwipeableInternalConstants.BIT_SHIFT_AMOUNT_UP) & SwipeableInternalConstants.REACTION_CAPABILITY_MASK);
    }

    public static int extractRightReaction(int type) {
        return ((type >>> SwipeableInternalConstants.BIT_SHIFT_AMOUNT_RIGHT) & SwipeableInternalConstants.REACTION_CAPABILITY_MASK);
    }

    public static int extractDownReaction(int type) {
        return ((type >>> SwipeableInternalConstants.BIT_SHIFT_AMOUNT_DOWN) & SwipeableInternalConstants.REACTION_CAPABILITY_MASK);
    }

    public static boolean canSwipeLeft(int reactionType) {
        return (extractLeftReaction(reactionType) == SwipeableInternalConstants.REACTION_CAN_SWIPE);
    }

    public static boolean canSwipeUp(int reactionType) {
        return (extractUpReaction(reactionType) == SwipeableInternalConstants.REACTION_CAN_SWIPE);
    }

    public static boolean canSwipeRight(int reactionType) {
        return (extractRightReaction(reactionType) == SwipeableInternalConstants.REACTION_CAN_SWIPE);
    }

    public static boolean canSwipeDown(int reactionType) {
        return (extractDownReaction(reactionType) == SwipeableInternalConstants.REACTION_CAN_SWIPE);
    }
}
