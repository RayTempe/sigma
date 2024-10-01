package com.example.a2k.ui.login;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import android.util.Patterns;

import com.example.a2k.data.LoginRepository;
import com.example.a2k.data.Result;
import com.example.a2k.data.model.LoggedInUser;
import com.example.a2k.R;

public class LoginViewModel extends ViewModel {

    private final MutableLiveData<LoginFormState> loginFormState = new MutableLiveData<>();
    private final MutableLiveData<LoginResult> loginResult = new MutableLiveData<>();
    private final LoginRepository loginRepository;

    // Constructor
    public LoginViewModel(LoginRepository loginRepository) {
        this.loginRepository = loginRepository;
    }

    // Getter for loginFormState
    public LiveData<LoginFormState> getLoginFormState() {
        return loginFormState;
    }

    // Getter for loginResult
    public LiveData<LoginResult> getLoginResult() {
        return loginResult;
    }

    // Method for logging in the user
    public void login(String username, String password) {
        // Launch login logic in a separate asynchronous job (already done in repository)
        Result<LoggedInUser> result = loginRepository.login(username, password);

        if (result instanceof Result.Success) {
            // If login is successful, pass the user data to loginResult
            LoggedInUser data = ((Result.Success<LoggedInUser>) result).getData();
            loginResult.setValue(new LoginResult(new LoggedInUserView(data.getDisplayName())));
        } else {
            // If login fails, pass an error message
            loginResult.setValue(new LoginResult(R.string.app_name));
        }
    }

    // Method to check if the input data has changed and if it's valid
    public void loginDataChanged(String username, String password) {
        if (!isUserNameValid(username)) {
            loginFormState.setValue(new LoginFormState(R.string.app_name, null));
        } else if (!isPasswordValid(password)) {
            loginFormState.setValue(new LoginFormState(null, R.string.app_name));
        } else {
            loginFormState.setValue(new LoginFormState(true));
        }
    }

    // Method to validate the username
    private boolean isUserNameValid(String username) {
        if (username == null || username.trim().isEmpty()) {
            return false; // Username should not be null or empty
        }
        if (username.contains("@")) {
            // If the username contains '@', validate it as an email address
            return Patterns.EMAIL_ADDRESS.matcher(username).matches();
        } else {
            // If it's not an email, check that it's not empty
            return !username.trim().isEmpty();
        }
    }

    // Method to validate the password
    private boolean isPasswordValid(String password) {
        // Password should be at least 6 characters long and not null
        return password != null && password.trim().length() > 5;
    }
}
