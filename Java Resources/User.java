import java.util.List;
import java.util.ArrayList;

// Base class for all types of users
class User {
    private Integer userID;
    private String username;
    private String password;
    private String email;
    private String profileType;

    public User(Integer userID, String username, String password, String email, String profileType) {
        this.userID = userID;
        this.username = username;
        this.password = password;
        this.email = email;
        this.profileType = profileType;
    }

    public Integer getUserID() {
        return userID;
    }

    public void setUserID(Integer userID) {
        this.userID = userID;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getProfileType() {
        return profileType;
    }

   public void setProfileType(String profileType) {
        this.profileType = profileType; // this determines access to specific tables in database
    }

    public boolean login() {
        // Placeholder for login logic, will need to call a validation function to check database
        return true;
    }

    public void logout() {
        // Placeholder for logout logic, load the login page cut access to database/set user inactive
        // inactive user signifies the user no longer has access to database: any posts, reviews, their favorites etc.
    }
}


// Renter class that extends User
class Renter extends User {
    private List<Post> favoriteProperties;
    private double budget;

    public Renter(Integer userID, String username, String password, String email, String profileType, double budget) {
        super(userID, username, password, email, profileType);
        this.favoriteProperties = new ArrayList<>();
        this.budget = budget;
    }

    public List<Post> getFavoriteProperties() {
        return new ArrayList<>(favoriteProperties);
    }

    public void addFavorite(Post property) {
        favoriteProperties.add(property);
    }

    public void removeFavorite(Post property) {
        favoriteProperties.remove(property);
    }

    public double getBudget() {
        return budget;
    }

    public void setBudget(double budget) {
        this.budget = budget;
    }

    public List<Post> searchProperties() {
        // Placeholder for property search logic
        // Need to access database of properties
        // Filter properties based on user budger
        return new ArrayList<>();
    }

    public void leaveReview(Post property, Review review) {
        // need to integrate with Post class, adds a review to the Review list
        property.addReview(review);
    }
}



// Subletter class that extends User
class Subletter extends User {
    private List<Post> properties;

    public Subletter(Integer userID, String username, String password, String email, String profileType) {
        super(userID, username, password, email, profileType);
        properties = new ArrayList<>();
    }

    public List<Post> getProperties() {
        return new ArrayList<>(properties);
    }

    public void addListing(Post property) {
        properties.add(property);
    }

    public void removeListing(Post property) {
        properties.remove(property);
    }

    public void editListing(Post property) {
        // Placeholder for editing property details
        // post details in database must be edited too
    }
}