package com.test.assignment.login.ui.login;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0010\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u0007H\u0002J\u0010\u0010!\u001a\u00020\u001f2\u0006\u0010\"\u001a\u00020\u0007H\u0002J\u0010\u0010#\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010&J\u0016\u0010\'\u001a\u00020$2\u0006\u0010\"\u001a\u00020\u00072\u0006\u0010 \u001a\u00020\u0007R\"\u0010\u0005\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\"\u0010\f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\t\"\u0004\b\u000e\u0010\u000bR\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00140\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00100\u0016\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0017\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00120\u0016\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0018R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00140\u0016\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0018R\u0018\u0010\u001d\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0014\u0018\u00010\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006("}, d2 = {"Lcom/test/assignment/login/ui/login/LoginViewModel;", "Landroidx/lifecycle/ViewModel;", "loginRepository", "Lcom/test/assignment/login/data/LoginRepository;", "(Lcom/test/assignment/login/data/LoginRepository;)V", "EmailAddress", "Landroidx/lifecycle/MutableLiveData;", "", "getEmailAddress", "()Landroidx/lifecycle/MutableLiveData;", "setEmailAddress", "(Landroidx/lifecycle/MutableLiveData;)V", "Password", "getPassword", "setPassword", "_data", "Lcom/test/assignment/login/ui/login/Data;", "_loginForm", "Lcom/test/assignment/login/ui/login/LoginFormState;", "_loginResult", "Lcom/test/assignment/login/ui/login/LoginResult;", "data", "Landroidx/lifecycle/LiveData;", "getData", "()Landroidx/lifecycle/LiveData;", "loginFormState", "getLoginFormState", "loginResult", "getLoginResult", "userMutableLiveData", "isPasswordValid", "", "password", "isUserNameValid", "username", "login", "", "view", "Landroid/view/View;", "loginDataChanged", "app_debug"})
public final class LoginViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull()
    private androidx.lifecycle.MutableLiveData<java.lang.String> EmailAddress;
    @org.jetbrains.annotations.NotNull()
    private androidx.lifecycle.MutableLiveData<java.lang.String> Password;
    private final androidx.lifecycle.MutableLiveData<com.test.assignment.login.ui.login.LoginFormState> _loginForm = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<com.test.assignment.login.ui.login.LoginFormState> loginFormState = null;
    private androidx.lifecycle.MutableLiveData<com.test.assignment.login.ui.login.LoginResult> userMutableLiveData;
    private final androidx.lifecycle.MutableLiveData<com.test.assignment.login.ui.login.LoginResult> _loginResult = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<com.test.assignment.login.ui.login.LoginResult> loginResult = null;
    private final androidx.lifecycle.MutableLiveData<com.test.assignment.login.ui.login.Data> _data = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<com.test.assignment.login.ui.login.Data> data = null;
    private final com.test.assignment.login.data.LoginRepository loginRepository = null;
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<java.lang.String> getEmailAddress() {
        return null;
    }
    
    public final void setEmailAddress(@org.jetbrains.annotations.NotNull()
    androidx.lifecycle.MutableLiveData<java.lang.String> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<java.lang.String> getPassword() {
        return null;
    }
    
    public final void setPassword(@org.jetbrains.annotations.NotNull()
    androidx.lifecycle.MutableLiveData<java.lang.String> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<com.test.assignment.login.ui.login.LoginFormState> getLoginFormState() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<com.test.assignment.login.ui.login.LoginResult> getLoginResult() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<com.test.assignment.login.ui.login.Data> getData() {
        return null;
    }
    
    public final void login(@org.jetbrains.annotations.Nullable()
    android.view.View view) {
    }
    
    public final void loginDataChanged(@org.jetbrains.annotations.NotNull()
    java.lang.String username, @org.jetbrains.annotations.NotNull()
    java.lang.String password) {
    }
    
    private final boolean isUserNameValid(java.lang.String username) {
        return false;
    }
    
    private final boolean isPasswordValid(java.lang.String password) {
        return false;
    }
    
    public LoginViewModel(@org.jetbrains.annotations.NotNull()
    com.test.assignment.login.data.LoginRepository loginRepository) {
        super();
    }
}