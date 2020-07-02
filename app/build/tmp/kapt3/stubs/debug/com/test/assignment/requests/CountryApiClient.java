package com.test.assignment.requests;

import java.lang.System;

/**
 * @author swapnil-tml on 26-06-2020.
 */
@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u0000 \u001a2\u00020\u0001:\u0002\u001a\u001bB\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\u0017\u001a\u00020\u0018J\u0006\u0010\u0019\u001a\u00020\u0018R \u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001f\u0010\n\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\f0\u000b8F\u00a2\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u0019\u0010\u000f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00100\u000b8F\u00a2\u0006\u0006\u001a\u0004\b\u0011\u0010\u000eR\u001c\u0010\u0012\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\f0\u0013X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0014\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00100\u0013X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0015\u001a\b\u0018\u00010\u0016R\u00020\u0000X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001c"}, d2 = {"Lcom/test/assignment/requests/CountryApiClient;", "", "()V", "arrayListDetails", "Ljava/util/ArrayList;", "Lcom/test/assignment/models/Country;", "getArrayListDetails", "()Ljava/util/ArrayList;", "setArrayListDetails", "(Ljava/util/ArrayList;)V", "category", "Landroidx/lifecycle/LiveData;", "", "getCategory", "()Landroidx/lifecycle/LiveData;", "countryName", "", "getCountryName", "mCategory", "Landroidx/lifecycle/MutableLiveData;", "mCountryName", "mRetrieveCountryRunnable", "Lcom/test/assignment/requests/CountryApiClient$RetrieveCountryRunnable;", "cancelRequest", "", "countryDetailApi", "Companion", "RetrieveCountryRunnable", "app_debug"})
public final class CountryApiClient {
    private final androidx.lifecycle.MutableLiveData<java.util.List<com.test.assignment.models.Country>> mCategory = null;
    private final androidx.lifecycle.MutableLiveData<java.lang.String> mCountryName = null;
    private com.test.assignment.requests.CountryApiClient.RetrieveCountryRunnable mRetrieveCountryRunnable;
    @org.jetbrains.annotations.NotNull()
    private java.util.ArrayList<com.test.assignment.models.Country> arrayListDetails;
    private static final java.lang.String TAG = "RecipeApiClient";
    @org.jetbrains.annotations.Nullable()
    private static com.test.assignment.requests.CountryApiClient instance;
    public static final com.test.assignment.requests.CountryApiClient.Companion Companion = null;
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.ArrayList<com.test.assignment.models.Country> getArrayListDetails() {
        return null;
    }
    
    public final void setArrayListDetails(@org.jetbrains.annotations.NotNull()
    java.util.ArrayList<com.test.assignment.models.Country> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.util.List<com.test.assignment.models.Country>> getCategory() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.lang.String> getCountryName() {
        return null;
    }
    
    public final void countryDetailApi() {
    }
    
    public final void cancelRequest() {
    }
    
    private CountryApiClient() {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    public static final com.test.assignment.requests.CountryApiClient getInstance() {
        return null;
    }
    
    private static final void setInstance(com.test.assignment.requests.CountryApiClient p0) {
    }
    
    @kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0005J\b\u0010\u0006\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\bH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\t"}, d2 = {"Lcom/test/assignment/requests/CountryApiClient$RetrieveCountryRunnable;", "Ljava/lang/Runnable;", "(Lcom/test/assignment/requests/CountryApiClient;)V", "cancelRequest", "", "", "run", "call", "Lokhttp3/Call;", "app_debug"})
    final class RetrieveCountryRunnable implements java.lang.Runnable {
        private boolean cancelRequest = false;
        
        @java.lang.Override()
        public void run() {
        }
        
        private final void run(okhttp3.Call call) {
        }
        
        public final void cancelRequest() {
        }
        
        public RetrieveCountryRunnable() {
            super();
        }
    }
    
    @kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R0\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u00068F@BX\u0087\u000e\u00a2\u0006\u0014\n\u0000\u0012\u0004\b\b\u0010\u0002\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\f\u00a8\u0006\r"}, d2 = {"Lcom/test/assignment/requests/CountryApiClient$Companion;", "", "()V", "TAG", "", "<set-?>", "Lcom/test/assignment/requests/CountryApiClient;", "instance", "instance$annotations", "getInstance", "()Lcom/test/assignment/requests/CountryApiClient;", "setInstance", "(Lcom/test/assignment/requests/CountryApiClient;)V", "app_debug"})
    public static final class Companion {
        
        @java.lang.Deprecated()
        public static void instance$annotations() {
        }
        
        @org.jetbrains.annotations.Nullable()
        public final com.test.assignment.requests.CountryApiClient getInstance() {
            return null;
        }
        
        private final void setInstance(com.test.assignment.requests.CountryApiClient p0) {
        }
        
        private Companion() {
            super();
        }
    }
}