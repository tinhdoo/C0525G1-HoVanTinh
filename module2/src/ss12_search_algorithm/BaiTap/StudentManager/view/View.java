package ss12_search_algorithm.BaiTap.StudentManager.view;

import ss12_search_algorithm.BaiTap.StudentManager.controller.StudentController;

public class View {
    public static void main(String[] args) {
        StudentController studentController = new StudentController();
        studentController.displayMenu();
    }
}
