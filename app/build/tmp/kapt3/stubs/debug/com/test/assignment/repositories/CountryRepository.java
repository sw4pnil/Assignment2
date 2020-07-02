package com.test.assignment.repositories;

import java.lang.System;

/**
 * @author swapnil-tml on 26-06-2020.
 * repository for API data handle
 */
@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\u000e\u001a\u00020\u000fJ\u0006\u0010\u0010\u001a\u00020\u000fJ\u0006\u0010\u0011\u001a\u00020\u000fR!\u0010\u0003\u001a\u0012\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0018\u00010\u00048F\u00a2\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u001b\u0010\t\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\n\u0018\u00010\u00048F\u00a2\u0006\u0006\u001a\u0004\b\u000b\u0010\bR\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0013"}, d2 = {"Lcom/test/assignment/repositories/CountryRepository;", "", "()V", "categoryName", "Landroidx/lifecycle/LiveData;", "", "Lcom/test/assignment/models/Country;", "getCategoryName", "()Landroidx/lifecycle/LiveData;", "countryName", "", "getCountryName", "mCountryApiClient", "Lcom/test/assignment/requests/CountryApiClient;", "cancelRequest", "", "countryDetailApi", "searchNextPage", "Companion", "app_debug"})
public final class CountryRepository {
    private final com.test.assignment.requests.CountryApiClient mCountryApiClient = null;
    @org.jetbrains.annotations.Nullable()
    private static com.test.assignment.repositories.CountryRepository instance;
    public static final com.test.assignment.repositories.CountryRepository.Companion Companion = null;
    
    @org.jetbrains.annotations.Nullable()
    public final androidx.lifecycle.LiveData<java.util.List<com.test.assignment.models.Country>> getCategoryName() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final androidx.lifecycle.LiveData<java.lang.String> getCountryName() {
        return null;
    }
    
    public final void countryDetailApi() {
    }
    
    public final void searchNextPage() {
    }
    
    public final void cancelRequest() {
    }
    
    private CountryRepository() {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R*\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00048F@BX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t\u00a8\u0006\n"}, d2 = {"Lcom/test/assignment/repositories/CountryRepository$Companion;", "", "()V", "<set-?>", "Lcom/test/assignment/repositories/CountryRepository;", "instance", "getInstance", "()Lcom/test/assignment/repositories/CountryRepository;", "setInstance", "(Lcom/test/assignment/repositories/CountryRepository;)V", "app_debug"})
    public static final class Companion {
        
        @org.jetbrains.annotations.Nullable()
        public final com.test.assignment.repositories.CountryRepository getInstance() {
            return null;
        }
        
        private final void setInstance(com.test.assignment.repositories.CountryRepository p0) {
        }
        
        private Companion() {
            super();
        }
    }
}