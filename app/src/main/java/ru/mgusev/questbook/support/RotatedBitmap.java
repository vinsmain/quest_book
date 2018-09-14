package ru.mgusev.questbook.support;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;

public class RotatedBitmap {

    public static Bitmap getBitmap(Bitmap bitmap, int angle) {
        Matrix matrix = new Matrix();
        matrix.postRotate(angle);

        Rect srcR = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
        RectF dstR = new RectF(0, 0, bitmap.getWidth(), bitmap.getHeight());
        RectF deviceR = new RectF();
        matrix.mapRect(deviceR, dstR);

        int newWeight = Math.round(deviceR.width());
        int newHeight = Math.round(deviceR.height());

        Bitmap result = Bitmap.createBitmap(newWeight, newHeight, Bitmap.Config.ARGB_8888);
        result.eraseColor(Color.TRANSPARENT);
        Canvas canvas = new Canvas();
        canvas.translate(-deviceR.left, -deviceR.top);
        canvas.concat(matrix);

        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setFilterBitmap(true);
        canvas.setBitmap(result);
        canvas.drawBitmap(bitmap, srcR, dstR, paint);
        canvas.setBitmap(null);

        return result;
    }
}
