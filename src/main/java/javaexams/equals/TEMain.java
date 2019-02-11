package javaexams.equals;

class TEMain {
    public static void main(String[] args) {
        Integer i = new Integer("3");
        if (i.toString() == i.toString()) {
            System.out.println("equal");
        } else {
            System.out.println("not equal");
        }
        //not equal
    }
}
