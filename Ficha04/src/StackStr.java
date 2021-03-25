import java.util.ArrayList;

public class StackStr {
    private ArrayList<String> stack;

    public StackStr(){
        this.stack = new ArrayList<String>();
    }

    public StackStr(StackStr s){
        this.setStack(s.getStack());
    }

    public boolean equals(Object o){
        if (this == o) return true;
        else if (o == null || this.getClass() != o.getClass()) return false;
        StackStr s = (StackStr) o;
        return (this.stack.equals(s.getStack()));
    }

    public StackStr clone(){
        return new StackStr(this);
    }

    public String toString(){
        return this.stack.toString();
    }

    public ArrayList<String> getStack() {
        return this.stack;
    }

    public void setStack(ArrayList<String> stack) {
        this.stack = new ArrayList<String>();
        this.stack.addAll(stack);
    }

    public String top(){
        return (this.stack.get(stack.size() - 1));
    }

    public void push(String s){
        this.stack.add(s);
    }

    public void pop(){
        if (!this.stack.isEmpty()) this.stack.remove(this.stack.size() - 1);
    }

    public boolean empty(){
        return this.stack.isEmpty();
    }

    public int length(){
        return this.stack.size();
    }
}
