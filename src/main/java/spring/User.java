package spring;

import org.springframework.stereotype.Component;

@Component(value = "user")
public class User {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
