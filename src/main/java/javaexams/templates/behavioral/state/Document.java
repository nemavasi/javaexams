package javaexams.templates.behavioral.state;

public class Document {

    private IState state;

    public Document() {
        this.state = new DraftState();
    }

    public void changeState(IState state){
        this.state = state;
    }

    public void print(){
        state.print();
    }
}
