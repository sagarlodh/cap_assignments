import java.util.*;

class Chatroom{
    private String name;
    private Set<String> username;
    private List<String> messages;
    public Chatroom(){
        name = "";
        username = new HashSet<>();
        messages = new ArrayList<>();
    }
    public Chatroom(String name, Set<String> username, List<String> messages) {
        this.name = name;
        this.username = username;
        this.messages = messages;
    }
    public boolean removeUser(String username) {
        if(this.username.contains(username)) {
            this.username.remove(username);
            return true;
        }return false;
    }
    public void addUsername(String name) {
        if(username.contains(name)) {
            System.out.println("Entered user already Exists! ");
        }else { username.add(name); }
    }
    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return name;
    }
}

class User{
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    public User(String username, String password, String firstName, String lastName) {
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
class ChatApplication{
    private Map<String, Chatroom> chatrooms = new HashMap<>();
    private Map<String, User> users = new HashMap<>();
    private Set<String> loggedInUsers = new HashSet<>();
    public boolean isChatroomNameValid(String name) { return chatrooms.containsKey(name); }
    public boolean isUsernameExists(String username) { return users.containsKey(username); }
    public boolean authenticateUser(String username, String password) {
        User usr = users.get(username);
        if(usr != null) {
            if(usr.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }

    //UI Methods Below
    public void createChatroom() {
        Scanner scan = new Scanner(System.in);
        String chatRoomName;
        try {
            System.out.println("Enter Chat room Name : ");
            chatRoomName = scan.nextLine();
            if(isChatroomNameValid(chatRoomName)) {
                //Create new Chatroom
				Set<String> usr = new HashSet<>();
    			System.out.println("Enter Users");
    			while(scan.hasNext()) {
    				String user = scan.nextLine();
    				///check user
    				usr.add(user);
    			}
			   	Chatroom ch1 = new Chatroom();
            }else { System.out.println("ChatRoom name already exists or Not Valid!"); }
        }catch(Exception e) { e.printStackTrace(); }
    }
    public void addNewUser() {
        Scanner sc = new Scanner(System.in);
        String uName;
        try {
            System.out.println("Enter user name");
            uName = sc.nextLine();
            if(isUsernameExists(uName)) {
                System.out.println("User name Already exists");
            }else {
                //Add new user
            }
        }catch(Exception e) { e.printStackTrace(); }
    }
    public void login() { /*check name and password and if correct then login*/}
    public void sendMessage() { /* send message */}
    public void printMessages() { /* print message */}
    public void logout() {/* logout */}
    public void deleteUser() {/*check user exists or not and delete if there*/ }
    public void deleteChatroom() {/*check if room exists or not and delete if there*/}
    public void listUsersFromChatroom() {
        Map<String, User> users = new HashMap<>();
        for(HashMap.Entry<String,User> entry : users.entrySet()) {
            System.out.println(entry.getKey());
        }
    }
    public void menu() {
        System.out.println("Java Chat Application");
        System.out.println("```````````````````````````");
        System.out.println("A) Create chatroom");
        System.out.println("B) Add the user");
        System.out.println("C) User login");
        System.out.println("D) Send a message");
        System.out.println("E) Display the messages from a specific chatroom");
        System.out.println("F) List down all users belonging to the specified chat room");
        System.out.println("G) Logout");
        System.out.println("H) Delete an user");
        System.out.println("I) Delete the chat room");
        System.out.println("Please enter your option :");
        Scanner scan = new Scanner(System.in);
        String ch = null;
        try {
            ch = scan.next();
            ch = ch.toUpperCase();
        }catch(Exception e) { e.printStackTrace(); }
        switch (ch) {
            case "A" -> createChatroom();
            case "B" -> addNewUser();
            case "C" -> login();
            case "D" -> sendMessage();
            case "E" -> printMessages();
            case "F" -> listUsersFromChatroom();
            case "G" -> logout();
            case "H" -> deleteUser();
            case "I" -> deleteChatroom();
            default -> System.out.println("Invalid !");
        }
    }
}
public class Assignment3Q6{
    public static void main(String[] args){
        ChatApplication obj = new ChatApplication();
        obj.menu();
        System.out.println(obj.authenticateUser("", ""));
    }
}