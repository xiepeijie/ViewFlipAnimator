# ViewFlipAnimator
一种超简单纯Java实现的卡片翻转效果
# Snapshot
<img src="https://github.com/xiepeijie/ViewFlipAnimator/blob/master/flip-snapshot.gif" width="320x">
# Java Code
```
    /**
     * 水平翻转
     * @param view target
     * @param duration time
     * @param direction 只能传1或-1，1为从右开始翻转，-1位从左开始翻转
     * @return 动画集合
     */
    public static AnimatorSet flip(View view, int duration, int direction) {
        if (direction != 1 && direction != -1) direction = 1;
        view.setCameraDistance(16000*view.getResources().getDisplayMetrics().density);
        AnimatorSet animSet = new AnimatorSet();
        ObjectAnimator rotationY = new ObjectAnimator();
        rotationY.setDuration(duration).setPropertyName("rotationY");
        rotationY.setFloatValues(0, 90*direction);
        ObjectAnimator _rotationY = new ObjectAnimator();
        _rotationY.setDuration(duration).setPropertyName("rotationY");
        _rotationY.setFloatValues(-90*direction, 0);
        _rotationY.setStartDelay(duration);
        ObjectAnimator scale = new ObjectAnimator();
        scale.setDuration(duration).setPropertyName("scaleY");
        scale.setFloatValues(1, 0.94f);
        ObjectAnimator _scale = new ObjectAnimator();
        _scale.setDuration(duration).setPropertyName("scaleY");
        _scale.setFloatValues(0.94f, 1);
        _scale.setStartDelay(duration);
        animSet.setTarget(view);
        rotationY.setTarget(view);
        _rotationY.setTarget(view);
        scale.setTarget(view);
        _scale.setTarget(view);
        animSet.playTogether(rotationY, _rotationY, scale, _scale);
        animSet.start();
        return animSet;
    }
```
# About me
微博：[@萧雾宇](http://weibo.com/payge)  
Gmail：xiepeijieapp@gmail.com
