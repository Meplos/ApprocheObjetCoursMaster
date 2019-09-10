package fr.ubordeaux.ao;

import java.util.Iterator;

/** TODO: Faire un singleton, mais la j'ai la flemme */
public class SearchEngine{

    private static SearchEngine instance = null;
    ContactSet repertory;

    SearchEngine(){}

    public static SearchEngine getInstance(){
        if ( instance == null) {
            instance = new SearchEngine();
        }
        return instance;
    }

    public void setRepertory(ContactSet set){
        this.repertory = set;
    }
    public Contact search(String name, String firstName){

        Iterator<Contact> it = repertory.getContactSet(0, repertory.size()).iterator();
        while(it.hasNext()){
            Contact current = it.next();
            if(current.getFirstName() == firstName && current.getSecondName() == name){
                return current;
            }
            else if (current.getSecondName() == name) {
                return current;
            }
            else {}
        }
        
        return null;
        
    }

}