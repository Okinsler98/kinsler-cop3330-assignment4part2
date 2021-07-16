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

    public void changeStatus(boolean  newStatus){
        //Invert boolean
        status = newStatus;
    }
}
