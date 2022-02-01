package com.example.authenticationapp;

import androidx.annotation.NonNull;

import com.google.firebase.FirebaseException;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;

public class mCallbacks extends PhoneAuthProvider.OnVerificationStateChangedCallbacks {
    @Override
    public void onVerificationCompleted(@NonNull PhoneAuthCredential phoneAuthCredential) {

    }}

