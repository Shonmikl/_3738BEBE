package _2023_06_19.viper;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

//Entity
@Getter
@Setter
@AllArgsConstructor
public class Entity {
    private String username;
    private String password;
}

//Interactor
interface Interactor {
    void login(String username, String password);
}

//Presenter
@Getter
@Setter
@AllArgsConstructor
class Presenter {
    private View view;
    private Interactor interactor;
    private Routing routing;

    public void logingButton(String username, String password) {
    }
}

//Routing
interface Routing {
    void navigateToHome();
}

//View
interface View {
    void showLoading();

}