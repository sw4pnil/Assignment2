package com.test.assignment.util;

import java.lang.System;

/**
 * @author swapnil-tml on 26-06-2020.
 * horizont dotted progress...
 */
@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001:\u0001\u001bB\u0011\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\u0002\u0010\u0004B\u001b\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u00a2\u0006\u0002\u0010\u0007B#\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\b\u001a\u00020\t\u00a2\u0006\u0002\u0010\nJ\u0018\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J\b\u0010\u0015\u001a\u00020\u0010H\u0014J\u0010\u0010\u0016\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0014J\u0018\u0010\u0017\u001a\u00020\u00102\u0006\u0010\u0018\u001a\u00020\t2\u0006\u0010\u0019\u001a\u00020\tH\u0014J\b\u0010\u001a\u001a\u00020\u0010H\u0002R\u000e\u0010\u000b\u001a\u00020\tX\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\tX\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\tX\u0082D\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001c"}, d2 = {"Lcom/test/assignment/util/HorizontalDottedProgress;", "Landroid/view/View;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "mBounceDotRadius", "mDotAmount", "mDotPosition", "mDotRadius", "createDot", "", "canvas", "Landroid/graphics/Canvas;", "paint", "Landroid/graphics/Paint;", "onAttachedToWindow", "onDraw", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "startAnimation", "BounceAnimation", "app_debug"})
public final class HorizontalDottedProgress extends android.view.View {
    private final int mDotRadius = 5;
    private final int mBounceDotRadius = 8;
    private int mDotPosition = 0;
    private final int mDotAmount = 10;
    private java.util.HashMap _$_findViewCache;
    
    @java.lang.Override()
    protected void onDraw(@org.jetbrains.annotations.NotNull()
    android.graphics.Canvas canvas) {
    }
    
    @java.lang.Override()
    protected void onAttachedToWindow() {
    }
    
    private final void createDot(android.graphics.Canvas canvas, android.graphics.Paint paint) {
    }
    
    @java.lang.Override()
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
    }
    
    private final void startAnimation() {
    }
    
    public HorizontalDottedProgress(@org.jetbrains.annotations.Nullable()
    android.content.Context context) {
        super(null);
    }
    
    public HorizontalDottedProgress(@org.jetbrains.annotations.Nullable()
    android.content.Context context, @org.jetbrains.annotations.Nullable()
    android.util.AttributeSet attrs) {
        super(null);
    }
    
    public HorizontalDottedProgress(@org.jetbrains.annotations.Nullable()
    android.content.Context context, @org.jetbrains.annotations.Nullable()
    android.util.AttributeSet attrs, int defStyleAttr) {
        super(null);
    }
    
    @kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0014\u00a8\u0006\t"}, d2 = {"Lcom/test/assignment/util/HorizontalDottedProgress$BounceAnimation;", "Landroid/view/animation/Animation;", "(Lcom/test/assignment/util/HorizontalDottedProgress;)V", "applyTransformation", "", "interpolatedTime", "", "t", "Landroid/view/animation/Transformation;", "app_debug"})
    final class BounceAnimation extends android.view.animation.Animation {
        
        @java.lang.Override()
        protected void applyTransformation(float interpolatedTime, @org.jetbrains.annotations.NotNull()
        android.view.animation.Transformation t) {
        }
        
        public BounceAnimation() {
            super();
        }
    }
}