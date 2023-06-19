package _2023_06_19.vip;

public interface LoginView {
    void showLoading();
    void hideLoading();
    void showErrorMessage(String message);
    void showSuccessMessage(String message);
}

//Interactor
interface LoginInteractor {
    void login(String username, String password);
}

//Presenter
class LoginPresenter implements LoginInteractor {
    private LoginView view;

    public LoginPresenter(LoginView view) {
        this.view = view;
    }


    @Override
    public void login(String username, String password) {
        view.showLoading();

        if("admin".equals(username) && "pass".equals(password)) {
            view.hideLoading();
            view.showSuccessMessage("Success");
        } else {
            view.hideLoading();
            view.showErrorMessage("Error");
        }
    }
}

//Класс представления
class LoginActivity implements LoginView {
    private LoginPresenter presenter;

    public LoginActivity() {
        presenter = new LoginPresenter(this);
    }

    public void onLoginButtonClicked(String username, String password) {
        presenter.login(username, password);
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void showErrorMessage(String message) {

    }

    @Override
    public void showSuccessMessage(String message) {

    }
}

class Main {
    public static void main(String[] args) {
        LoginActivity loginActivity = new LoginActivity();
        loginActivity.onLoginButtonClicked("admin", "pass");
    }
}