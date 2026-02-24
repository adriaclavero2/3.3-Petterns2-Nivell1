package interfaces;

public interface EntrantConfigStep {
    EntrantConfigStep isVegan();
    EntrantConfigStep isGlutenFree();
    MainCourseConfigStep withMainCourse(String name);
}