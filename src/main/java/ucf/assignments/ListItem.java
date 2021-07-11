package ucf.assignments;

public class ListItem {
    String name;
    String description;
    String dueDate;
    Boolean status;

    public void updateName(String newName){
        //Change name to new name
        name = newName;
    }

    public void updateDescription(String newDescription){
        //Change description to new descirption
        description = newDescription;
    }

    public void updateDueDate(String newDate){
        //Change date to new date
        dueDate = newDate;
    }

    public String toString(){
        String output = new String();
        //Set output to name, description, and due date
        output = "||" + name + "||" + description + "||" + dueDate;
        //Return output
        return "String";
    }
}
