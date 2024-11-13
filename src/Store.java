import java.util.ArrayList;

class Store {
    // ArrayList to store all items in the store
    private ArrayList<CISItem> cisItems = new ArrayList<>();

    // Method to add a Book to the store
    public void addBook(Book book) {
        // Add the Book object after upcasting it to CISItem
        cisItems.add(book);
    }

    // Method to add a Phone to the store
    public void addPhone(Phone phone) {

        cisItems.add(phone);
    }

    // Method to add a Magazine to the store
    public void addMagazine(Magazine magazine) {

        cisItems.add(magazine);
    }

    // Method to add an Arduino to the store
    public void addArduino(Arduino arduino) {

        cisItems.add(arduino);
    }
    public void updatePhonesLocation(String location) {
        for (CISItem item : cisItems) {
            if (item instanceof Phone) {
                item.setLocation(location);
            }
        }
    }

    public ArrayList<Phone> getAllPhones(){
        ArrayList<Phone> allPhones = new ArrayList<>();
        for(CISItem item : cisItems){
            if(item instanceof Phone){
                allPhones.add((Phone)item);
            }
        }
        return allPhones;
    }

    public ArrayList<Magazine> getAllMagazines(){
        ArrayList<Magazine> allMagazines = new ArrayList<>();
        for(CISItem item : cisItems){
            if(item instanceof Magazine){
                allMagazines.add((Magazine) item);
            }
        }
        return allMagazines;
    }
    public ArrayList<Arduino> getAllArduinos(){
        ArrayList<Arduino> allArduinos = new ArrayList<>();
        for(CISItem item : cisItems){
            if(item instanceof Arduino){
                allArduinos.add((Arduino) item);
            }
        }
        return allArduinos;
    }
    // Method to add a CISItem to the store
    public void addItems(CISItem cisItem) {
        cisItems.add(cisItem);
    }
    public ArrayList<CISItem> getItems(String itemType) {
        // Create a new ArrayList to store items of the specified type
        ArrayList<CISItem> items = new ArrayList<>();
        // Loop through all items in the store
        for (CISItem item : cisItems) {
            // Check if the item's type matches the specified type and add it to the list
            if (item.getClass().getSimpleName().equalsIgnoreCase(itemType)) {
                items.add(item);
            }
        }
        return items;
    }
    public void updateItems(String itemType, String property, String value) {
        // Loop through all items in the store
        for (CISItem item : cisItems) {
            if(item.getClass().getSimpleName().equalsIgnoreCase(itemType)) { //gets original class, name and then checks if its equal to item type

                if (property.equals("location")) {
                    item.setLocation(value); //finish the rest of CIS item
                } else if (property.equals("name")) {
                    item.setName(value);
                }else if (property.equals("description")) {
                    item.setDescription(value);
                } else if (property.equals("price")) {
                    item.setPrice(Integer.parseInt(value));
                }

                else if (item instanceof ElectronicItem) {
                    ElectronicItem newItem = (ElectronicItem) item;
                    if (property.equals("storageCapacity")) {
                        newItem.setStorageCapacity(Integer.parseInt(value));
                    }
                    else if (property.equals("model")) {
                        newItem.setModel(value);
                    }
                    else if (property.equals("maker")) {
                        newItem.setMaker(value);
                    }
                    else if (property.equals("operatingSystem")) {
                        newItem.setOperatingSystem(value);
                    }
                }

                else if (item instanceof ReadingItem) {
                    ReadingItem newItem = (ReadingItem) item;
                    if (property.equals("datePublished")) {
                        newItem.setDatePublished(value);
                    }
                    else if (property.equals("author")) {
                        newItem.setAuthor(value);
                    }
                    else if (property.equals("wordCount")) {
                        newItem.setWordCount(Integer.parseInt(value));
                    }
                }

                else if(item instanceof Book){
                    Book newItem = (Book) item;
                    if(property.equals("isbn")){
                        newItem.setIsbn(value);
                    }
                    else if(property.equals("edition")){
                        newItem.setEdition(value);
                    }
                    else if(property.equals("title")){
                        newItem.setTitle(value);
                    }
                }
            }
        }
    }
    // Method to display information of all items in the store
    public void showAllInfo() {
        for (CISItem item : cisItems) {
            System.out.println(cisItems);
        }
    }
}