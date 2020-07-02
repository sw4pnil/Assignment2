package com.test.assignment.viewmodels;

import java.lang.System;

/**
 * @author swapnil-tml on 26-06-2020.
 * view model for list data handling
 */
@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB\u0005\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\u0014\u001a\u00020\u0015J\u0006\u0010\u0016\u001a\u00020\rJ\u0006\u0010\u0017\u001a\u00020\u0015J\u000e\u0010\u0018\u001a\u00020\u00152\u0006\u0010\u0019\u001a\u00020\rR!\u0010\u0003\u001a\u0012\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0018\u00010\u00048F\u00a2\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u001b\u0010\t\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\n\u0018\u00010\u00048F\u00a2\u0006\u0006\u001a\u0004\b\u000b\u0010\bR\u001a\u0010\f\u001a\u00020\rX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\rX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001b"}, d2 = {"Lcom/test/assignment/viewmodels/CountryListViewModel;", "Landroidx/lifecycle/ViewModel;", "()V", "categoryList", "Landroidx/lifecycle/LiveData;", "", "Lcom/test/assignment/models/Country;", "getCategoryList", "()Landroidx/lifecycle/LiveData;", "countryName", "", "getCountryName", "isViewingRecipes", "", "()Z", "setViewingRecipes", "(Z)V", "mCountryRepository", "Lcom/test/assignment/repositories/CountryRepository;", "mIsPerformingQuery", "countryDetail", "", "onBackPressed", "searchNextPage", "setIsPerformingQuery", "isPerformingQuery", "Companion", "app_debug"})
public final class CountryListViewModel extends androidx.lifecycle.ViewModel {
    private final com.test.assignment.repositories.CountryRepository mCountryRepository = null;
    private boolean isViewingRecipes = false;
    private boolean mIsPerformingQuery;
    private static final java.lang.String TAG = "CountryListViewModel";
    public static final com.test.assignment.viewmodels.CountryListViewModel.Companion Companion = null;
    
    public final boolean isViewingRecipes() {
        return false;
    }
    
    public final void setViewingRecipes(boolean p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final androidx.lifecycle.LiveData<java.util.List<com.test.assignment.models.Country>> getCategoryList() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final androidx.lifecycle.LiveData<java.lang.String> getCountryName() {
        return null;
    }
    
    public final void countryDetail() {
    }
    
    public final void setIsPerformingQuery(boolean isPerformingQuery) {
    }
    
    public final boolean onBackPressed() {
        return false;
    }
    
    public final void searchNextPage() {
    }
    
    public CountryListViewModel() {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0005"}, d2 = {"Lcom/test/assignment/viewmodels/CountryListViewModel$Companion;", "", "()V", "TAG", "", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}