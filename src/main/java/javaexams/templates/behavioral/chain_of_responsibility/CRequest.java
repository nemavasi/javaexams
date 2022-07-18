package javaexams.templates.behavioral.chain_of_responsibility;

public class CRequest implements ClientRequest{

    private String name;

    public CRequest(String name) {
        this.name = name;
    }

    @Override
    public String getData() {
        return name;
    }
}
