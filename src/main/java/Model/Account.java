
package Model;


public class Account {

    private int userId;
    private String userName;
    private String userPassword;
    private String userGmail;
    private byte[] UserAvatar;

    public static Account instance;

    private static boolean isInitiallized = false;

    public static void Init() {
        if (isInitiallized == true) {
            return;
        }
        instance = new Account();
        isInitiallized = true;
    }

    public Account(String name, String pass, String gmail) {
        this(name, pass, gmail, null);
    }

    public Account(int UserId, String name, String pass, String gmail) {
        this(UserId, name, pass, gmail, null);
    }

    public Account(int UserId, String userName, String userPassword, String userGmail, byte[] UserAvatar) {
        this.userId = UserId;
        this.userName = userName;
        this.userPassword = userPassword;
        this.userGmail = userGmail;
        this.UserAvatar = UserAvatar;
    }

    public Account(String userName, String userPassword, String userGmail, byte[] UserAvatar) {
        this.userName = userName;
        this.userPassword = userPassword;
        this.userGmail = userGmail;
        this.UserAvatar = UserAvatar;
    }

    public Account() {
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserGmail() {
        return userGmail;
    }

    public void setUserGmail(String userGmail) {
        this.userGmail = userGmail;
    }

    public byte[] getAvatarUser() {
        return UserAvatar;
    }

    public void setAvatarUser(byte[] UserAvatar) {
        this.UserAvatar = UserAvatar;
    }

    @Override
    public String toString() {
        return "Account{" + "userId=" + userId + ", userName=" + userName + ", userPassword=" + userPassword + ", userGmail=" + userGmail + ", UserAvatar=" + UserAvatar + '}';
    }


}

