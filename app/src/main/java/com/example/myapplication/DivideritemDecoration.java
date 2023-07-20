package com.example.myapplication;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.TypedValue;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class DivideritemDecoration extends RecyclerView.ItemDecoration {
    private final int dividerHeight;
    private final Paint dividerPaint;

    public DivideritemDecoration(Context context, int dividerHeightInPixels) {
        // Chuyển đổi từ dp sang pixel để giảm độ dày
        dividerHeight = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 1, context.getResources().getDisplayMetrics());
        dividerPaint = new Paint();
        dividerPaint.setColor(Color.BLACK); // Màu đen
        dividerPaint.setStrokeWidth(dividerHeight); // Độ dày của thanh ngăn cách
    }

    @Override
    public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
        super.getItemOffsets(outRect, view, parent, state);
        if (parent.getChildAdapterPosition(view) != parent.getAdapter().getItemCount() - 1) {
            outRect.bottom = dividerHeight;
        }
    }

    @Override
    public void onDraw(@NonNull Canvas c, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
        int childCount = parent.getChildCount();
        int width = parent.getWidth();

        for (int i = 0; i < childCount - 1; i++) {
            View child = parent.getChildAt(i);
            int top = child.getBottom();
            int bottom = top + dividerHeight / 2; // Để thanh ngăn cách mỏng hơn, chỉ lấy một nửa chiều cao

            // Draw the divider line
            c.drawLine(0, bottom, width, bottom, dividerPaint);
        }
    }
}
