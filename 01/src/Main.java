class Main {
    public static void main(String args[]) {
        File file = new File();
        Change change = new Change(file.readToArray());
        change.start();
    }
}
