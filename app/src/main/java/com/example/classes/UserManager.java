package com.example.classes;

public class UserManager {

        private static User currentUser;

        public static void setUser(User user) {
            currentUser = user;
        }

        public static User getUser() {
            return currentUser;
        }

}
