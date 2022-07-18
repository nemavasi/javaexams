package javaexams.templates.structural.facade;

public class CodeClient {

    public static void main(String[] args) {
        WorkerFacade workerFacade = new Worker();
        workerFacade.work();
    }

}
