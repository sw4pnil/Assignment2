package com.test.assignment.adapters;

import java.lang.System;

/**
 * @author swapnil-tml on 26-06-2020.
 * ViewHolder for Country List items
 */
@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\u0002\u0010\u0007J\u0012\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0004H\u0016R\u0012\u0010\b\u001a\u00020\t8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0012\u0010\n\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u0012\u0010\u0010\u001a\u00020\t8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0014"}, d2 = {"Lcom/test/assignment/adapters/CountryDetailViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Landroid/view/View$OnClickListener;", "itemView", "Landroid/view/View;", "onCountryListener", "Lcom/test/assignment/adapters/OnCountryClickListener;", "(Landroid/view/View;Lcom/test/assignment/adapters/OnCountryClickListener;)V", "description", "Landroid/widget/TextView;", "image", "Landroidx/appcompat/widget/AppCompatImageView;", "getOnCountryListener", "()Lcom/test/assignment/adapters/OnCountryClickListener;", "setOnCountryListener", "(Lcom/test/assignment/adapters/OnCountryClickListener;)V", "title", "onClick", "", "v", "app_debug"})
public final class CountryDetailViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder implements android.view.View.OnClickListener {
    @org.jetbrains.annotations.NotNull()
    public android.widget.TextView title;
    @org.jetbrains.annotations.NotNull()
    public android.widget.TextView description;
    @org.jetbrains.annotations.NotNull()
    public androidx.appcompat.widget.AppCompatImageView image;
    @org.jetbrains.annotations.NotNull()
    private com.test.assignment.adapters.OnCountryClickListener onCountryListener;
    
    @java.lang.Override()
    public void onClick(@org.jetbrains.annotations.Nullable()
    android.view.View v) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.test.assignment.adapters.OnCountryClickListener getOnCountryListener() {
        return null;
    }
    
    public final void setOnCountryListener(@org.jetbrains.annotations.NotNull()
    com.test.assignment.adapters.OnCountryClickListener p0) {
    }
    
    public CountryDetailViewHolder(@org.jetbrains.annotations.NotNull()
    android.view.View itemView, @org.jetbrains.annotations.NotNull()
    com.test.assignment.adapters.OnCountryClickListener onCountryListener) {
        super(null);
    }
}