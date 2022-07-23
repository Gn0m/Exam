package Model.Singleton;

import Model.User;

public class UserSingleton {

    private static User user;
    private static int id;
    private static boolean auth;

    public static boolean isAuth() {
        return auth;
    }

    public static void setAuth(boolean auth) {
        UserSingleton.auth = auth;
    }

    public static User getUser() {
        return user;
    }

    public static void setUser(User user) {
        UserSingleton.user = user;
    }

    public static void setId(int id) {
        UserSingleton.id = id;
    }

    public static int getId() {
        return id;
    }
}
