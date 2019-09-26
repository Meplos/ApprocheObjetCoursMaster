package fr.ubordeaux.ao;

public class Main {
    private static  final int MAX = 3000;
    public static void main(String[] args) {
        ContactSet contactSet = new ContactSet();
        TownSet townSet = TownSet.getInstance();
        for (int i = 0 ; i < MAX ; i++) {
            Town  town = (Town) townSet.getTownSet(i, i).toArray()[0];
            Address address = new Address(351, "Cours de la libération",town);
            Contact newContact = new Contact("John", "Do", address);
            contactSet.addContact(newContact);
        }
        System.out.println(MAX+" contacts created !");
        
        SearchEngine sEngine = SearchEngine.getInstance();
        sEngine.setRepertory(contactSet);

        Contact c = sEngine.search("Do", "John");
        
        System.out.print(c);
        try {
            Thread.sleep(200000);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        
        
    }

    /**
     * Town town1 = new Town("Talence","33400"); 
     * Town town2 = new Town("Talence","33400");
     * Ceci est possible
     */

     /**
      * boolean eg1 = (town1 == town2) : faux ==> java compare les adresse
      * boolean eg2 = town1.equals(town2) : vrai ==> la fonction equals va comparer les parametres, type, etc...
      */

      /** Il y a 9001 instance occupying 228008 bytes. (excluding platform) */
      /** Total of 55124 instances occupying 2559680 bytes. (including platform) */
}