package models.bookstore;

import lombok.Data;

@Data
public class CredentialModel {
    String userName;
    String password;

    public CredentialModel() {}

    public CredentialModel(String password) {
        this.password = password;
    }
}
